package com.example.abdelmoumen.luckygame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    ///// index of beginig //////////////
    int BEGIN =0 ;
    /////// lock players /////////
    boolean LockPlayer1 =false , LockPlayer2 =false ,END=false;


    /////// starting game , by choosing the first player randomly ////////////
    public void startgame(View view){
        Button three = (Button) findViewById(R.id.startbutton);

        ////// set the button of start invisible ///////////
        three.setVisibility(View.INVISIBLE);

        ////// choose a random player /////////
        GenerateRandomPlayer();

    }

    ////// generate random player for the first play //////////
    public void GenerateRandomPlayer(){
        Random r = new Random();
        int player = r.nextInt(2)+1;

        if (player == 1 ){

            ////// allow player one to play ////////
            PlayerOnePlay();
            LockPlayer2 = true ;
        }else {

            ///// alow player 2 to play /////////
            PlayerTwoPlay();
            LockPlayer1 = true ;
        }
    }


    //////////// creating tableau with   " Buttons -> indexes "  each button has index , the first button has index 0
    public void CreateTab(){
        Button tabone = (Button) findViewById(R.id.one);
        Button tabtwo = (Button) findViewById(R.id.two);
        Button tabthree = (Button) findViewById(R.id.three);
        Button tabfour = (Button) findViewById(R.id.four);
        Button tabfive = (Button) findViewById(R.id.five);
        Button tabsix = (Button) findViewById(R.id.six);
        Button tabseven = (Button) findViewById(R.id.seven);
        Button tabeight = (Button) findViewById(R.id.eight);
        Button tabnine = (Button) findViewById(R.id.nine);
        Button tabten = (Button) findViewById(R.id.ten);
        Button tabeleven = (Button) findViewById(R.id.eleven);
        Button tabtwelve = (Button) findViewById(R.id.twelve);
        Button tabthirteen = (Button) findViewById(R.id.thirteen);
        Button tabfourteen = (Button) findViewById(R.id.fourteen);
        Button tabfiveteen = (Button) findViewById(R.id.fiveteen);
        Button tabsixteen = (Button) findViewById(R.id.sixteen);
        Button tabseventeen = (Button) findViewById(R.id.seventeen);
        Button tabeighteen = (Button) findViewById(R.id.eighteen);
        Button tabnineteen = (Button) findViewById(R.id.nineteen);
        Button tabtwenty = (Button) findViewById(R.id.twenty);
        Button tabtwentyone = (Button) findViewById(R.id.twentyone);
        Button tabtwentytwo = (Button) findViewById(R.id.twentytwo);
        Button tabtwentythree = (Button) findViewById(R.id.twentythree);
        Button tabtwentyfour = (Button) findViewById(R.id.twentyfour);
        Button tabtwentyfive = (Button) findViewById(R.id.twentyfive);

        ////// create  ARRAYlist
        ArrayList<Button> tab = new ArrayList<Button>();

        ////// add values IN THE ARRAYLIST/////////
        tab.add(tabone);
        tab.add(tabtwo);
        tab.add(tabthree);
        tab.add(tabfour);
        tab.add(tabfive);
        tab.add(tabsix);
        tab.add(tabseven);
        tab.add(tabeight);
        tab.add(tabnine);
        tab.add(tabten);
        tab.add(tabeleven);
        tab.add(tabtwelve);
        tab.add(tabthirteen);
        tab.add(tabfourteen);
        tab.add(tabfiveteen);
        tab.add(tabsixteen);
        tab.add(tabseventeen);
        tab.add(tabeighteen);
        tab.add(tabnineteen);
        tab.add(tabtwenty);
        tab.add(tabtwentyone);
        tab.add(tabtwentytwo);
        tab.add(tabtwentythree);
        tab.add(tabtwentyfour);
        tab.add(tabtwentyfive);

        //////// change color of boxes , from 0 to the Begin
        for (int i=0 ; i<= BEGIN-1 ; i ++){
            Button test = tab.get(i) ;
            test.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            if (test == tabtwentyfive){
                END=true ;
            }
        }
        if (END){

            EndGame();
        }
    }
    public void RoundOne(View view)  {
        Random r = new Random();
        int s = r.nextInt(26-BEGIN)+BEGIN ;
        LockPlayer1 = true ;
        LockPlayer2 = false ;

        Toast toast = Toast.makeText(getApplicationContext(),"Generate Random : "+(s-BEGIN)+"" ,Toast.LENGTH_SHORT) ;
        toast.show();
        BEGIN = s ;
        CreateTab();
        Convert () ;

    }
    public void RoundTwo(View view){
        Random r = new Random();
        int s = r.nextInt(26-BEGIN)+BEGIN ;
        LockPlayer2 = true ;
        LockPlayer1 = false ;

        Toast toast = Toast.makeText(getApplicationContext(),"Generate Random : "+(s-BEGIN)+"" ,Toast.LENGTH_SHORT) ;
        toast.show();
        BEGIN = s ;
        CreateTab();
        Convert () ;

    }


    /////////// end game ////////

    public void EndGame(){
        RelativeLayout t = (RelativeLayout) findViewById(R.id.winnerbackground);
        TextView b = (TextView) findViewById(R.id.winnertext);

        t.setVisibility(View.VISIBLE);

        if (LockPlayer2){
            b.setText("Player 2 - WIN");
        }else{
            b.setText("Player 1 - WIN");
        }

        Button one = (Button) findViewById(R.id.buttonone);
        Button two = (Button) findViewById(R.id.buttontwo);
        Button again = (Button) findViewById(R.id.playagain);

        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);
        again.setVisibility(View.VISIBLE);

        LockPlayer2 = true ;
        LockPlayer1 = true ;


    }

    ///////// set button player one visible and button player two invisible ////////////
    public void PlayerOnePlay(){
        Button one = (Button) findViewById(R.id.buttonone);
        Button two = (Button) findViewById(R.id.buttontwo);

        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.INVISIBLE);
    }


    ///////// set button player two visible and button player one invisible ////////////
    public void PlayerTwoPlay(){
        Button one = (Button) findViewById(R.id.buttonone);
        Button two = (Button) findViewById(R.id.buttontwo);

        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.VISIBLE);
    }


    public void Convert (){
        if ((LockPlayer1==true) & (LockPlayer2==false)){
            PlayerTwoPlay();
        }else if ((LockPlayer2==true) & (LockPlayer1==false)) {
            PlayerOnePlay();
        }
    }

    public void PLAYAGAIN(View view){
        Intent l = new Intent(this,Game.class);
        startActivity(l);
    }

}
