package com.study.android.animation;

import android.media.Image;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    ImageView imageView1;
    Animation anim1;
    Animation anim2;
    Animation anim3;

    int i = 0;
    float x = 0.0f;
    float y = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);

        //뷰 에니메이션
        anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.size_change);
        anim3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.change_alpha);
    }

    public void onBtn1(View v){
        imageView1.startAnimation(anim1);
    }
    public void onBtn2(View v){
        imageView1.startAnimation(anim2);
    }
    public void onBtn3(View v){
        imageView1.startAnimation(anim3);
    }

    //뷰 에니메이션은 끝나면 제자리로 오지만 메트릭스는 이동한다
    //그래서 타이머와 함꼐 사용해야 한다
    //layout_width 등이 크게 지정되어 있어야 이동이 왼다(자기 범위 안에서)

    public void onBtn4(View v){
        i = 0;
        x = 0.0f;
        y = 0.0f;
        mHandler.sendEmptyMessage(0);
    }

    Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            Matrix matrix = new Matrix();
            //matrix.postRotate(45,0f);
            //matrix.postScale(2.0f,2.0f);
            x = x + 10.0f;
            y = y + 10.0f;
            matrix.postTranslate(x,y);

            imageView1.setImageMatrix(matrix);

            Log.d(TAG,"Timer:" + i);
            if(i<20){
                mHandler.sendEmptyMessageDelayed(0,500); //0.5 sec
            }
            i++;
        }
    };
}
