package com.example.rapha.yoonisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button startButton;
    Button resetButton;
    int counter;
    Date timestamp1;
    int myTimestamp1;
    Date timestamp2;
    int myTimestamp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.t1);
        startButton = (Button) findViewById(R.id.b1);
        resetButton = (Button) findViewById(R.id.b2);

        counter = 0;

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (counter == 0){
                    timestamp1 = new Date();
                    myTimestamp1 = (int) timestamp1.getTime();
                }

                if (counter == 9){
                    timestamp2 = new Date();
                    myTimestamp2 = (int) timestamp2.getTime();
                    int milliSeconds = (myTimestamp2 - myTimestamp1) % 1000;
                    int seconds = (myTimestamp2 - myTimestamp1) / 1000;
                    textView.setText("Your Time:\n " + seconds + "." + milliSeconds + " sec");
                    startButton.setEnabled(false);
                }
                counter++;
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText("*** press 10 times ***");
                counter = 0;
                startButton.setEnabled(true);
            }
        });
    }
}
