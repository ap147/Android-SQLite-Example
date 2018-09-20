package com.parmar.amarjot.android_sqlite_example;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SendMessageActivtiy extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message);
        mDatabaseHelper = new DatabaseHelper(this);
        
        setupButtons();
    }

    private void setupButtons(){

        final Button showMessageButton = findViewById(R.id.buttonSendMessage);

        showMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textViewMsg);
                String msg = (String) textView.getText();

                addData("HI");
            }
        });
    }

    private void addData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Success");
        }
        else {
            toastMessage("go eat");
        }
    }
    // When send button pressed take users input and store in database.
    // Clear Textbox and make a toast.

    private void toastMessage(String msg){

        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
