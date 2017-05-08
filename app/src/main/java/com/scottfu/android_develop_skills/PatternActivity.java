package com.scottfu.android_develop_skills;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ImageSpan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fujindong on 2017/5/8.
 */

public class PatternActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




//  正则表达式判断是否为数字 字母
    String s = "aa";
    Pattern p = Pattern.compile("^[0-9A-Za-z]+$");
    Matcher m = p.matcher(s);
    boolean aBoolean = m.matches();

/*
//@ 功能总结

//    将account 添加到 editText
    int start = messageEditText.getSelectionStart();
    String account = memberNick + " ";
            if (start < 0 || start >= messageEditText.length()) {
        messageEditText.append(account);
    } else {
        messageEditText.getEditableText().insert(start, account);
    }

    String spanName = "@" + memberNick + " ";
    Editable editable = messageEditText.getText();
    start--;
            editable.setSpan(getInputTextSpan(spanName,messageEditText.getTextSize()),start,start+account.length()+1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


    private ImageSpan getInputTextSpan(String name, float textSize) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(textSize);
        Rect rect = new Rect();
        paint.getTextBounds(name, 0, name.length(), rect);
        int width = (int) paint.measureText(name);
        final Bitmap bitmap = Bitmap.createBitmap(width, rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(name, rect.left, rect.height() - rect.bottom, paint);
        return new ImageSpan(NimUIKit.getContext(), bitmap, ImageSpan.ALIGN_BOTTOM);
    }


    private void createMemOption() {
        if (selectedMembers == null || selectedMembers.size() == 0) {
            return;
        }

        if (memberIds == null) {
            memberIds = new ArrayList<>();
        }

        String text = messageEditText.getText().toString();


        Iterator members = selectedMembers.entrySet().iterator();
        while (members.hasNext()) {
            Map.Entry entry = (Map.Entry) members.next();
            String account = (String) entry.getKey();
            Pattern pattern = Pattern.compile("(@" + account + " )");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String id = (String) entry.getValue();
                memberIds.add(id);
                continue;
            }
            members.remove();
        }
        ToastManager.showToast(container.activity, String.valueOf(selectedMembers.size()));

    }
*/

}
