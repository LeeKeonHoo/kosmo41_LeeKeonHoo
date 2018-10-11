package com.study.android.test2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class Fragment2 extends Fragment {
    private static final String TAG = "lecture";

    private  static final int REQUEST_CODE = 1000;
    TextView textView1;
    EditText editText;
    Button button1;
    Button button2;
    SingerAdapter adapter;
    SQLiteDatabase database;
    //정리되면 숨길 예정 gone로 숨김
    TextView textView2;

    ListView listView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        ///////////////////////리스트///////////////////////////
        textView1 = rootView.findViewById(R.id.textView1);
        editText = rootView.findViewById(R.id.editText1);


        adapter = new SingerAdapter(getContext());
        listView1 = rootView.findViewById(R.id.listView2);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                final SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getActivity(),
                        "selected : " + item.getName() + item.getMobile(), Toast.LENGTH_SHORT).show();

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

        textView2 = rootView.findViewById(R.id.textView2);

            createMyDatabase();
            createMyTable();
            selectAllData();

        button1 = rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"Fragment2");

                textView1.setText(editText.getText());
                searchData();
            }
        });

        /////////////////////음성인식 버튼//////////////////////////////////
        button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"Fragment2");

                try {
                    //음성 인식의 실행(1)
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
                    //검색 결과를 보여주는 갯수
                    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성 검색");

                    startActivityForResult(intent, REQUEST_CODE);
                }catch (ActivityNotFoundException e){
                    Log.d(TAG,"ActivityNotFoundException");
                }
            }
        });

        return rootView;
    }


    public void onEndOfSpeech() {
    }


    public void onReadyForSpeech(Bundle bundle) {
    }


    public void onResults(Bundle results) {
        ArrayList<String> matches = results.
                getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        String str = "";
        for(int i = 0;i<matches.size(); i++){
            str = str + matches.get(i) + "\n";
            Log.d(TAG, "onResults text : " + matches.get(i));
        }

        editText.setText(str);
        textView1.setText(str);
        searchData();
    }


    public void onError(int errorCode) {
        String message;
        switch (errorCode){
            case SpeechRecognizer.ERROR_AUDIO:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "클라이언트 에러";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "퍼미션 없음";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "네트워크 에러";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "네트워크 타임아웃";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "찾을수 없음";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "BUSY";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "서버 이상";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "시간 초과";
                break;
            default:
                message = "알수없음";
                break;
        }
        Log.d(TAG,"SPEECH ERROR : " + message);
    }


    public void onRmsChanged(float v) {
    }


    public void onBeginningOfSpeech() {
    }


    public void onEvent(int i, Bundle bundle) {
    }


    public void onPartialResults(Bundle bundle) {
    }


    public void onBufferReceived(byte[] bytes) {
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        switch (requestCode){
            case REQUEST_CODE : {
                if(resultCode == RESULT_OK && null != data){
                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String[] rs = new String[text.size()];
                    text.toArray(rs);

                    editText.setText(rs[0]);
                    textView1.setText(rs[0]);
                    searchData();
                }

                break;
            }
        }
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
                "create table if not exists customer (name text,age integer, mobile text,star integer) ";
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

    private void searchData(){

        adapter.items.clear();

        String search = editText.getText().toString();
        Log.d(TAG,"데이터 입력 : " + search);

        String sql = "select name, age, mobile,star from customer where age like  '%" + search + "%' " +
                " or name like '%" + search + "%' or mobile like '%" + search + "%' group by mobile ";

        Cursor cursor = database.rawQuery(sql, null);

        int count = cursor.getCount();
        printInfo("데이터 갯수 : " + count);
        Log.d(TAG,"데이터 갯수 : " + count);

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
    }

    public void datastar(String songname, String singer,int star){

        if(star == 0) {
            String sql = "update customer set star = 1 " +
                    " where mobile = '" + songname + "' and name = '" + singer + "' ";
            Toast.makeText(getActivity(),
                    songname + " 이 즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(getActivity(),
                    songname + " 이 즐겨찾기에 제거되었습니다.", Toast.LENGTH_SHORT).show();
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



