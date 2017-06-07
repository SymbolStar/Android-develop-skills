package com.scottfu.android_develop_skills.constraintLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.scottfu.android_develop_skills.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

/**
 * Created by fujindong on 2017/6/7.
 */

public class FirstListAdapter extends BaseAdapter {

    private ArrayList<String> stringArrayList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public FirstListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);


        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            stringArrayList.add(getRandomString(random.nextInt(10)));
        }
    }



    @Override
    public int getCount() {
        return stringArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_constraint, null);
            viewHolder = new ViewHolder();
            viewHolder.headLogo = (QuickContactBadge) convertView.findViewById(R.id.qcb_head);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.listView = (ListView) convertView.findViewById(R.id.lv_second_list);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.headLogo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_android_black_36dp));
        SecondListAdapter secondListAdapter = new SecondListAdapter(mContext);
        viewHolder.listView.setAdapter(secondListAdapter);
        setListViewHeightBasedOnChildren(viewHolder.listView);
        Random random = new Random();
        viewHolder.title.setText(stringArrayList.get(position));
        viewHolder.content.setText(getRandomString(random.nextInt(100)));
//        viewHolder.content.setText(stringArrayList.get(position));
        viewHolder.icon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_card_membership_pink_800_18dp));

        return convertView;
    }


    class ViewHolder {
        private QuickContactBadge headLogo;
        private TextView title;
        private TextView content;
        private ImageView icon;
        private ListView listView;
    }


    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }



    public void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
