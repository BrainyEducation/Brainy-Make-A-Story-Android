package com.example.make_a_story_prototype.main.data.MasteredWords;

import android.content.Context;

import com.example.make_a_story_prototype.main.StoryTemplate.view.ObservableScrollView;
import com.example.make_a_story_prototype.main.Wordbank.view.WordbankItemRecyclerViewAdapter;
import com.example.make_a_story_prototype.main.Wordbank.vm.WordCardItemViewModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.subjects.BehaviorSubject;

public class DebugMasteredWordsRepository implements MasteredWordsRepository {

    private static DebugMasteredWordsRepository instance;

    public static void initialize(Context context) throws IOException {
        if (instance != null) {
            throw new RuntimeException("already created");
        }

        instance = new DebugMasteredWordsRepository(context);
    }

    public static DebugMasteredWordsRepository getInstance() {
        return instance;
    }

    private Context context;
    private File masteredWordsFile;
    private Set<Integer> masteredWordIds = new HashSet<>();

    private DebugMasteredWordsRepository(Context context) throws IOException {
        this.context = context;

        masteredWordsFile = context.getFileStreamPath("unlockedWords.csv");
        if (!masteredWordsFile.exists()) {
            masteredWordsFile.createNewFile();
        }

        loadFromFile();
    }

    @Override
    public Single<Boolean> isMastered(int wordId) {
        return Single.just(masteredWordIds.contains(wordId));
    }

    @Override
    public void setMastered(int wordId) {
        masteredWordIds.add(wordId);
        writeToFile();
    }

    private void loadFromFile() throws IOException {
        masteredWordIds.clear();

        FileInputStream in = context.openFileInput("unlockedWords.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line;

        while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] unlockedWordsArray = line.split(",");
            for (String wordIdString : unlockedWordsArray) {
                try {
                    Integer wordId = Integer.parseInt(wordIdString);
                    masteredWordIds.add(wordId);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        inputStreamReader.close();
    }

    private void writeToFile() {
        try {
            FileWriter fw = new FileWriter(masteredWordsFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            StringBuilder builder = new StringBuilder();
            for (Integer masteredWordId : masteredWordIds) {
                builder.append(masteredWordId + ",");
            }

            bw.write(builder.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
