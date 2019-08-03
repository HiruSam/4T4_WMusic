package com.example.a4t4wmlv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button04 , button03 , button02 , button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mplayer = MediaPlayer.create(this,R.raw.background);

        mplayer.start();

        button04 = (Button) findViewById(R.id.button_to_level04);
        button01 =(Button) findViewById(R.id.button_to_level01);
        button03 =(Button) findViewById(R.id.button_to_level03);

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);
            }
        });
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, level1.class);
                startActivity(intent);
            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchPage(view);
            }
        });


    }

    public void switchPage (View v){
        if(v == button01) {
            Intent intent = new Intent(this, level1.class);
            startActivity(intent);
        }
        else if(v == button04)
        {
            Intent intent = new Intent(this, level4.class);
            startActivity(intent);
        }
        else if(v == button03)
        {
            Intent intent = new Intent(this, level03_int01.class);
            startActivity(intent);
        }
    }
    }


