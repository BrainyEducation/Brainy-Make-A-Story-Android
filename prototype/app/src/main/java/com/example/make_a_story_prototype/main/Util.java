package com.example.make_a_story_prototype.main;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.WindowManager;

import com.example.make_a_story_prototype.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Util {
    public static void themeStatusBar(Activity activity, boolean isDark) {
        // workaround for status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            if (isDark) {
                activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark));

            } else {
                activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, R.color.colorWhite));
            }
        }
    }

    public static void addBackArrow(AppCompatActivity activity) {
        // back arrow to left
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public static Drawable setDrawableToGrayscale(Drawable d) {
        d.mutate();

        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        d.setColorFilter(filter);

        return d;
    }

    public static Drawable changeDrawableColor(Drawable d, int color) {
        d.mutate();
        d.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));

        return d;
    }
}
