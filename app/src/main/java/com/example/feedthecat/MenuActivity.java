package com.example.feedthecat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Menu");

        setContentView(R.layout.activity_menu);

    }

    public void aboutPressed(View view){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }
}
