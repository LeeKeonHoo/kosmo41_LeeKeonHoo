package com.study.android.test2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Fragment1 extends Fragment {
    private static final String TAG = "lecture";

    SQLiteDatabase database;
    SingerAdapter adapter;
    Button button;
    Button button8;
    Button button9;
    private FloatingActionButton fab;

    //정리되면 숨길 예정 gone로 숨김
    TextView textView2;

    String dbName;
    String tname;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment1, container, false);

        tname = "customer";

        adapter = new SingerAdapter(getContext());

        ListView listView1 = layout.findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                final SingerItem item = (SingerItem) adapter.getItem(position);
                {
                    final List<String> ListItems = new ArrayList<>();
                    ListItems.add("감상하기");
                    ListItems.add("즐겨찾기");
                    ListItems.add("닫기");
                    final CharSequence[] items2 = ListItems.toArray(new String[ListItems.size()]);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(item.getName() + " - " + item.getMobile());
                    builder.setItems(items2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int pos) {
                            String selectedText = items2[pos].toString();
                            if (selectedText.equals("감상하기")) {
                                String songname = item.getMobile();
                                String singer = item.getName();
                                String age = item.getAge();
                                Intent intent = new Intent(getActivity(), Search.class);
                                intent.putExtra("songname", songname);
                                intent.putExtra("singer", singer);
                                intent.putExtra("age", age);
                                startActivity(intent);
                            } else if (selectedText.equals("즐겨찾기")) {
                                String songname = item.getMobile();
                                String singer = item.getName();
                                int star = item.getStar();
                                Log.d(TAG, "즐겨찾기 눌름");
                                Log.d(TAG, String.valueOf(star));
                                datastar(songname, singer, star);
                            }
                        }
                    });
                    builder.show();
                }
            }
        });

        fab = layout.findViewById(R.id.floatingActionButton5);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(button8.getVisibility() == getView().INVISIBLE) {
                    button8.setVisibility(View.VISIBLE);
                    button9.setVisibility(View.VISIBLE);
                }else{
                    button8.setVisibility(View.INVISIBLE);
                    button9.setVisibility(View.INVISIBLE);
                }
            }
        });

        button8 = layout.findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                adapter.items.clear();
                mobileupdata();
                button8.setVisibility(View.INVISIBLE);
                button9.setVisibility(View.INVISIBLE);
            }
        });

        button9 = layout.findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                adapter.items.clear();
                nameupdata();
                button8.setVisibility(View.INVISIBLE);
                button9.setVisibility(View.INVISIBLE);
            }
        });

        textView2 = layout.findViewById(R.id.textView2);
        createMyDatabase();
        createMyTable();
        selectAllData();

        final SwipeRefreshLayout mySwipeRefreshLayout = layout.findViewById(R.id.swipe_layout);
        mySwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.items.clear();
                                selectAllData();
                                mySwipeRefreshLayout.setRefreshing(false);
                            }
                        }, 3000);
                    }
                }
        );
        return layout;
    }


public void printInfo(String msg){
    textView2.append(msg + "\n");
}

    private void createMyDatabase(){
        try{
            database = getActivity().openOrCreateDatabase("customer.sqlite", Activity.MODE_PRIVATE,null);
            printInfo("데이터베이스 만듬 : customer.sqlite");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createMyTable(){
        String sql =
                "create table if not exists customer (name text,age integer, mobile text, star integer) ";
        try{
            database.execSQL(sql);
            printInfo("테이블 만듬 : customer");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void selectAllData(){
        String sql = "select name, age, mobile,star from customer group by mobile order by age asc ";
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
                int star =cursor.getInt(3);

                Log.d(TAG,"# " + name + " : " + age + " : " + mobile);
                printInfo("# " + name + " : " + age + " : " + mobile);

                SingerItem item = new SingerItem(name,age,mobile,star);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();

                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void datastar(String songname, String singer,int star){
        if(star == 0) {
            String sql = "update customer set star = 1 " +
                    " where mobile = '" + songname + "' and name = '" + singer + "' ";
            Log.d(TAG, "즐겨찾기 디비들어감");
            try {
                database.execSQL(sql);
                Log.d(TAG, "즐겨찾기 추가댐");
                Toast.makeText(getActivity(),
                        songname + " 이 즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "즐겨찾기 예외1");
            }
        }
        else {
                String sql = "update customer set star = 0 " +
                        " where mobile = '"+songname+"' and name = '"+singer+"' ";
                Log.d(TAG,"즐겨찾기 디비들어감");
                try {
                    database.execSQL(sql);
                    Log.d(TAG,"즐겨찾기 제거댐");
                    Toast.makeText(getActivity(),
                            songname + " 이 즐겨찾기에 제거되었습니다.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                    Log.d(TAG,"즐겨찾기 예외2");
                }
        }

    }

    private void mobileupdata(){
        String sql = "select name, age, mobile,star from customer group by mobile order by mobile asc ";
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
                int star =cursor.getInt(3);

                Log.d(TAG,"# " + name + " : " + age + " : " + mobile);
                printInfo("# " + name + " : " + age + " : " + mobile);

                SingerItem item = new SingerItem(name,age,mobile,star);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();

                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void nameupdata(){
        String sql = "select name, age, mobile,star from customer group by mobile order by name asc ";
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
                int star =cursor.getInt(3);

                Log.d(TAG,"# " + name + " : " + age + " : " + mobile);
                printInfo("# " + name + " : " + age + " : " + mobile);

                SingerItem item = new SingerItem(name,age,mobile,star);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();

                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
