package com.study.android.test4;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    ListView listView;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.editText);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        arrayAdapter.add("A_list");
        arrayAdapter.add("B_list");
        arrayAdapter.add("C_list");
        listView.setAdapter(arrayAdapter);
        listView.setTextFilterEnabled(true);
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        listView.setFilterText(editText.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if(editText.getText().length() == 0) {
            listView.clearTextFilter();
        }
    }
}
