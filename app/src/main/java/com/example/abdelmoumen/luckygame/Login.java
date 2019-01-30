package com.example.abdelmoumen.luckygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {


    ///////// verify login information and go to game ////////////////////////////////////
    public void loginlogin(View view){
        Intent f = new Intent(this,(Game.class));

        EditText s = (EditText)findViewById(R.id.name) ;
        String str = s.getText().toString() ;

        EditText s2 = (EditText)findViewById(R.id.email);
        String str2 = s2.getText().toString() ;

        EditText s3 = (EditText)findViewById(R.id.pass);
        String str3 = s3.getText().toString() ;

        TextView t = (TextView)findViewById(R.id.error) ;


        if ( (str.equals("admin")) & (str2.equals("admin@gmail.com"))  & (str3.equals("admin"))) {
            t.setText("Success");
            startActivity(f);
        }else {
            t.setText("OPS !!  Try Again ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
