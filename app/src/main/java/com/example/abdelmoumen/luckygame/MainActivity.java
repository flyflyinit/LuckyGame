package com.example.abdelmoumen.luckygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ////// GOTO LOGIN ACTIVITY ////////////////////////////
    public void start (View view){
        Intent LoginIntent = new Intent(this,Login.class);
        startActivity(LoginIntent);
    }

}
