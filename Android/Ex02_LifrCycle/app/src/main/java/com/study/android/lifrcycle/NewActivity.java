package com.study.android.lifrcycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    String sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Toast.makeText(getApplicationContext(),"onCreate() 호출댐",Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName");

    }

    public void onBtn1Clicked(View v){
        //토스트로 전달된 데이터 보여주기
        Toast.makeText(getApplicationContext(),
                "CustomerName : " + sName,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart() 호출댐",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume() 호출댐",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause() 호출댐",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop() 호출댐",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy() 호출댐",Toast.LENGTH_SHORT).show();
    }

}
