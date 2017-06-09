package com.scottfu.android_develop_skills;

import android.content.Intent;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scottfu.android_develop_skills.constraintLayout.ConstraintLayoutActivity;
import com.scottfu.android_develop_skills.constraintLayout.ConstraintLayoutAnimationsActivity;
import com.scottfu.android_develop_skills.constraintLayout.SwapConstraintLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chain_test);

        startActivity(new Intent(this,SwapConstraintLayoutActivity.class));

    }
}
