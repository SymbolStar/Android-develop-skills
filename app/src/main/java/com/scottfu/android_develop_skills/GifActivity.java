package com.scottfu.android_develop_skills;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by fujindong on 2017/6/5.
 */

public class GifActivity extends AppCompatActivity {

    private ImageView mGifImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        mGifImageView = (ImageView) findViewById(R.id.giv_gif);
        mGifImageView.setImageResource(R.drawable.nike);
    }
}
