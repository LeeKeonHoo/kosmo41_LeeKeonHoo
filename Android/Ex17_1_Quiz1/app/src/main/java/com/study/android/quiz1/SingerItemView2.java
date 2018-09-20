package com.study.android.quiz1;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView2 extends LinearLayout {

    TextView textView3;
    TextView textView5;
    ImageView imageView2;

    public SingerItemView2(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view2,this,true);

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        imageView2 = findViewById(R.id.imageView2);
    }

    public void setName(String name){
        textView3.setText(name);
    }

    public void setAge(String age){
        textView5.setText(age);
    }

    public void setImage(int imgNum){
        imageView2.setImageResource(imgNum);
    }

    public TextView getTextView3() {
        return textView3;
    }

    public void setTextView3(TextView textView3) {
        this.textView3 = textView3;
    }

    public TextView getTextView5() {
        return textView5;
    }

    public void setTextView5(TextView textView5) {
        this.textView5 = textView5;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }
}
