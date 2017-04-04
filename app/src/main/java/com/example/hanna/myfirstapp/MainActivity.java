package com.example.hanna.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        Intent intent = null;
        if(view.getId()== R.id.button) {
             intent = new Intent(this, DisplayAccelometerActivity.class);
        } else {
            intent = new Intent(this, DisplayCompassActivity.class);
        }
        startActivity(intent);
    }
}
