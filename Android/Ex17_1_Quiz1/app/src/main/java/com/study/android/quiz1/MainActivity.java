package com.study.android.quiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.study.android.quiz1.R;
import com.study.android.quiz1.SingerItemView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    String[] names = {"김지훈", "김철언", "김태형", "김현승", "남궁윤희",
            "노현아", "박진수", "송상운", "오연주", "유민상", "윤용백", "이건후",
            "이영호", "장희성", "정상준", "정석진", "정재엽", "조성준", "조윤희",
            "최송이", "한동인", "한태용"};
    String[] ages = {"남", "남", "남", "남", "여",
            "여", "남", "남", "여", "남", "남", "남",
            "남", "남", "남", "남", "남", "남", "여",
            "여", "남", "남"};
    int[] images = {R.drawable.face1, R.drawable.face3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //3단계
        final MyAdapter adapter = new MyAdapter();

        ListView listView1 = findViewById(R.id.listview1);

        listView1.setAdapter(adapter);

        //4단계
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Toast.makeText(getApplicationContext(),
                        "selected : " + names[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    //1단계
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            //2단계
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);

            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItemView2 view2 = new SingerItemView2(getApplicationContext());

            if (ages[position].toString().equals("남")) {
                view.setName(names[position]);
                view.setAge(ages[position]);
                view.setImage(images[0]);
                layout.addView(view);
            } else {
                view2.setName(names[position]);
                view2.setAge(ages[position]);
                view2.setImage(images[1]);
                layout.addView(view2);
            }

            return layout;
        }
    }
}