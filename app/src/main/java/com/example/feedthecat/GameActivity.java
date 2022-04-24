package com.example.feedthecat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class GameActivity extends AppCompatActivity {

    private TextView satiety_textView;
    private int clicks = 0;
    private String personName;
    private ImageView imageView;
    AnimationDrawable frameAnimation;

    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Game");
        setContentView(R.layout.activity_game);

        satiety_textView = findViewById(R.id.score);
        imageView=findViewById(R.id.cat);
        imageView.setBackgroundResource(R.drawable.animation);
        frameAnimation = (AnimationDrawable) imageView.getBackground();
        name = findViewById(R.id.name);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            personName = acct.getDisplayName();
            name.setText(personName);
        }

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent1  =new Intent(this,MenuActivity.class);
                startActivity(intent1);
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }

    public void feedButtonClick(View view) {
        clicks++;
        satiety_textView.setText(String.valueOf(clicks));
        if (clicks % 15 == 0) {
            if(!frameAnimation.isRunning()) {
                frameAnimation.setVisible(true,true);
                frameAnimation.start();
            }
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);


        }
        else if(frameAnimation.isRunning()){
            frameAnimation.setVisible(false,false);
            frameAnimation.stop();
        }
    }

}
