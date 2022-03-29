package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView time, click;
    Button btn_click, btn_start;
    public static final String TAG = "StartActivity";
    private Integer count = 5;

    CountDownTimer timer;

    int t=30;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        time=findViewById(R.id.time);
        click=(TextView)findViewById(R.id.click);
        btn_click=(Button)findViewById(R.id.btn_click);
        btn_start=(Button)findViewById(R.id.btn_start);

        btn_start.setEnabled(true);
        btn_click.setEnabled(false);

// описание таймера  обратного отсчета//
        timer=new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntiIFinished) {
                t--;
                time.setText("Time :" + t);
            }

            @Override
            public void onFinish() {

                btn_start.setEnabled(true);
                btn_click.setEnabled(false);
                time.setText("Time : 0");
            }

        };

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                click.setText("Click :" +c);

            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               timer.start();
                btn_start.setEnabled(false);
                btn_click.setEnabled(true);
                c=0;
                t=30;
                time.setText("Time :" + t);
                click.setText("click  :" +c);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}