package com.example.make_a_story_prototype.main.StoryTemplate.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SceneImage extends View {
    public SceneImage(Context context, AttributeSet attrs) {
        super(context, attrs);

        setupPaint();
    }

    private Paint drawPaint;
    private Canvas canvas;


    // Setup paint with color and stroke styles
    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(Color.BLUE);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
    }
}
