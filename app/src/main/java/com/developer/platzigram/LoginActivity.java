package com.developer.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.developer.platzigram.view.ConteinerActivity;
import com.developer.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void gotToCreatAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void gotToHome(View view){
        Intent intent = new Intent(this, ConteinerActivity.class);
        startActivity(intent);
    }

    public void goToPlatziCom(View view){
        Intent intent =  new Intent(Intent.ACTION_VIEW,Uri.parse("https://platzi.com"));
        startActivity(intent);
    }
}
