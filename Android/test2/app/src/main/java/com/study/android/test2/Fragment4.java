package com.study.android.test2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment4 extends Fragment {
    private static final String TAG = "lecture";

    SQLiteDatabase database;
    SingerAdapter adapter;
    Fragment fragment;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment4,container,false);

        adapter = new SingerAdapter(getContext());

        final ListView listView3 = rootView.findViewById(R.id.listView3);
        listView3.setAdapter(adapter);

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                final SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getActivity(),
                        "selected : " + item.getName(), Toast.LENGTH_SHORT).show();
                {
                    final List<String> ListItems = new ArrayList<>();
                    ListItems.add("가사보기");
                    ListItems.add("즐겨찾기");
                    ListItems.add("닫기");
                    final CharSequence[] items2 =  ListItems.toArray(new String[ ListItems.size()]);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(item.getName() + " - " + item.getMobile());
                    builder.setItems(items2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int pos) {
                            String selectedText = items2[pos].toString();
                            Toast.makeText(getActivity(), selectedText, Toast.LENGTH_SHORT).show();
                            if(selectedText.equals("가사보기")) {
                                String songname= item.getMobile();
                                String singer = item.getName();
                                String age = item.getAge();
                                Intent intent = new Intent(getActivity(), Search.class);
                                intent.putExtra("songname",songname);
                                intent.putExtra("singer",singer);
                                intent.putExtra("age",age);
                                startActivity(intent);
                            }
                            else if(selectedText.equals("즐겨찾기")) {
                                String songname= item.getMobile();
                                String singer = item.getName();
                                int star = item.getStar();
                                Log.d(TAG,"즐겨찾기 눌름");
//                                Intent intent = new Intent(getActivity(), Star.class);
//                                intent.putExtra("songname",songname);
//                                intent.putExtra("singer",singer);
//                                intent.putExtra("age",age);
//                                startActivity(intent);
                                Log.d(TAG, String.valueOf(star));
                                datastar(songname,singer,star);
                            }

                        }
                    });
                    builder.show();
                }
                }
        });

        createMyDatabase();
        createMyTable();
        selectStarData();

        final SwipeRefreshLayout mySwipeRefreshLayout = rootView.findViewById(R.id.swipe_layout);
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
                                selectStarData();
                                mySwipeRefreshLayout.setRefreshing(false);
                            }
                        },3000);
                    }
                }
        );
        return rootView;
    }


    private void createMyDatabase(){

        try{
            database = getActivity().openOrCreateDatabase("customer.sqlite", Activity.MODE_PRIVATE,null);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createMyTable(){
        String sql =
                "create table if not exists customer (name text,age integer, mobile text,star integer) ";
        try{
            database.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void selectStarData(){

        String sql = "select name, age, mobile,star from customer where star=1 group by mobile order by age asc ";
        try{
            Cursor cursor = database.rawQuery(sql, null);

            int count = cursor.getCount();

            int i = 0;
            while(i < count){
                cursor.moveToNext();

                String name = cursor.getString(0);
                String age = cursor.getString(1);
                String mobile = cursor.getString(2);
                int star =cursor.getInt(3);

                Log.d(TAG,"# " + name + " : " + age + " : " + mobile);

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
                Toast.makeText(getActivity(),
                        songname + " 이 즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "즐겨찾기 추가댐");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "즐겨찾기 예외");
            }
        }
        else {
            String sql = "update customer set star = 0 " +
                    " where mobile = '"+songname+"' and name = '"+singer+"' ";
            Log.d(TAG,"즐겨찾기 디비들어감");
            try {
                database.execSQL(sql);
                Toast.makeText(getActivity(),
                        songname + " 이 즐겨찾기에 제거되었습니다.", Toast.LENGTH_SHORT).show();
                Log.d(TAG,"즐겨찾기 추가댐");
            }catch (Exception e){
                e.printStackTrace();
                Log.d(TAG,"즐겨찾기 예외");
            }
        }

    }
}
