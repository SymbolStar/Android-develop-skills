package com.scottfu.android_develop_skills;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fujindong on 2017/4/14.
 */

public class ScrollViewAdapterActivity extends AppCompatActivity {


    private Button mContentChangedButton;
    private TextView mContentTextView;
    private Boolean mContentState = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_skills_sv_1);
        mContentChangedButton = (Button) findViewById(R.id.btn_content_change);
        mContentTextView = (TextView) findViewById(R.id.tv_content);
        mContentTextView.setText(getResources().getText(R.string.sv_tv_short_string));
        mContentChangedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContentState = !mContentState;
                if (mContentState) {
                    mContentTextView.setText(getResources().getText(R.string.sv_tv_long_string));
                } else {
                    mContentTextView.setText(getResources().getText(R.string.sv_tv_short_string));
                }
            }
        });
    }

}
