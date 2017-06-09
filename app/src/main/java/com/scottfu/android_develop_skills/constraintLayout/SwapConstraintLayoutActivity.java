package com.scottfu.android_develop_skills.constraintLayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

import com.scottfu.android_develop_skills.R;

/**
 * Created by fujindong on 2017/6/9.
 */

public class SwapConstraintLayoutActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet1 = new ConstraintSet();
    private ConstraintSet constraintSet2 = new ConstraintSet();
    private boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_constraint);
        constraintLayout = (ConstraintLayout) findViewById(R.id.cl_swap_content);
        constraintSet1.clone(constraintLayout);
        constraintSet2.clone(this,R.layout.activity_swap_constraint_v2);
    }



    @TargetApi(19)
    public void onSwapClick(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionManager.beginDelayedTransition(constraintLayout);
        }
        if (!flag) {
            constraintSet2.applyTo(constraintLayout);
            flag = true;
        } else {
            constraintSet1.applyTo(constraintLayout);
            flag = false;
        }
    }
}
