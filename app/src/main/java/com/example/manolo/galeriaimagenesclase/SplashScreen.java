package com.example.manolo.galeriaimagenesclase;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    ProgressBar barraProgreso;
    int miProgreso=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        barraProgreso=(ProgressBar)findViewById(R.id.barraProgreso);

        new Thread(miHilo).start();

    }
    private Runnable miHilo = new Runnable() {
        @Override
        public void run() {
            while(miProgreso<100){
                try {
                    miHandle.sendMessage(miHandle.obtainMessage());
                    Thread.sleep(20);
                } catch(Throwable t){}
            }

            Intent i=new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();

        }

        Handler miHandle=new Handler(){

            public void handleMessage(Message msg){
                miProgreso++;
                barraProgreso.setProgress(miProgreso);
            }
        };
    };
}
