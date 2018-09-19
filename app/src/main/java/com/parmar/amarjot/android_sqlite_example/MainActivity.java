package com.parmar.amarjot.android_sqlite_example;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper = new DatabaseHelper(this);
        setupButtons();
        addData("YES");
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

    public void setupButtons()
    {
        final Button recordMessagesButton = findViewById(R.id.buttonRecordMessages);
        final Button showMessagesButton = findViewById(R.id.buttonShowMessages);

        recordMessagesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                toastMessage("recordMessagesButton Clicked");
            }
        });

        showMessagesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                toastMessage("showMessagesButton Clicked");
            }
        });
    }

    private void toastMessage(String msg){

        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
