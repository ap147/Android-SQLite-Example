package com.parmar.amarjot.android_sqlite_example;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

                Context context = getApplicationContext();
                CharSequence text = "Record Message Clicked";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        showMessagesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Context context = getApplicationContext();
                CharSequence text = "Show Message Clicked";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
