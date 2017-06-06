package com.scottfu.android_develop_skills;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by fujindong on 2017/6/5.
 */

public class GifActivity extends AppCompatActivity {

    private ImageView mGifImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File file = getExternalCacheDir();


//单个权限申请
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
        }



        setContentView(R.layout.activity_gif);
        mGifImageView = (ImageView) findViewById(R.id.giv_gif);
//        mGifImageView.setImageResource(R.drawable.nike);
//这里不需要加后缀
        String path = Environment.getExternalStoragePublicDirectory("test").getAbsolutePath()+"/"+"1242989854";
//        String path = Environment.getExternalStoragePublicDirectory("test").getAbsolutePath()+"/"+"123"+".gif";
        File file1 = new File(path);
        try {
            GifDrawable gifDrawable = new GifDrawable(file1);
            mGifImageView.setImageDrawable(gifDrawable);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
