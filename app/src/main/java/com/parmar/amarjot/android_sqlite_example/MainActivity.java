package com.parmar.amarjot.android_sqlite_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();
    }


    public void setupButtons()
    {
        final Button recordMessagesButton = findViewById(R.id.buttonRecordMessages);
        final Button showMessagesButton = findViewById(R.id.buttonShowMessages);

        recordMessagesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SendMessageActivtiy.class);
                startActivity(intent);
            }
        });

        showMessagesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
