package com.example.feedthecat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private int mProgressStatus = 0;
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressbar);
        mLoadingText = findViewById(R.id.LoadingCompleteTextView);
        mProgressBar.getProgressDrawable().setColorFilter(
                Color.rgb(255,128,0), android.graphics.PorterDuff.Mode.SRC_IN);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(20);
                    mProgressBar.setProgress(mProgressStatus);

                }
                //mHandler.post(new Runnable() {
                    //@Override
                    //public void run() {
                //mLoadingText.setVisibility(View.VISIBLE);
                try {
                    Log.d("mylog", "e.getMessage()");
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                } catch (Exception e) {
                    Log.d("mylog", e.getMessage());
                }
            }
        }).start();

    }
}