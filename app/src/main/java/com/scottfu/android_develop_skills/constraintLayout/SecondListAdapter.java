package com.scottfu.android_develop_skills.constraintLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.scottfu.android_develop_skills.R;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by fujindong on 2017/6/7.
 */

public class SecondListAdapter extends BaseAdapter {


    private  ArrayList<String> mArrayList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public SecondListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);


            Random random = new Random();
            int length = random.nextInt(20);
            for (int i = 0; i < length; i++) {
                mArrayList.add(getRandomString(random.nextInt(10)));
        }


    }


    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_second_v2, null);
            viewHolder.headLogo = (QuickContactBadge) convertView.findViewById(R.id.qcb_logo);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(mArrayList.get(position));
        viewHolder.headLogo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_account_box_teal_400_24dp));

        return convertView;
    }


     class ViewHolder {
        private QuickContactBadge headLogo;
        private TextView name;
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
