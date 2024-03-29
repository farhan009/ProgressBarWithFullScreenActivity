package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Remove notification Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar_id);
         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 doWork();
             }
         });
         thread.start();
    }

    private void doWork(){
        for (progress = 2; progress <= 200; progress = progress + 2){

            try {
                Thread.sleep(40);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
