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


    ///// INDEX OF BEGINNING //////////////
    int BEGIN = 0;

    /////// THESE VARIABLES BELOW USED TO CONTROL PLAYERS , IF IT IS THE ROUND OF PLAYER1 THEN PLAYER2 SHOULD BE LOCKED /////////
    boolean LockPlayer1 = false, LockPlayer2 = false, END = false;


    /////// THIS IS THE START OF THE GAME , THE FIRST PLAYER GENERATED RANDOMLY ////////////
    public void StartGame(View view) {
        Button three = (Button) findViewById(R.id.startbutton);

        ////// MAKE THE BUTTON INVISIBLE ///////////
        three.setVisibility(View.INVISIBLE);

        ////// CHOOSE RANDOM PLAYER /////////
        GenerateRandomPlayer();
    }

    ////// generate random player for the first play //////////
    public void GenerateRandomPlayer() {
        Random r = new Random();

        /// THIS INTEGER SHOULD BE 1 OR 2 /// THIS GENERATE 1 OR 2
        int player = r.nextInt(2) + 1;


        if (player == 1) {
            /// IF THE RANDOM NUMBER IS 1 ,MEANS THAT PLAYER1 SHOULD PLAY NOW --> AND LOCK PLAYER 2  ////////
            PlayerOnePlay();
            LockPlayer2 = true;

        } else {

            /// IF THE RANDOM NUMBER IS 2 ,MEANS THAT PLAYER2 SHOULD PLAY NOW --> AND LOCK PLAYER 1  ////////
            PlayerTwoPlay();
            LockPlayer1 = true;
        }
    }


    //////////// CREATING TABLE ,THIS TABLE CONTAINS EACH CUBS , AND EACH CUB HAS AN INDEX /// INDEXES START FROM 0 TO 24
    public void CreateTab() {

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

        ////// CREATE ARRAY LIST WITH TYPE BUTTON //
        ArrayList<Button> tab = new ArrayList<Button>();

        ////// ADD EACH CUBS IN ARRAY LIST  /////
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

        //////// CHANGE CUBS' COLORS /// EACH TIME CHANGE FROM         INDEX -> 0    TO    INDEX -> BEGIN - 1
        for (int i = 0 ; i <= BEGIN -1 ; i++) {
            Button cub = tab.get(i);
            cub.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            //// STOP WHEN FIND THE LAST CUB // THIS MEAN THAT THE GAME IS OVER
            if (cub == tabtwentyfive) {
                /// BOOLEAN END = TRUE   WHEN THE GAME IS OVER (END)
                END = true;
            }
        }
        if (END) {
            /// END THE GAME
            EndGame();
        }
    }


    //// THIS IS FOR PLAYER 1 ///
    public void RoundOne(View view) {
        //// GENERATE RANDOM NUMBER FROM THE LAST INDEX (BEGIN VARIABLE) TO 25 (THE NUMBERS OF CUBS)
        Random r = new Random();
        int s = r.nextInt(26 - BEGIN) + BEGIN;

        //// CHANGE BOOLEAN VARIABLE STATE
        LockPlayer1 = true;
        LockPlayer2 = false;

        //// SHOW SMALL MESSAGE ON THE SCREEN (THE GENERATED RANDOM NUMBER)
        Toast toast = Toast.makeText(getApplicationContext(), "Generate Random : " + (s - BEGIN) + "", Toast.LENGTH_SHORT);
        toast.show();

        //// CHANGE INDEX (BEGIN VARIABLE)
        BEGIN = s;

        ///// SHOW ON THE SCREEN THE RESULT
        CreateTab();

        ///// NOW WE SHOULD CONVERT THE STATE OF BUTTONS VISIBILITY (PLAYER 1 WILL BE INVISIBLE   AND   PLAYER 2 WILL BE VISIBLE)
        Convert();
    }


    //// THIS IS FOR PLAYER 2
    public void RoundTwo(View view) {
        //// GENERATE RANDOM NUMBER FROM THE LAST INDEX (BEGIN VARIABLE) TO 25 (THE NUMBERS OF CUBS)
        Random r = new Random();
        int s = r.nextInt(26 - BEGIN) + BEGIN;

        //// CHANGE BOOLEAN VARIABLE STATE
        LockPlayer2 = true;
        LockPlayer1 = false;

        //// SHOW SMALL MESSAGE ON THE SCREEN (THE GENERATED RANDOM NUMBER)
        Toast toast = Toast.makeText(getApplicationContext(), "Generate Random : " + (s - BEGIN) + "", Toast.LENGTH_SHORT);
        toast.show();

        //// CHANGE INDEX (BEGIN VARIABLE)
        BEGIN = s;

        ///// SHOW ON THE SCREEN THE RESULT
        CreateTab();

        ///// NOW WE SHOULD CONVERT THE STATE OF BUTTONS VISIBILITY (PLAYER 2 WILL BE INVISIBLE   AND   PLAYER 1 WILL BE VISIBLE)
        Convert();
    }


    /////////// END THE GAME ////////
    public void EndGame() {

        RelativeLayout t = (RelativeLayout) findViewById(R.id.winnerbackground);
        TextView b = (TextView) findViewById(R.id.winnertext);

        /// MAKE IT VISIBLE
        t.setVisibility(View.VISIBLE);

        //// SHOW THE WINNER NAME
        if (LockPlayer2) {
            b.setText("Player 2 - WIN");
        } else {
            b.setText("Player 1 - WIN");
        }

        Button one = (Button) findViewById(R.id.buttonone);
        Button two = (Button) findViewById(R.id.buttontwo);
        Button again = (Button) findViewById(R.id.playagain);

        /// INVISIBLE THE PLAYER 1 AND 2 BUTTONS
        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);

        /// VISIBLE THE AGAIN BUTTON
        again.setVisibility(View.VISIBLE);

        /// LOCK BOTH PLAYERS
        LockPlayer2 = true;
        LockPlayer1 = true;
    }


    ///// BASICALLY WHEN WE SAY THAT PLAYER 1 SHOULD PLAY NOW ,THIS MEAN THAT PLAYER 2 WILL BE LOCKED , AND PLAYER 2 LOCKED MEAN THAT WE ARE GOING TO CHANGE THE STATE OF THE PLAYERS BUTTON BY CHANGING THE VISIBILITY //////

    //// MAKE BUTTON (PLAYER 1) VISIBLE AND BUTTON (PLAYER 2) INVISIBLE
    public void PlayerOnePlay() {
        Button one = (Button) findViewById(R.id.buttonone);
        Button two = (Button) findViewById(R.id.buttontwo);

        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.INVISIBLE);
    }

    //// MAKE BUTTON (PLAYER 2) VISIBLE AND BUTTON (PLAYER 1) INVISIBLE
    public void PlayerTwoPlay() {
        Button one = (Button) findViewById(R.id.buttonone);
        Button two = (Button) findViewById(R.id.buttontwo);

        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.VISIBLE);
    }


    public void Convert() {
        if ((LockPlayer1 == true) & (LockPlayer2 == false)) {
            PlayerTwoPlay();
        } else if ((LockPlayer2 == true) & (LockPlayer1 == false)) {
            PlayerOnePlay();
        }
    }

    public void PlayAgain(View view) {
        Intent GameIntent = new Intent(this, Game.class);
        startActivity(GameIntent);
    }

}
