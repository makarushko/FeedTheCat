package com.example.feedthecat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Feed The Cat");

        setContentView(R.layout.activity_menu);

    }

    public void aboutPressed(View view){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    public void resultsPressed(View view){
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(intent);
    }
}
