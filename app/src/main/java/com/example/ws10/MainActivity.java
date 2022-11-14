package com.example.ws10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    TimeUnit.SECONDS.sleep(1);
                    Intent intent = new Intent(MainActivity.this, LaunchScreen.class);
                    startActivity(intent);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}