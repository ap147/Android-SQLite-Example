package com.parmar.amarjot.android_sqlite_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RecordedMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorded_messages);
    }

    // Read SQL db and display messages
}
