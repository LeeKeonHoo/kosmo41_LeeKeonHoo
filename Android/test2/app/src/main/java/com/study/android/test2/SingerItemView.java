package com.study.android.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    ImageView imageView1;
    int star;

    public SingerItemView(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view,this,true);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        imageView1 = findViewById(R.id.imageView1);
    }

    public void setName(String name){
        textView1.setText(name);
    }

    public void setAge(String age){
        textView2.setText(age);
    }

    public void setMobile(String mobile){
        textView3.setText(mobile);
    }

    public void setImage(int image){
        imageView1.setImageResource(image);
    }

    public void setStar(int star){
        star = 0;
    }

}
