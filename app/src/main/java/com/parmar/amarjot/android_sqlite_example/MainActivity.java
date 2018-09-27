package com.parmar.amarjot.android_sqlite_example;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseHelper = new DatabaseHelper(this);
        setupButtons();
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
                refreshMsgs();
            }
        });

        clearMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabaseHelper.clearDatabase();
                toastMessage("Successfully cleared DB.");
            }
        });
    }

    private void refreshMsgs() {
        Cursor data = mDatabaseHelper.getData();

        LinearLayout x = findViewById(R.id.msgs);
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList

            String msg = data.getString(1).toString();
            System.out.println(msg);

        }
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

