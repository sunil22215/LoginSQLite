package com.example.loginsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plash_screen);
        Thread thread = new Thread(){
            public  void run(){
                try {
                    sleep(4000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(PlashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
        getSupportActionBar().hide();
    }
}