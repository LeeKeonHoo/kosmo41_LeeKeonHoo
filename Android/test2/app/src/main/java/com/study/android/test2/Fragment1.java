package com.study.android.test2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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

    //정리되면 숨길 예정 gone로 숨김
    TextView textView2;

    String dbName;
    String tname;

    private SwipeRefreshLayout refreshLayout = null;
    private WebView webView = null;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment1,container,false);

        tname = "customer";

        adapter = new SingerAdapter(getContext());

        ListView listView1 = layout.findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        },3000);
//                        Intent intent = new Intent(getActivity(), MainActivity.class);
//                        startActivity(intent);
//                        Log.d(TAG,"스크롤 돌아감");
                    }
                }
        );


        //////////////////////////////////////////////////////////////////

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
//        dataplus();
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


    private void dataplus(){

        String sql1 = "insert into customer " +
                "(name, age, mobile,star) values ('윤하',1,'오늘 헤어졌어요',0) ";
        String sql2 = "insert into customer " +
                "(name, age, mobile,star) values ('볼빨간 사춘기',2,'여행',0) ";
        String sql3 = "insert into customer " +
                "(name, age, mobile,star) values ('태연',3,'Rain',0) ";
        String sql4 = "insert into customer " +
                "(name, age, mobile,star) values ('아이유(IU)',4,'비밀의 화원',0) ";
        String sql5 = "insert into customer " +
                "(name, age, mobile,star) values ('트와이스(TWICE)',5,'Dance The Night Away',0) ";
        String sql6 = "insert into customer " +
                "(name, age, mobile,star) values ('샤넌',6,'눈물이 흘러',0) ";
        String sql7 = "insert into customer " +
                "(name, age, mobile,star) values ('마마무',7,'칠해줘',0) ";
        String sql8 = "insert into customer " +
                "(name, age, mobile,star) values ('헤이즈(Heize)',8,'비도 오고 그래서',0) ";
        String sql9 = "insert into customer " +
                "(name, age, mobile,star) values ('창모',9,'마에스트로(Maestro)',0) ";
        String sql10 = "insert into customer " +
                "(name, age, mobile,star) values ('DPR LIVE',10,'Martini Blue',0) ";
        String sql11 = "insert into customer " +
                "(name, age, mobile,star) values ('2NE1',11,'너 아님 안돼',0) ";
        String sql12 = "insert into customer " +
                "(name, age, mobile,star) values ('FT아일랜드',12,'사랑앓이',0) ";
        String sql13 = "insert into customer " +
                "(name, age, mobile,star) values ('박재범(Jay Park)',13,'All I Wanna Do',0) ";
        String sql14 = "insert into customer " +
                "(name, age, mobile,star) values ('딘(DEAN)',14,'D(Half Moon)',0) ";
        String sql15 = "insert into customer " +
                "(name, age, mobile,star) values ('로꼬(LOCO)',15,'감아',0) ";
        String sql16 = "insert into customer " +
                "(name, age, mobile,star) values ('신화',16,'Brand New',0) ";
        try{
            database.execSQL(sql1);
            printInfo("데이터 추가 : 1");

            database.execSQL(sql2);
            printInfo("데이터 추가 : 2");

            database.execSQL(sql3);
            printInfo("데이터 추가 : 3");

            database.execSQL(sql4);
            printInfo("데이터 추가 : 4");

            database.execSQL(sql5);
            printInfo("데이터 추가 : 5");

            database.execSQL(sql6);
            printInfo("데이터 추가 : 6");

            database.execSQL(sql7);
            printInfo("데이터 추가 : 7");

            database.execSQL(sql8);
            printInfo("데이터 추가 : 8");

            database.execSQL(sql9);
            printInfo("데이터 추가 : 9");

            database.execSQL(sql10);
            printInfo("데이터 추가 : 10");

            database.execSQL(sql11);
            printInfo("데이터 추가 : 11");

            database.execSQL(sql12);
            printInfo("데이터 추가 : 12");

            database.execSQL(sql13);
            printInfo("데이터 추가 : 13");

            database.execSQL(sql14);
            printInfo("데이터 추가 : 14");

            database.execSQL(sql15);
            printInfo("데이터 추가 : 15");

            database.execSQL(sql16);
            printInfo("데이터 추가 : 16");

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
                    Log.d(TAG,"즐겨찾기 추가댐");
                }catch (Exception e){
                    e.printStackTrace();
                    Log.d(TAG,"즐겨찾기 예외");
                }
        }

    }

}
