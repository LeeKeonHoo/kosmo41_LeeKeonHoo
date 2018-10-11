package com.study.android.test2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment3 extends Fragment {
    private static final String TAG = "lecture";

    TextView textView6;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button button5;
    Button button6;
    Button button7;
    SQLiteDatabase database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment3,container,false);
        textView6 = rootView.findViewById(R.id.textView6);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);
        editText4 = rootView.findViewById(R.id.editText4);


        button5 = rootView.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"Fragment2");

                dataadd();
            }

        });

        button6 = rootView.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"Fragment2");

                datadelete();
            }

        });


        button7 = rootView.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"Fragment2");

                dataplus();
            }

        });

            createMyDatabase();
            createMyTable();

        return  rootView;
    }
    public void printInfo(String msg){
        textView6.append(msg + "\n");
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
                "create table if not exists customer (name text,age integer, mobile text,star integer) ";
                 printInfo("테이블 만듬 : customer");
        try{
            database.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void dataadd(){

        String search1 = editText2.getText().toString();
        String search2 = editText3.getText().toString();
        String search3 = editText4.getText().toString();

        String sql1 = "insert into customer " +
                "(name, age, mobile,star) values ('"+search1+"',"+search3+",'"+search2+"',0) ";

        try{
            database.execSQL(sql1);
            printInfo("데이터 추가 : 1");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void datadelete(){

        String search1 = editText3.getText().toString();

        String sql1 = "delete from customer " +
                "where mobile = '"+search1+"' ";

        try{
            database.execSQL(sql1);
            printInfo("데이터 추가 : 1");

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


}
