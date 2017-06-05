package com.scottfu.android_develop_skills;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.File;

/**
 * Created by fujindong on 2017/5/24.
 */

public class AndroidDirectoryActivity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        File file = getExternalCacheDir();
        File file1 = getExternalFilesDir("");

        File file2 = getCacheDir();


    }
}
