package com.example.stopwatch;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn_start,btn_stop,btn_pause;
    int hr=0,min=0,sec=0;
    CountDownTimer ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.timer_txtview);
        btn_start=findViewById(R.id.timer_btn);
        btn_pause=findViewById(R.id.timer_btn2);
        btn_stop=findViewById(R.id.timer_btn3);

        txt.setText("00:00:00");

        ct=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                sec++;
                String str=""+hr+":"+min+":"+sec;
                txt.setText(str);
            }

            @Override
            public void onFinish() {

            }
        };

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ct.start();
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ct.cancel();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("00:00:00");
                sec=0;
                ct.cancel();
            }
        });
    }
}
