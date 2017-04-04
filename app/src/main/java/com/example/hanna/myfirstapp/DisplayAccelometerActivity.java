package com.example.hanna.myfirstapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.gravity;

public class DisplayAccelometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager = null;
    private Sensor mAccelerometer= null;
    private TextView textView=null;
    private TextView textView5=null;
    private TextView textView6=null;

    public DisplayAccelometerActivity() {
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        textView.setText("X: " + event.values[0]);
        textView5.setText("Y: " + event.values[1]);
        textView6.setText("Z: " + event.values[2]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_accelometer);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = "X: ";
        String message2 = "Y: ";
        String message3 = "Z: ";

        // CVapture the layout's TextView and set the string as its text
        textView = (TextView) findViewById(R.id.textView);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView.setText(message1);
        textView5.setText(message2);
        textView6.setText(message3);
    }
}
