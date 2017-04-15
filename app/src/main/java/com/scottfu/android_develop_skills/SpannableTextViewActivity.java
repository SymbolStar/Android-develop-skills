package com.scottfu.android_develop_skills;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Created by fujindong on 2017/4/15.
 */

public class SpannableTextViewActivity extends AppCompatActivity {


    private String TAG = getClass().getSimpleName();

    private TextView mSpannableTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.spannable_tv);
        mSpannableTextView = (TextView) findViewById(R.id.tv_spannable_content);


        String fromName = "AAAAA";
        String to = "回复";
        String toUserName = "BBBBB";
        StringBuffer sb = new StringBuffer();
        String content = fromName + to + toUserName;
        sb.append(content);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(sb.toString());
        int start = 0;
        int end = fromName.length();
        int color = Color.rgb(110, 172, 224);
        stringBuilder.setSpan(new ForegroundColorSpan(color),start,end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        start = end + to.length();
        end = start + toUserName.length();
        stringBuilder.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        mSpannableTextView.setText(stringBuilder);
    }
}
