package com.example.make_a_story_prototype.main.StoryTemplate.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;
import com.example.make_a_story_prototype.main.data.Story.model.StoryBlankIdentifier;
import com.example.make_a_story_prototype.main.data.Story.model.StoryPage;
import com.example.make_a_story_prototype.main.data.Story.model.StorySegment;
import com.example.make_a_story_prototype.main.data.Story.model.StoryText;
import com.example.make_a_story_prototype.main.data.StoryTemplateSelections.model.BlankSelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StoryMediaController implements MediaPlayer.OnCompletionListener {

    public interface ProgressListener {
        void onPlayerProgressChange(float progress);
    }

    private android.media.MediaPlayer mediaPlayer;
    private Timer timer;

    private Context context;
    private StoryPage page;
    private StoryViewModel vm;

    private List<Integer> durationsMs;
    private Integer totalDurationMs;

    private int nextSegmentSeekedPosition;
    private int nextSegmentIndex;

    private ProgressListener listener;

    public StoryMediaController(Context context, StoryPage page, StoryViewModel vm) {
        this.context = context;
        this.page = page;
        this.vm = vm;
        this.nextSegmentIndex = 0;

        calculateDurations();
    }

    public void setProgressListener(ProgressListener listener) {
        this.listener = listener;
    }

    public void play() {
        nextSegmentSeekedPosition = 0;

        if (mediaPlayer == null) {
            playNextSegment();
        } else if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }

    public void pause() {
        nextSegmentSeekedPosition = 0;

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            stopProgressUpdates();
        }
    }

    public void rewind() {
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }

        int position = Math.max(0, currentPosition() - 15000);

        destroyCurrentPlayer();

        setupSeekOperation(position);
        playNextSegment();
    }

    private void playNextSegment() {
        destroyCurrentPlayer();

        if (nextSegmentIndex >= page.getSegments().size()) {
            return;
        }

        StorySegment nextSegment = page.getSegments().get(nextSegmentIndex);
        int nextResource = 0;

        if (nextSegment instanceof StoryText) {
            StoryText textSegment = (StoryText) nextSegment;
            nextResource = textSegment.getAudioResource();
        } else if (nextSegment instanceof StoryBlankIdentifier) {
            StoryBlankIdentifier identifier = (StoryBlankIdentifier) nextSegment;
            BlankSelection selection = vm.getSelections().get(identifier.get());

            if (selection == null) {
                pause();
                nextSegmentIndex = Math.max(0, nextSegmentIndex - 1);
                nextSegmentSeekedPosition = 0;
                return;
            } else {
                nextResource = selection.getAudioResource();
            }
        }

        mediaPlayer = MediaPlayer.create(context, nextResource);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.start();
        if (nextSegmentSeekedPosition != 0) {
            mediaPlayer.seekTo(nextSegmentSeekedPosition);
        }

        enqueueProgressUpdate();

        nextSegmentIndex += 1;
        nextSegmentSeekedPosition = 0;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        playNextSegment();
    }

    private void calculateDurations() {
        this.durationsMs = new ArrayList<>();
        this.totalDurationMs = 0;

        for (StorySegment segment : page.getSegments()) {
            if (segment instanceof StoryText) {
                StoryText textSegment = (StoryText) segment;
                int resource = textSegment.getAudioResource();

                MediaPlayer mp = MediaPlayer.create(context, resource);
                int durationMs = mp.getDuration();

                durationsMs.add(durationMs);
                totalDurationMs += durationMs;
            } else {
                durationsMs.add(2000);
                totalDurationMs += 2000;
            }
        }
    }

    private void enqueueProgressUpdate() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                stopProgressUpdates();

                if (listener == null) {
                    return;
                }

                int position = currentPosition();
                listener.onPlayerProgressChange(position / (float) totalDurationMs);

                enqueueProgressUpdate();
            }
        }, 100);
    }

    private void setupSeekOperation(int position) {
        int seekedNextSegmentIndex = 0;
        int cumulativeDuration = 0;
        int nextSegmentDuration = durationsMs.get(0);

        while (cumulativeDuration + nextSegmentDuration < position) {
            cumulativeDuration += nextSegmentDuration;
            seekedNextSegmentIndex += 1;
            nextSegmentDuration = durationsMs.get(seekedNextSegmentIndex);
        }

        this.nextSegmentIndex = seekedNextSegmentIndex;
        this.nextSegmentSeekedPosition = position - cumulativeDuration;
    }

    private int currentPosition() {
        int currentPosition = 0;
        for (int segmentIndex = 0; segmentIndex < nextSegmentIndex - 1; segmentIndex += 1) {
            currentPosition += durationsMs.get(segmentIndex);
        }

        if (mediaPlayer != null) {
            try {
                currentPosition += mediaPlayer.getCurrentPosition();
            } catch(Exception e) {
                Log.d("StoryMediaController", "position broke");
            }
        }

        return currentPosition;
    }

    private void destroyCurrentPlayer() {
        if (mediaPlayer == null) {
            return;
        }

        mediaPlayer.setOnCompletionListener(null);
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

        stopProgressUpdates();
    }

    private void stopProgressUpdates() {
        if (timer == null) {
            return;
        }

        timer.cancel();
        timer.purge();
        timer = null;
    }
}
