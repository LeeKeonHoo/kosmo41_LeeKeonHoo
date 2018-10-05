package com.study.android.asynetask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    ProgressBar mProgress1;
    int mProgressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress1 = findViewById(R.id.progressBar1);
    }

    public void onBtn1(View v){
        new CounterTask().execute(0);
    }

    class CounterTask extends AsyncTask<Integer,Integer,Integer>{
        protected  void onPreExecute(){
        }

        protected Integer doInBackground(Integer... value) {
            while(mProgressStatus < 100){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                }
                mProgressStatus++;
                publishProgress(mProgressStatus);
            }
            return  mProgressStatus;
        }

        protected void onProgressUpdate(Integer... value){
            mProgress1.setProgress(mProgressStatus);
        }

        protected void onPostExecute(Integer result){
            mProgress1.setProgress(mProgressStatus);
        }
    }
}
