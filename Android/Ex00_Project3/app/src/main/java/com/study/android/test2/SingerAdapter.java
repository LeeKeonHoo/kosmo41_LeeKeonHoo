package com.study.android.test2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {

    Context context;
    ArrayList<SingerItem> items = new ArrayList<>();
    int[] images = {R.drawable.album1, R.drawable.album2,R.drawable.album3,R.drawable.album4,
            R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8
            ,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.album12
            ,R.drawable.album13,R.drawable.album14,R.drawable.album15,R.drawable.album16
            ,R.drawable.album17,R.drawable.album18,R.drawable.album19,R.drawable.album20};
    int[] images2 = {R.drawable.unknown};


    public SingerAdapter(Context context){
        this.context = context;
    }

    public void addItem(SingerItem item){
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return  items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SingerItemView view = null;
        if(convertView == null)
        {
            view = new SingerItemView(context);
        }else{
            view = (SingerItemView) convertView;
        }

        final SingerItem item = items.get(position);
        view.setName(item.getName());
        view.setAge(item.getAge());
        view.setMobile(item.getMobile());
        view.setStar(item.getStar());
        int age = Integer.parseInt(item.getAge()) - 1;

        if(age < 20){
            view.setImage(images[age]);
        }
        else{
            view.setImage(images2[0]);
        }


        return  view;
    }
}
