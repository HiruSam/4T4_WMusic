package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.DateUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class level01Int2 extends AppCompatActivity {

    Button homebutton,back,next;
    int counter = 0;
    TextView showValue;
    CountDownTimer ctdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01_int2);

        //adding timer
        final TextView time = (TextView) findViewById(R.id.time);
        ctdown = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {

                TextView time = (TextView) findViewById(R.id.time);
                time.setText("Seconds remaining : " + DateUtils.formatElapsedTime(l / 1000));
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(level01Int2.this, level01timesup.class);
                intent.putExtra("Value","2");
                startActivity(intent);

            }
        }.start();



        //adding score
//        showValue = (TextView) findViewById(R.id.score);

        homebutton = findViewById(R.id.home);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level01Int2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //click the correct button
        next  = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(level01Int2.this, level01score.class);
                intent.putExtra("Next","2");
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        ctdown.cancel();
    }

    //correct image toast
    public  void correct(View view){

        ctdown.cancel();

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.correct_toast,(ViewGroup) findViewById(R.id.custom_toast_container));

//        TextView textView = (TextView) layout.findViewById(R.id.text);
//        textView.setText();

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


        if (counter == 0) {
            counter += 10;
        }
        showValue.setText(Integer.toString(counter));
    }

    //wrong image toast
    public  void wrong(View view) {

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.wrong_toast, (ViewGroup) findViewById(R.id.custom_toast_container));


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


    }

}
