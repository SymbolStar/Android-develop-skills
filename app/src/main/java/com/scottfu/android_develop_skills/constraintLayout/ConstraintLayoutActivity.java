package com.scottfu.android_develop_skills.constraintLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.scottfu.android_develop_skills.R;

/**
 * Created by fujindong on 2017/6/7.
 */

public class ConstraintLayoutActivity extends AppCompatActivity {


    private ListView mListView;

    private FirstListAdapter mListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_constraint_layout);
        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.lv_fist);
        mListAdapter = new FirstListAdapter(this);
        mListView.setAdapter(mListAdapter);

    }
}
