package com.example.ws10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class AirConditioner extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private TextView celcius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_conditioner);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        celcius = findViewById(R.id.textView);
        celcius.setText("22° Celcius");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        celcius.setText(String.valueOf(seekBar.getProgress()));
        celcius.append("° Celcius");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        celcius.setText(String.valueOf(seekBar.getProgress()));
        celcius.append("° Celcius");
    }
}