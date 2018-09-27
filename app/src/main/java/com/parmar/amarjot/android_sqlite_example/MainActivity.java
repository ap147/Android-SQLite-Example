package com.parmar.amarjot.android_sqlite_example;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);
        setupButtons();

        refreshListView();
    }

    private void refreshListView() {
        // https://www.youtube.com/watch?v=aQAIMY-HzL8&t=185s, https://github.com/mitchtabian/SaveReadWriteDeleteSQLite/blob/master/SaveAndDisplaySQL/app/src/main/java/com/tabian/saveanddisplaysql/ListDataActivity.java
        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

    public void setupButtons()
    {
        final Button sendMessageButton = findViewById(R.id.buttonSendMessage);
        final Button clearMessageButton = findViewById(R.id.buttonClearMsgs);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = findViewById(R.id.textViewMsg);
                String msg = editText.getText().toString();
                editText.setText("");
                addData(msg);
                refreshListView();
            }
        });

        clearMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabaseHelper.clearDatabase();
                refreshListView();
                toastMessage("Successfully cleared DB.");
            }
        });
    }

    private void addData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Successfully added message.");
        }
        else {
            toastMessage("Failed to add message.");
        }
    }

    private void toastMessage(String msg){

        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

