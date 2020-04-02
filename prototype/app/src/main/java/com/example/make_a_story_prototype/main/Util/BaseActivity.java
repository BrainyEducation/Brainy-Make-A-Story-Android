package com.example.make_a_story_prototype.main.Util;

import com.example.make_a_story_prototype.main.Brainy.BrainyApplication;
import com.example.make_a_story_prototype.main.Navigation.NavigationController;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public NavigationController getNavigationController() {
        return ((BrainyApplication)getApplication()).navigationController;
    }

    public NavigationController.NavigationContext getNavigationContext() {
        return getNavigationController().context;
    }

    public void setNavigationContext(NavigationController.NavigationContext context) {
        getNavigationController().context = context;
    }

}
