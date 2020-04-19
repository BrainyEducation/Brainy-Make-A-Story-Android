package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.make_a_story_prototype.R;
import com.example.make_a_story_prototype.main.StoryTemplate.vm.StoryViewModel;

import androidx.viewpager.widget.PagerAdapter;

public class StoryPageAdapter extends PagerAdapter {

    private Context context;
    private StoryViewModel vm;

    public StoryPageAdapter(Context context, StoryViewModel vm) {
        super();

        this.context = context;
        this.vm = vm;
    }

    @Override
    public int getCount() {
        return vm.getStory().getPages().size();
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        Log.d("TAG", "instantiateItem: vm info:" + vm.getStory().getTitle() + " on page " + vm.getPageNumber() + " and story audio resource " + vm.getNextAudioSegmentIndex() );
        StoryPageView pageView = (StoryPageView) inflater.inflate(R.layout.story_page, collection, false);
        pageView.setViewModel(vm, position);
        collection.addView(pageView);

        return pageView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return vm.getStory().getTitle();
    }

}
