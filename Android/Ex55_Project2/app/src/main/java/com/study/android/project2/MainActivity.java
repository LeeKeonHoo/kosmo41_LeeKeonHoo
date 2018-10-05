package com.study.android.project2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    SQLiteDatabase database;
    SingerAdapter adapter;

    //정리되면 숨길 예정 gone로 숨김
    TextView textView2;

    String dbName;
    String tname;

    TabLayout tabLayout;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tname = "customer";

        adapter = new SingerAdapter(this);

        ListView listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        "selected : " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        textView2 = findViewById(R.id.textView2);

        createMyDatabase();
        createMyTable();
        selectAllData();

        //////////////////////////////////////////////////////////////////

        tabLayout = findViewById(R.id.tabMenu);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager()
                .beginTransaction().replace(R.id.container,fragment1).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG,"POS:"+tab.getPosition());

                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container,fragment1).commit();
                        break;
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container,fragment2).commit();
                        break;
                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.container,fragment3).commit();
                        break;
                    default:
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
   }


    public void onBtn2(View v){
        selectAllData();
    }

    public void printInfo(String msg){
        textView2.append(msg + "\n");
    }

    private void createMyDatabase(){

        try{
            database = openOrCreateDatabase("customer.sqlite", Activity.MODE_PRIVATE,null);

            printInfo("데이터베이스 만듬 : customer.sqlite");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createMyTable(){
        String sql =
                "create table if not exists customer (name text,age integer, mobile text) ";
        try{
            database.execSQL(sql);

            printInfo("테이블 만듬 : customer");
        }catch (Exception e){
            e.printStackTrace();
        }
        dataadd();
    }

    private void selectAllData(){

        String sql = "select name, age, mobile from customer ";
        try{
            Cursor cursor = database.rawQuery(sql, null);

            int count = cursor.getCount();
            printInfo("데이터 갯수 : " + count);

            int i = 0;
            while(i < count){
                cursor.moveToNext();

                String name = cursor.getString(0);
                String age = cursor.getString(1);
                String mobile = cursor.getString(2);

                Log.d(TAG,"# " + name + " : " + age + " : " + mobile);
                printInfo("# " + name + " : " + age + " : " + mobile);

                SingerItem item = new SingerItem(name,age,mobile);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();

                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void dataadd(){
        String sql1 = "insert into customer " +
                "(name, age, mobile) values ('윤하',1,'오늘 헤어졌어요') ";
        String sql2 = "insert into customer " +
                "(name, age, mobile) values ('볼빨간 사춘기',2,'여행') ";
        String sql3 = "insert into customer " +
                "(name, age, mobile) values ('태연',3,'Rain') ";
        String sql4 = "insert into customer " +
                "(name, age, mobile) values ('아이유',4,'비밀의 화원') ";
        try{
            database.execSQL(sql1);
            printInfo("데이터 추가 : 1");

            database.execSQL(sql2);
            printInfo("데이터 추가 : 2");

            database.execSQL(sql3);
            printInfo("데이터 추가 : 3");

            database.execSQL(sql4);
            printInfo("데이터 추가 : 4");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
