package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ImageView mainMenu;
    public int touchedPiece;// value of the position in stringBoard
    Set<Integer> validMoves;
    String movedpieces[] = new String[100];
    int from [] = new int[100];
    int to [] = new int [100];
    int index = 0;
    public String[][] Game = new String[100][100];


    public String[] stringBoard = {
            "wr", "wn", "wb", "wq", "wk", "wb", "wn", "wr",
            "wp", "wp", "wp", "wp", "wp", "wp", "wp", "wp",
            "0", "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "0", "0", "0", "0", "0", "0",
            "bp", "bp", "bp", "bp", "bp", "bp", "bp", "bp",
            "br", "bn", "bb", "bq", "bk", "bb", "bn", "br"
    };


    public int[] position = {
            R.id.a1, R.id.b1, R.id.c1, R.id.d1, R.id.e1, R.id.f1, R.id.g1, R.id.h1,
            R.id.a2, R.id.b2, R.id.c2, R.id.d2, R.id.e2, R.id.f2, R.id.g2, R.id.h2,
            R.id.a3, R.id.b3, R.id.c3, R.id.d3, R.id.e3, R.id.f3, R.id.g3, R.id.h3,
            R.id.a4, R.id.b4, R.id.c4, R.id.d4, R.id.e4, R.id.f4, R.id.g4, R.id.h4,

            R.id.a5, R.id.b5, R.id.c5, R.id.d5, R.id.e5, R.id.f5, R.id.g5, R.id.h5,
            R.id.a6, R.id.b6, R.id.c6, R.id.d6, R.id.e6, R.id.f6, R.id.g6, R.id.h6,
            R.id.a7, R.id.b7, R.id.c7, R.id.d7, R.id.e7, R.id.f7, R.id.g7, R.id.h7,
            R.id.a8, R.id.b8, R.id.c8, R.id.d8, R.id.e8, R.id.f8, R.id.g8, R.id.h8
    };
    public int val = 0;
    public String currentPlayer = "white";
    ImageView prevView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < 64; i++)Game[index][i] = stringBoard[i];
        mainMenu = findViewById(R.id.back);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, FirstActivity.class));
            }
        });
        ImageView img = findViewById(R.id.a1);
        img.setTag(R.drawable.wr);
        img.setContentDescription(String.valueOf(R.id.a11));


        img = findViewById(R.id.b1);
        img.setContentDescription(String.valueOf(R.id.b11));
        img.setTag(R.drawable.wn);

        img = findViewById(R.id.c1);
        img.setContentDescription(String.valueOf(R.id.c11));

        img.setTag(R.drawable.wb);
        img = findViewById(R.id.d1);
        img.setContentDescription(String.valueOf(R.id.d11));
        img.setTag(R.drawable.wq);
        img = findViewById(R.id.e1);
        img.setContentDescription(String.valueOf(R.id.e11));
        img.setTag(R.drawable.wk);
        img = findViewById(R.id.f1);
        img.setContentDescription(String.valueOf(R.id.f11));
        img.setTag(R.drawable.wb);
        img = findViewById(R.id.g1);
        img.setContentDescription(String.valueOf(R.id.g11));
        img.setTag(R.drawable.wn);
        img = findViewById(R.id.h1);
        img.setContentDescription(String.valueOf(R.id.h11));
        img.setTag(R.drawable.wr);
        img = findViewById(R.id.a2);
        img.setContentDescription(String.valueOf(R.id.a21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.b2);
        img.setContentDescription(String.valueOf(R.id.b21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.c2);
        img.setContentDescription(String.valueOf(R.id.c21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.d2);
        img.setContentDescription(String.valueOf(R.id.d21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.e2);
        img.setContentDescription(String.valueOf(R.id.e21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.f2);
        img.setContentDescription(String.valueOf(R.id.f21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.g2);
        img.setContentDescription(String.valueOf(R.id.g21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.h2);
        img.setContentDescription(String.valueOf(R.id.h21));
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.a8);
        img.setContentDescription(String.valueOf(R.id.a81));
        img.setTag(R.drawable.br);
        img = findViewById(R.id.b8);
        img.setContentDescription(String.valueOf(R.id.b81));
        img.setTag(R.drawable.bn);
        img = findViewById(R.id.c8);
        img.setContentDescription(String.valueOf(R.id.c81));
        img.setTag(R.drawable.bb);
        img = findViewById(R.id.d8);
        img.setContentDescription(String.valueOf(R.id.d81));
        img.setTag(R.drawable.bq);
        img = findViewById(R.id.e8);
        img.setContentDescription(String.valueOf(R.id.e81));
        img.setTag(R.drawable.bk);
        img = findViewById(R.id.f8);
        img.setContentDescription(String.valueOf(R.id.f81));
        img.setTag(R.drawable.bb);
        img = findViewById(R.id.g8);
        img.setContentDescription(String.valueOf(R.id.g81));
        img.setTag(R.drawable.bn);
        img = findViewById(R.id.h8);
        img.setContentDescription(String.valueOf(R.id.h81));
        img.setTag(R.drawable.br);
        img = findViewById(R.id.a7);
        img.setContentDescription(String.valueOf(R.id.a71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.b7);
        img.setContentDescription(String.valueOf(R.id.b71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.c7);
        img.setContentDescription(String.valueOf(R.id.c71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.d7);
        img.setContentDescription(String.valueOf(R.id.d71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.e7);
        img.setContentDescription(String.valueOf(R.id.e71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.f7);
        img.setContentDescription(String.valueOf(R.id.f71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.g7);
        img.setContentDescription(String.valueOf(R.id.g71));
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.h7);
        img.setContentDescription(String.valueOf(R.id.h71));
        img.setTag(R.drawable.bp);

        img = findViewById(R.id.a5);
        img.setContentDescription(String.valueOf(R.id.a51));
        img.setTag(0);
        img = findViewById(R.id.b5);
        img.setContentDescription(String.valueOf(R.id.b51));
        img.setTag(0);
        img = findViewById(R.id.c5);
        img.setContentDescription(String.valueOf(R.id.c51));
        img.setTag(0);
        img = findViewById(R.id.d5);
        img.setContentDescription(String.valueOf(R.id.d51));
        img.setTag(0);
        img = findViewById(R.id.e5);
        img.setContentDescription(String.valueOf(R.id.e51));
        img.setTag(0);
        img = findViewById(R.id.f5);
        img.setContentDescription(String.valueOf(R.id.f51));
        img.setTag(0);
        img = findViewById(R.id.g5);
        img.setContentDescription(String.valueOf(R.id.g51));
        img.setTag(0);
        img = findViewById(R.id.h5);
        img.setContentDescription(String.valueOf(R.id.h51));
        img.setTag(0);
        img = findViewById(R.id.a4);
        img.setContentDescription(String.valueOf(R.id.a41));
        img.setTag(0);
        img = findViewById(R.id.b4);
        img.setContentDescription(String.valueOf(R.id.b41));
        img.setTag(0);
        img = findViewById(R.id.c4);
        img.setContentDescription(String.valueOf(R.id.c41));
        img.setTag(0);
        img = findViewById(R.id.d4);
        img.setContentDescription(String.valueOf(R.id.d41));
        img.setTag(0);
        img = findViewById(R.id.e4);
        img.setContentDescription(String.valueOf(R.id.e41));
        img.setTag(0);
        img = findViewById(R.id.f4);
        img.setContentDescription(String.valueOf(R.id.f41));
        img.setTag(0);
        img = findViewById(R.id.g4);
        img.setContentDescription(String.valueOf(R.id.g41));
        img.setTag(0);
        img = findViewById(R.id.h4);
        img.setContentDescription(String.valueOf(R.id.h41));
        img.setTag(0);


        img = findViewById(R.id.a3);
        img.setContentDescription(String.valueOf(R.id.a31));
        img.setTag(0);
        img = findViewById(R.id.b3);
        img.setContentDescription(String.valueOf(R.id.b31));
        img.setTag(0);
        img = findViewById(R.id.c3);
        img.setContentDescription(String.valueOf(R.id.c31));
        img.setTag(0);
        img = findViewById(R.id.d3);
        img.setContentDescription(String.valueOf(R.id.d31));
        img.setTag(0);
        img = findViewById(R.id.e3);
        img.setContentDescription(String.valueOf(R.id.e31));
        img.setTag(0);
        img = findViewById(R.id.f3);
        img.setContentDescription(String.valueOf(R.id.f31));
        img.setTag(0);
        img = findViewById(R.id.g3);
        img.setContentDescription(String.valueOf(R.id.g31));
        img.setTag(0);
        img = findViewById(R.id.h3);
        img.setContentDescription(String.valueOf(R.id.h31));
        img.setTag(0);
        img = findViewById(R.id.a6);
        img.setContentDescription(String.valueOf(R.id.a61));
        img.setTag(0);
        img = findViewById(R.id.b6);
        img.setContentDescription(String.valueOf(R.id.b61));
        img.setTag(0);
        img = findViewById(R.id.c6);
        img.setContentDescription(String.valueOf(R.id.c61));
        img.setTag(0);
        img = findViewById(R.id.d6);
        img.setContentDescription(String.valueOf(R.id.d61));
        img.setTag(0);
        img = findViewById(R.id.e6);
        img.setContentDescription(String.valueOf(R.id.e61));
        img.setTag(0);
        img = findViewById(R.id.f6);
        img.setContentDescription(String.valueOf(R.id.f61));
        img.setTag(0);
        img = findViewById(R.id.g6);
        img.setContentDescription(String.valueOf(R.id.g61));
        img.setTag(0);
        img = findViewById(R.id.h6);
        img.setContentDescription(String.valueOf(R.id.h61));
        img.setTag(0);


    }

    public void click(View view) {
        ImageView imageView = (ImageView) view;
        if (val != 0) {
            changeImageResource();
            Log.d("hello", "click: " + validMoves);
            int move = findMove(imageView.getId());
            if (validMoves.contains(move)) {


                //checking castling previleges

                if(checkTag(val) == "wk" && stringBoard[4] == "wk" && move == 6) {
                    stringBoard[7] = "0";
                    stringBoard[5] = "wr";
                    ImageView it = findViewById(position[7]);
                    it.setImageResource(0);
                    it.setTag(0);
                    it = findViewById(position[5]);
                    it.setImageResource(R.drawable.wr);
                    it.setTag(R.drawable.wr);
                }
                if(checkTag(val) == "wk" && stringBoard[4] == "wk" && move == 2) {
                    stringBoard[0] = "0";
                    stringBoard[3] = "wr";
                    ImageView it = findViewById(position[0]);
                    it.setImageResource(0);
                    it.setTag(0);
                    it = findViewById(position[3]);
                    it.setImageResource(R.drawable.wr);
                    it.setTag(R.drawable.wr);
                }
                if(checkTag(val) == "bk" && stringBoard[60] == "bk" && move == 62) {
                    stringBoard[63] = "0";
                    stringBoard[61] = "br";
                    ImageView it = findViewById(position[63]);
                    it.setImageResource(0);
                    it.setTag(0);
                    it = findViewById(position[61]);
                    it.setImageResource(R.drawable.br);
                    it.setTag(R.drawable.br);
                }
                if(checkTag(val) == "bk" && stringBoard[60] == "bk" && move == 58) {
                    stringBoard[56] = "0";
                    stringBoard[59] = "br";
                    ImageView it = findViewById(position[56]);
                    it.setImageResource(0);
                    it.setTag(0);
                    it = findViewById(position[59]);
                    it.setImageResource(R.drawable.br);
                    it.setTag(R.drawable.br);
                }









                if(checkTag(val).length() > 1 && checkTag(val).charAt(1) == 'p' && ((move <= 63 && move >= 56) || (move <= 7 && move >= 0))) {
                    askOptions(true, imageView, move);
                }
                Log.d("hello", "click: helloworkinghello" + move);
                if(index > 0 && move == to[index - 1] + 8 && checkTag(val) == "wp") {
                    Log.d("hello", "click: helloworkinghello");
                    stringBoard[to[index - 1]] = "0";
                    ((ImageView)(findViewById(position[to[index - 1]]))).setImageResource(0);
                    ((ImageView)(findViewById(position[to[index - 1]]))).setTag(0);
                }
                if(index > 0 && move == to[index - 1] - 8 && checkTag(val) == "bp") {
                    Log.d("hello", "click: helloworkinghello");
                    stringBoard[to[index - 1]] = "0";
                    ((ImageView)(findViewById(position[to[index - 1]]))).setImageResource(0);
                    ((ImageView)(findViewById(position[to[index - 1]]))).setTag(0);
                }
                imageView.setImageResource(val);
                stringBoard[move] = checkTag(val);
                stringBoard[touchedPiece] = "0";
                imageView.setTag(val);
                prevView.setImageResource(0);
                prevView.setTag(0);
                movedpieces[index] = checkTag(val);
                from[index]= findMove(prevView.getId());
                to[index] = findMove(imageView.getId());
                val = 0;

                for(int i = 0; i < 64; i++) {
                    Game[index][i] = stringBoard[i];
                }
                for(int i = 0; i < 64; i++) Log.d("hello", "click: clickx" + stringBoard[i] + Game[index - 1 >= 0 ? index - 1 : 0][i]);

                index++;
                Set<Integer>legal;
                legal = legalMoves(true);
                if(legal.contains(findPiece("bk"))) {
                    ImageView bk = findViewById(position[(findPiece("bk"))]);
                    bk.setBackgroundColor(Color.RED);
                }
                else {
                    ImageView bk = findViewById(position[(findPiece("bk"))]);
                    bk.setBackgroundColor(0);
                }
                legal = legalMoves(false);
                if(legal.contains(findPiece("wk"))) {
                    ImageView bk = findViewById(position[(findPiece("wk"))]);
                    bk.setBackgroundColor(Color.RED);
                }
                else {
                    ImageView bk = findViewById(position[(findPiece("wk"))]);
                    bk.setBackgroundColor(0);
                }
                //set the image resource to null again to change the checkstatus
                ImageView bk = findViewById(Integer.parseInt(prevView.getContentDescription().toString()));
                bk.setBackgroundColor(0);
                currentPlayer = switchPlayer();
                checkIfCheckMate();


            } else val = 0;


        } else {
            Log.d("hello", "click: current click " + checkTag(Integer.parseInt(imageView.getTag().toString())));
            if (validatePlayer(imageView)) {
                val = (int) imageView.getTag();
                prevView = imageView;
                prevView.setBackgroundColor(0);
                touchedPiece = findMove((int) imageView.getId());

                Log.d("hello", "click: color" + touchedPiece);
                getValidMoves(imageView);
                Set<Integer> notValid = new HashSet<>();
                for (Integer validMove : validMoves) {
                    stringBoard[touchedPiece] = "0";
                    String temp = stringBoard[validMove];
                    Log.d("hello", "click: temp" + temp);
                    stringBoard[validMove] = checkTag(val);
                    Set<Integer> legal = new HashSet<>();
                    legal = legalMoves(currentPlayer =="black");
                    Log.d("hello", "click: legalmoves see hte " + legal);
                    int k = currentPlayer == "white" ? findPiece("wk") : findPiece("bk");
                    Log.d("hello", "click: king " + k );
                    if(!legal.contains(k)) {
                        ImageView imx = findViewById(Integer.parseInt(findViewById(position[validMove]).getContentDescription().toString()));
                        imx.setImageResource(R.drawable.legal);
                    }
                    else {
                        notValid.add(validMove);
                    }

                    stringBoard[touchedPiece] = checkTag(val);
                    stringBoard[validMove] = temp;


                }
                Log.d("hello", "click: validmovescheck" + validMoves);
                for(Integer notVali: notValid) {
                    validMoves.remove(notVali);
                }
                Log.d("hello", "click: validmovescheck" + validMoves);

            }

        }
        Log.d("hello", "click: this is " + val);


    }

    //Return the string of which piece is occupying the square for eg. wp->white pawn
    public static String checkTag(int val) {
        if (val == R.drawable.wp) return "wp";
        else if (val == R.drawable.bp) return "bp";
        else if (val == R.drawable.wr) return "wr";
        else if (val == R.drawable.br) return "br";
        else if (val == R.drawable.wb) return "wb";
        else if (val == R.drawable.bb) return "bb";
        else if (val == R.drawable.wn) return "wn";
        else if (val == R.drawable.bn) return "bn";
        else if (val == R.drawable.wq) return "wq";
        else if (val == R.drawable.bq) return "bq";
        else if (val == R.drawable.wk) return "wk";
        else if (val == R.drawable.bk) return "bk";
        else return "0";
    }

    //Check if the correct player is playing
    public boolean validatePlayer(final ImageView imageView) {
        String tag = checkTag((int) imageView.getTag());
        if (tag.charAt(0) == currentPlayer.charAt(0)) {
            imageView.setBackgroundColor(Color.GRAY);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    changeColor(imageView);
                }
            }, 500);   //0.5 seconds
            return true;
        } else {
            imageView.setBackgroundColor(Color.RED);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    changeColor(imageView);
                }
            }, 500);   //0.5 seconds

            return false;


        }
    }

    //Return the switched player
    public String switchPlayer() {
        if (currentPlayer == "white") return "black";
        else return "white";
    }

    //Change the color to transparent again
    public void changeColor(ImageView imageView) {
        imageView.setBackgroundColor(0);
    }

    public void getValidMoves(ImageView imageView) {
        validMoves = new HashSet<>();
//        for(int i = 0; i < 20; i++) {
//            possibleMoves[i] = -1;
//        }
        char piece = checkTag(Integer.parseInt(imageView.getTag().toString())).charAt(1);
        Log.d("hello", "getValidMoves: " + piece);
        if (currentPlayer == "white") {
            if (piece == 'p') {
                Log.d("hello", "getValidMoves: first");
                if (touchedPiece <= 15 && touchedPiece >= 8) {
                    if (stringBoard[touchedPiece + 16] == "0") validMoves.add(touchedPiece + 16);
                    Log.d("hello", "getValidMoves: validMoves" + validMoves);
                }
                if (stringBoard[touchedPiece + 8] == "0") validMoves.add(touchedPiece + 8);
                if (stringBoard[touchedPiece + 9].charAt(0) == 'b' && touchedPiece% 8 != 7)
                    validMoves.add(touchedPiece + 9);
                if (stringBoard[touchedPiece + 7].charAt(0) == 'b' && touchedPiece % 8 != 0)
                    validMoves.add(touchedPiece + 7);
                if((touchedPiece <= 39 && touchedPiece >= 32) && (to[index - 1] - touchedPiece == 1 || to[index - 1] - touchedPiece == -1) && movedpieces[index - 1] == "bp")validMoves.add(to[index - 1] + 8);
            } else if (piece == 'b') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
            } else if (piece == 'r') {
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


                Log.d("hello", "getValidMoves: rook" + validMoves);
            }
            if (piece == 'q') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


            }
            if (piece == 'n') {
                if (touchedPiece % 8 == 0) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 10);
//                    if(stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 6);
//                    if(stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 7) {
//                    if(stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 10);
//                    if(stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 1) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 6) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 6);
                } else {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 6);
                }
            }
            if (piece == 'k') {
                if (touchedPiece % 8 == 0) {

                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 1);
                    }
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 8);
                    }
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 8);
                    }
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 9);
                    }
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 7);
                    }
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece + 1);
                    }
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece + 8);
                    }
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece - 8);
                    }
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece + 9);
                    }
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece - 7);
                    }



                } else if (touchedPiece % 8 == 7) {
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 1);
                    }
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 8);
                    }
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 8);
                    }
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 9);
                    }
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 7);
                    }
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                } else {
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 7);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 7);
                }

                //checking castling priveleges kingside
                boolean c = true;
                for(int i = 0; i < index; i++) {
                    if(movedpieces[i] == "wk" || from[i] == 7) {
                        c = false;
                        break;
                    }
                }
                Set<Integer> legal = legalMoves(false);
                if(legal.contains(4) || legal.contains(5) || legal.contains(6))c = false;
                if(stringBoard[5] != "0" || stringBoard[6] != "0")c= false;
                if(c)validMoves.add(6);


                //checking castling priveleges queenside
                c = true;
                for(int i = 0; i < index; i++) {
                    if(movedpieces[i] == "wk" || from[i] == 0) {
                        c = false;
                        break;
                    }
                }
                legal = legalMoves(false);
                if(legal.contains(4) || legal.contains(3) || legal.contains(2))c = false;
                if(stringBoard[1] != "0" || stringBoard[2] != "0" || stringBoard[3] != "0")c= false;
                if(c)validMoves.add(2);



            }


        } else {
            if (piece == 'p') {
                Log.d("hello", "getValidMoves: first");
                if (touchedPiece <= 55 && touchedPiece >= 48) {
                    if (stringBoard[touchedPiece - 16] == "0") validMoves.add(touchedPiece - 16);
                    Log.d("hello", "getValidMoves: validMoves" + validMoves);
                }
                if (stringBoard[touchedPiece - 8] == "0") validMoves.add(touchedPiece - 8);
                if (stringBoard[touchedPiece - 9].charAt(0) == 'w' && touchedPiece % 8 != 0)
                    validMoves.add(touchedPiece - 9);
                if (stringBoard[touchedPiece - 7].charAt(0) == 'w' && touchedPiece % 8 != 7)
                    validMoves.add(touchedPiece - 7);
                if((touchedPiece <= 31 && touchedPiece >= 24) && (to[index - 1] - touchedPiece == 1 || to[index - 1] - touchedPiece == -1) && movedpieces[index - 1] == "wp")validMoves.add(to[index - 1] - 8);
            } else if (piece == 'b') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
            } else if (piece == 'r') {
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


                Log.d("hello", "getValidMoves: rook" + validMoves);
            }
            if (piece == 'q') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


            }
            if (piece == 'n') {
                if (touchedPiece % 8 == 0) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 10);
//                    if(stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 6);
//                    if(stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 7) {
//                    if(stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 10);
//                    if(stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 1) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 6) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 6);
                } else {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 6);
                }
            }
            if (piece == 'k') {
                if (touchedPiece % 8 == 0) {
                    if (Castle.isCanBlackCastleKingSide()) validMoves.add(touchedPiece + 2);
                    if (Castle.isCanBlackCastleQueenSide()) validMoves.add(touchedPiece - 2);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 7);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 7);
                } else if (touchedPiece % 8 == 7) {
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                } else {
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 7);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 7);
                }


                //checking castling priveleges kingside
                boolean c = true;
                for(int i = 0; i < index; i++) {
                    if(movedpieces[i] == "bk" || from[i] == 63) {
                        c = false;
                        break;
                    }
                }
                Set<Integer> legal = legalMoves(true);
                if(legal.contains(60) || legal.contains(61) || legal.contains(62))c = false;
                if(stringBoard[61] != "0" || stringBoard[62] != "0")c= false;
                if(c)validMoves.add(62);


                //checking castling priveleges queenside
                c = true;
                for(int i = 0; i < index; i++) {
                    if(movedpieces[i] == "bk" || from[i] == 56) {
                        c = false;
                        break;
                    }
                }
                legal = legalMoves(true);
                if(legal.contains(60) || legal.contains(59) || legal.contains(58))c = false;
                if(stringBoard[57] != "0" || stringBoard[59] != "0" || stringBoard[58] != "0")c= false;
                if(c)validMoves.add(58);








            }
        }
    }
    public void getValidMoves(ImageView imageView, int val,  int touchedPiece) {
        validMoves = new HashSet<>();
//        for(int i = 0; i < 20; i++) {
//            possibleMoves[i] = -1;
//        }
        char piece = checkTag(Integer.parseInt(imageView.getTag().toString())).charAt(1);
        Log.d("hello", "getValidMoves: " + piece);
        if (currentPlayer == "white") {
            if (piece == 'p') {
                Log.d("hello", "getValidMoves: first");
                if (touchedPiece <= 15 && touchedPiece >= 8) {
                    if (stringBoard[touchedPiece + 16] == "0") validMoves.add(touchedPiece + 16);
                    Log.d("hello", "getValidMoves: validMoves" + validMoves);
                }
                if (stringBoard[touchedPiece + 8] == "0") validMoves.add(touchedPiece + 8);
                if (stringBoard[touchedPiece + 9].charAt(0) == 'b' && touchedPiece% 8 != 7)
                    validMoves.add(touchedPiece + 9);
                if (stringBoard[touchedPiece + 7].charAt(0) == 'b' && touchedPiece % 8 != 0)
                    validMoves.add(touchedPiece + 7);
            } else if (piece == 'b') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
            } else if (piece == 'r') {
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


                Log.d("hello", "getValidMoves: rook" + validMoves);
            }
            if (piece == 'q') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


            }
            if (piece == 'n') {
                if (touchedPiece % 8 == 0) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 10);
//                    if(stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 6);
//                    if(stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 7) {
//                    if(stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 10);
//                    if(stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 1) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 6) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')validMoves.add(touchedPiece - 6);
                } else {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 6);
                }
            }
            if (piece == 'k') {
                if (touchedPiece % 8 == 0) {

                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 1);
                    }
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 8);
                    }
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 8);
                    }
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 9);
                    }
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 7);
                    }
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece + 1);
                    }
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece + 8);
                    }
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece - 8);
                    }
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece + 9);
                    }
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0") {
                        validMoves.add(touchedPiece - 7);
                    }
                } else if (touchedPiece % 8 == 7) {
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 1);
                    }
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 8);
                    }
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 8);
                    }
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece - 9);
                    }
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'b') {
                        validMoves.add(touchedPiece + 7);
                    }
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                } else {
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 7);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 7);
                }
                Set<Integer> legal = new HashSet<>();
                legal = legalMoves(false);
                Log.d("hello", "getValidMoves: legal" + legal);
                for(Integer leg : legal) {
                    validMoves.remove(leg);
                }
            }


        } else {
            if (piece == 'p') {
                Log.d("hello", "getValidMoves: first");
                if (touchedPiece <= 55 && touchedPiece >= 48) {
                    if (stringBoard[touchedPiece - 16] == "0") validMoves.add(touchedPiece - 16);
                    Log.d("hello", "getValidMoves: validMoves" + validMoves);
                }
                if (stringBoard[touchedPiece - 8] == "0") validMoves.add(touchedPiece - 8);
                if (stringBoard[touchedPiece - 9].charAt(0) == 'w' && touchedPiece % 8 != 0)
                    validMoves.add(touchedPiece - 9);
                if (stringBoard[touchedPiece - 7].charAt(0) == 'w' && touchedPiece % 8 != 7)
                    validMoves.add(touchedPiece - 7);
            } else if (piece == 'b') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
            } else if (piece == 'r') {
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


                Log.d("hello", "getValidMoves: rook" + validMoves);
            }
            if (piece == 'q') {
                for (int i = 1; i <= 8 && touchedPiece + i * 9 <= 63 && (touchedPiece + (i - 1) * 9) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece + i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 7 <= 63 && (touchedPiece + (i - 1) * 7) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece + i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece + i * 7);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 9 >= 0 && (touchedPiece - (i - 1) * 9) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i * 9].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 9].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 9);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 9);
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 7 >= 0 && (touchedPiece - (i - 1) * 7) % 8 != 7; i++) {
                    if (stringBoard[touchedPiece - i * 7].charAt(0) == 'b') break;
                    else if (stringBoard[touchedPiece - i * 7].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 7);
                        break;
                    } else {
                        validMoves.add(touchedPiece - i * 7);
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece + i) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece + i] == "0") validMoves.add(touchedPiece + i);
                    else if (stringBoard[touchedPiece + i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && (touchedPiece - i + 1) % 8 != 0; i++) {
                    if (stringBoard[touchedPiece - i] == "0") validMoves.add(touchedPiece - i);
                    else if (stringBoard[touchedPiece - i].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece + i * 8 <= 63; i++) {
                    if (stringBoard[touchedPiece + i * 8] == "0")
                        validMoves.add(touchedPiece + i * 8);
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece + i * 8);
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = 1; i <= 8 && touchedPiece - i * 8 >= 0; i++) {
                    if (stringBoard[touchedPiece - i * 8] == "0")
                        validMoves.add(touchedPiece - i * 8);
                    else if (stringBoard[touchedPiece - i * 8].charAt(0) == 'w') {
                        validMoves.add(touchedPiece - i * 8);
                        break;
                    } else {
                        break;
                    }
                }


            }
            if (piece == 'n') {
                if (touchedPiece % 8 == 0) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 10);
//                    if(stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 6);
//                    if(stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 7) {
//                    if(stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 10);
//                    if(stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 1) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
//                    if(stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
//                    if(stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 6);
                } else if (touchedPiece % 8 == 6) {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
//                    if(stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
//                    if(stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')validMoves.add(touchedPiece - 6);
                } else {
                    if (stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece] == "0" || stringBoard[touchedPiece + 17 <= 63 ? touchedPiece + 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 17);
                    if (stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece] == "0" || stringBoard[touchedPiece + 10 <= 63 ? touchedPiece + 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 10);
                    if (stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece] == "0" || stringBoard[touchedPiece + 15 <= 63 ? touchedPiece + 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 15);
                    if (stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece] == "0" || stringBoard[touchedPiece + 6 <= 63 ? touchedPiece + 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 6);
                    if (stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece] == "0" || stringBoard[touchedPiece - 17 >= 0 ? touchedPiece - 17 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 17);
                    if (stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece] == "0" || stringBoard[touchedPiece - 10 >= 0 ? touchedPiece - 10 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 10);
                    if (stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece] == "0" || stringBoard[touchedPiece - 15 >= 0 ? touchedPiece - 15 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 15);
                    if (stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece] == "0" || stringBoard[touchedPiece - 6 >= 0 ? touchedPiece - 6 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 6);
                }
            }
            if (piece == 'k') {
                if (touchedPiece % 8 == 0) {
                    if (Castle.isCanBlackCastleKingSide()) validMoves.add(touchedPiece + 2);
                    if (Castle.isCanBlackCastleQueenSide()) validMoves.add(touchedPiece - 2);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 7);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 7);
                } else if (touchedPiece % 8 == 7) {
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                } else {
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'w')
                        validMoves.add(touchedPiece - 7);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 7);
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                        validMoves.add(touchedPiece - 7);
                }

            }
        }
    }

    public void changeImageResource() {
        for (Integer validMove : validMoves) {
            ImageView imx = findViewById(Integer.parseInt(findViewById(position[validMove]).getContentDescription().toString()));
            imx.setImageResource(0);
        }

    }

    public int findMove(int id) {
        for (int i = 0; i < 64; i++) {
            if (id == position[i]) return i;
        }
        return 36;
    }
    public int findPiece(String str) {
        for(int i = 0; i < 64; i++) {
            if(stringBoard[i] == str)return i;
        }
        return -1;
    }

    public Set<Integer> legalMoves(Boolean isWhite) {
        Set<Integer> allValidMoves = new HashSet<>();

        Log.d("hi", "legalMoves: hello" + isWhite);

        if (isWhite) {
            for (int thisMove = 0; thisMove < 64; thisMove++) {
                String str = stringBoard[thisMove];
                if (str.charAt(0) == 'w') {
                    char piece = str.charAt(1);
                    Log.d("hello", "legalMoves: piece is" + piece);
                    if (piece == 'p') {
                        if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove].charAt(0) == 'b' || stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove] == "0");
                        allValidMoves.add(thisMove + 9);
                        if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove].charAt(0) == 'b' || stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove] == "0")
                            allValidMoves.add(thisMove + 7);
                    } else if (piece == 'b') {
                        for (int i = 1; i <= 8 && thisMove + i * 9 <= 63 && (thisMove + (i - 1) * 9) % 8 != 7; i++) {
                            if (stringBoard[thisMove + i * 9].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove + i * 9].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 7 <= 63 && (thisMove + (i - 1) * 7) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i * 7].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove + i * 7].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 7);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 9 >= 0 && (thisMove - (i - 1) * 9) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i * 9].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove - i * 9].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 7 >= 0 && (thisMove - (i - 1) * 7) % 8 != 7; i++) {
                            if (stringBoard[thisMove - i * 7].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove - i * 7].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 7);
                            }
                        }
                    } else if (piece == 'r') {
                        for (int i = 1; i <= 8 && (thisMove + i) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i] == "0") allValidMoves.add(thisMove + i);
                            else if (stringBoard[thisMove + i].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && (thisMove - i + 1) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i] == "0") allValidMoves.add(thisMove - i);
                            else if (stringBoard[thisMove - i].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 8 <= 63; i++) {
                            if (stringBoard[thisMove + i * 8] == "0")
                                allValidMoves.add(thisMove + i * 8);
                            else if (stringBoard[thisMove + i * 8].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i * 8);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 8 >= 0; i++) {
                            if (stringBoard[thisMove - i * 8] == "0")
                                allValidMoves.add(thisMove - i * 8);
                            else if (stringBoard[thisMove - i * 8].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i * 8);
                                break;
                            } else {
                                break;
                            }
                        }


                        Log.d("hello", "getValidMoves: rook" + allValidMoves);
                    }
                    if (piece == 'q') {
                        for (int i = 1; i <= 8 && thisMove + i * 9 <= 63 && (thisMove + (i - 1) * 9) % 8 != 7; i++) {
                            if (stringBoard[thisMove + i * 9].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove + i * 9].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 7 <= 63 && (thisMove + (i - 1) * 7) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i * 7].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove + i * 7].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 7);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 9 >= 0 && (thisMove - (i - 1) * 9) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i * 9].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove - i * 9].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 7 >= 0 && (thisMove - (i - 1) * 7) % 8 != 7; i++) {
                            if (stringBoard[thisMove - i * 7].charAt(0) == 'w') break;
                            else if (stringBoard[thisMove - i * 7].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 7);
                            }
                        }
                        for (int i = 1; i <= 8 && (thisMove + i) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i] == "0") allValidMoves.add(thisMove + i);
                            else if (stringBoard[thisMove + i].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && (thisMove - i + 1) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i] == "0") allValidMoves.add(thisMove - i);
                            else if (stringBoard[thisMove - i].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 8 <= 63; i++) {
                            if (stringBoard[thisMove + i * 8] == "0")
                                allValidMoves.add(thisMove + i * 8);
                            else if (stringBoard[thisMove + i * 8].charAt(0) == 'b') {
                                allValidMoves.add(thisMove + i * 8);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 8 >= 0; i++) {
                            if (stringBoard[thisMove - i * 8] == "0")
                                allValidMoves.add(thisMove - i * 8);
                            else if (stringBoard[thisMove - i * 8].charAt(0) == 'b') {
                                allValidMoves.add(thisMove - i * 8);
                                break;
                            } else {
                                break;
                            }
                        }
                        Log.d("hello", "legalMoves: legalmovesfind" + allValidMoves);


                    }
                    if (piece == 'n') {
                        if (thisMove % 8 == 0) {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 17);
                            if (stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 10);
//                    if(stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove + 15);
//                    if(stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove + 6);
//                    if(stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove - 17);
//                    if(stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 15);
                            if (stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 6);
                        } else if (thisMove % 8 == 7) {
//                    if(stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove + 17);
//                    if(stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 15);
                            if (stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 17);
                            if (stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 10);
//                    if(stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove - 15);
//                    if(stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove - 6);
                        } else if (thisMove % 8 == 1) {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 17);
                            if (stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 15);
//                    if(stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 17);
//                    if(stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 15);
                            if (stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 6);
                        } else if (thisMove % 8 == 6) {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 17);
//                    if(stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 15);
                            if (stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 17);
                            if (stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 15);
//                    if(stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'b')allValidMoves.add(thisMove - 6);
                        } else {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 17);
                            if (stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 15);
                            if (stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 17);
                            if (stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 15);
                            if (stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 6);
                        }
                    }
                    if (piece == 'k') {
                        if (thisMove % 8 == 0) {
                            if (Castle.isCanWhiteCastleKingSide()) allValidMoves.add(thisMove + 2);
                            if (Castle.isCanWhiteCastleQueenSide()) allValidMoves.add(thisMove - 2);
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 7);
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove] == "0")
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove] == "0")
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove] == "0")
                                allValidMoves.add(thisMove - 7);
                        } else if (thisMove % 8 == 7) {
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 7);
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove] == "0")
                                allValidMoves.add(thisMove - 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove] == "0")
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove] == "0")
                                allValidMoves.add(thisMove + 7);
                        } else {
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove + 7);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove].charAt(0) == 'b')
                                allValidMoves.add(thisMove - 7);
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove] == "0")
                                allValidMoves.add(thisMove - 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove] == "0")
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove] == "0")
                                allValidMoves.add(thisMove + 7);
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove] == "0")
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece] == "0")
                                allValidMoves.add(touchedPiece - 8);
                            if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece] == "0")
                                allValidMoves.add(touchedPiece + 9);
                            if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece] == "0")
                                allValidMoves.add(touchedPiece - 7);
                        }
                    }
                }


            }
        } else {
            Log.d("hello", "legalMoves: working");
            for (int thisMove = 0; thisMove < 64; thisMove++) {
                String str = stringBoard[thisMove];
                if (str.charAt(0) == 'b') {
                    char piece = str.charAt(1);
                    Log.d("hello", "legalMoves: piece is" + piece);
                    if (piece == 'p') {
                        Log.d("hello", "getValidMoves: first");
                        if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove].charAt(0) == 'w' || stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove] == "0");
                            allValidMoves.add(thisMove - 9);
                        if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove].charAt(0) == 'w' ||stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove] == "0")
                            allValidMoves.add(thisMove - 7);
                    } else if (piece == 'b') {
                        for (int i = 1; i <= 8 && thisMove + i * 9 <= 63 && (thisMove + (i - 1) * 9) % 8 != 7; i++) {
                            if (stringBoard[thisMove + i * 9].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove + i * 9].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 7 <= 63 && (thisMove + (i - 1) * 7) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i * 7].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove + i * 7].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 7);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 9 >= 0 && (thisMove - (i - 1) * 9) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i * 9].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove - i * 9].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 7 >= 0 && (thisMove - (i - 1) * 7) % 8 != 7; i++) {
                            if (stringBoard[thisMove - i * 7].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove - i * 7].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 7);
                            }
                        }
                    } else if (piece == 'r') {
                        for (int i = 1; i <= 8 && (thisMove + i) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i] == "0")
                                allValidMoves.add(thisMove + i);
                            else if (stringBoard[thisMove + i].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && (thisMove - i + 1) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i] == "0")
                                allValidMoves.add(thisMove - i);
                            else if (stringBoard[thisMove - i].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 8 <= 63; i++) {
                            if (stringBoard[thisMove + i * 8] == "0")
                                allValidMoves.add(thisMove + i * 8);
                            else if (stringBoard[thisMove + i * 8].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i * 8);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 8 >= 0; i++) {
                            if (stringBoard[thisMove - i * 8] == "0")
                                allValidMoves.add(thisMove - i * 8);
                            else if (stringBoard[thisMove - i * 8].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i * 8);
                                break;
                            } else {
                                break;
                            }
                        }


                        Log.d("hello", "getValidMoves: rook" + allValidMoves);
                    }
                    if (piece == 'q') {
                        for (int i = 1; i <= 8 && thisMove + i * 9 <= 63 && (thisMove + (i - 1) * 9) % 8 != 7; i++) {
                            if (stringBoard[thisMove + i * 9].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove + i * 9].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 7 <= 63 && (thisMove + (i - 1) * 7) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i * 7].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove + i * 7].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove + i * 7);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 9 >= 0 && (thisMove - (i - 1) * 9) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i * 9].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove - i * 9].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i * 9);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 9);
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 7 >= 0 && (thisMove - (i - 1) * 7) % 8 != 7; i++) {
                            if (stringBoard[thisMove - i * 7].charAt(0) == 'b') break;
                            else if (stringBoard[thisMove - i * 7].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i * 7);
                                break;
                            } else {
                                allValidMoves.add(thisMove - i * 7);
                            }
                        }
                        for (int i = 1; i <= 8 && (thisMove + i) % 8 != 0; i++) {
                            if (stringBoard[thisMove + i] == "0")
                                allValidMoves.add(thisMove + i);
                            else if (stringBoard[thisMove + i].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && (thisMove - i + 1) % 8 != 0; i++) {
                            if (stringBoard[thisMove - i] == "0")
                                allValidMoves.add(thisMove - i);
                            else if (stringBoard[thisMove - i].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove + i * 8 <= 63; i++) {
                            if (stringBoard[thisMove + i * 8] == "0")
                                allValidMoves.add(thisMove + i * 8);
                            else if (stringBoard[thisMove + i * 8].charAt(0) == 'w') {
                                allValidMoves.add(thisMove + i * 8);
                                break;
                            } else {
                                break;
                            }
                        }
                        for (int i = 1; i <= 8 && thisMove - i * 8 >= 0; i++) {
                            if (stringBoard[thisMove - i * 8] == "0")
                                allValidMoves.add(thisMove - i * 8);
                            else if (stringBoard[thisMove - i * 8].charAt(0) == 'w') {
                                allValidMoves.add(thisMove - i * 8);
                                break;
                            } else {
                                break;
                            }
                        }


                    }
                    if (piece == 'n') {
                        if (thisMove % 8 == 0) {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 17);
                            if (stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 10);
//                    if(stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove + 15);
//                    if(stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove + 6);
//                    if(stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove - 17);
//                    if(stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 15);
                            if (stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 6);
                        } else if (thisMove % 8 == 7) {
//                    if(stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove + 17);
//                    if(stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 15);
                            if (stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 17);
                            if (stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 10);
//                    if(stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove - 15);
//                    if(stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove - 6);
                        } else if (thisMove % 8 == 1) {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 17);
                            if (stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 15);
//                    if(stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 17);
//                    if(stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 15);
                            if (stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 6);
                        } else if (thisMove % 8 == 6) {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 17);
//                    if(stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 15);
                            if (stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 17);
                            if (stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 15);
//                    if(stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'w')allValidMoves.add(thisMove - 6);
                        } else {
                            if (stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove] == "0" || stringBoard[thisMove + 17 <= 63 ? thisMove + 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 17);
                            if (stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove] == "0" || stringBoard[thisMove + 10 <= 63 ? thisMove + 10 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 10);
                            if (stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove] == "0" || stringBoard[thisMove + 15 <= 63 ? thisMove + 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 15);
                            if (stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove] == "0" || stringBoard[thisMove + 6 <= 63 ? thisMove + 6 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 6);
                            if (stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove] == "0" || stringBoard[thisMove - 17 >= 0 ? thisMove - 17 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 17);
                            if (stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove] == "0" || stringBoard[thisMove - 10 >= 0 ? thisMove - 10 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 10);
                            if (stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove] == "0" || stringBoard[thisMove - 15 >= 0 ? thisMove - 15 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 15);
                            if (stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove] == "0" || stringBoard[thisMove - 6 >= 0 ? thisMove - 6 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 6);
                        }
                    }
                    if (piece == 'k') {
                        if (thisMove % 8 == 0) {
                            if (Castle.isCanBlackCastleKingSide())
                                allValidMoves.add(thisMove + 2);
                            if (Castle.isCanBlackCastleQueenSide())
                                allValidMoves.add(thisMove - 2);
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 7);
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove] == "0")
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove] == "0")
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove] == "0")
                                allValidMoves.add(thisMove - 7);
                        } else if (thisMove % 8 == 7) {
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 7);
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove] == "0")
                                allValidMoves.add(thisMove - 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove] == "0")
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove] == "0")
                                allValidMoves.add(thisMove + 7);
                        } else {
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove + 7);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove].charAt(0) == 'w')
                                allValidMoves.add(thisMove - 7);
                            if (stringBoard[thisMove - 1 >= 0 ? thisMove - 1 : thisMove] == "0")
                                allValidMoves.add(thisMove - 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove - 9 >= 0 ? thisMove - 9 : thisMove] == "0")
                                allValidMoves.add(thisMove - 9);
                            if (stringBoard[thisMove + 7 <= 63 ? thisMove + 7 : thisMove] == "0")
                                allValidMoves.add(thisMove + 7);
                            if (stringBoard[thisMove + 1 <= 63 ? thisMove + 1 : thisMove] == "0")
                                allValidMoves.add(thisMove + 1);
                            if (stringBoard[thisMove + 8 <= 63 ? thisMove + 8 : thisMove] == "0")
                                allValidMoves.add(thisMove + 8);
                            if (stringBoard[thisMove - 8 >= 0 ? thisMove - 8 : thisMove] == "0")
                                allValidMoves.add(thisMove - 8);
                            if (stringBoard[thisMove + 9 <= 63 ? thisMove + 9 : thisMove] == "0")
                                allValidMoves.add(thisMove + 9);
                            if (stringBoard[thisMove - 7 >= 0 ? thisMove - 7 : thisMove] == "0")
                                allValidMoves.add(thisMove - 7);
                        }

                    }
                }
            }



        }
        Log.d("hello", "legalMoves: allvalidmoves" + allValidMoves);
        return allValidMoves;
    }
    public void  askOptions(boolean display, final ImageView imageView, final Integer move) {
//        ImageView queen = findViewById(R.id.queen);
//        ImageView rook = findViewById(R.id.rook);
//        ImageView bishop = findViewById(R.id.bishop);
//        ImageView knight = findViewById(R.id.knight);
//        ConstraintLayout x = (ConstraintLayout) findViewById(R.id.makeChoice);
//
//        if(display) {
//            queen.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    stringBoard[touchedPiece] = currentPlayer == "white" ? "wq" : "bq";
//                    val = currentPlayer == "white" ? R.drawable.wq : R.drawable.bq;
//                    askOptions(false, imageView, move);
//                }
//            });
//            rook.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    stringBoard[touchedPiece] = currentPlayer == "white" ? "wr" : "br";
//
//                    val = currentPlayer == "white" ? R.drawable.wr : R.drawable.br;
//                    askOptions(false, imageView, move);
//
//                }
//            });
//            bishop.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    stringBoard[touchedPiece] = currentPlayer == "white" ? "wb" : "bb";
//
//                    val = currentPlayer == "white" ? R.drawable.wb : R.drawable.bb;
//                    askOptions(false, imageView, move);
//
//                }
//            });
//            knight.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    stringBoard[touchedPiece] = currentPlayer == "white" ? "wn" : "bn";
//
//                    val = currentPlayer == "white" ? R.drawable.wn : R.drawable.bn;
//                    askOptions(false, imageView, move);
//
//                }
//            });
//            if (currentPlayer == "white") {
//                queen.setImageResource(R.drawable.wq);
//                rook.setImageResource(R.drawable.wr);
//                bishop.setImageResource(R.drawable.wb);
//                knight.setImageResource(R.drawable.wn);
//            } else {
//                queen.setImageResource(R.drawable.wq);
//                rook.setImageResource(R.drawable.wr);
//                bishop.setImageResource(R.drawable.wb);
//                knight.setImageResource(R.drawable.wn);
//            }
//            x.setBackgroundColor(Color.WHITE);
//            x.setTag(1);
//            currentPlayer = switchPlayer();
//
//
//
//        }
//        else {
//
//
//
//            imageView.setImageResource(val);
//            stringBoard[move] = checkTag(val);
//            stringBoard[touchedPiece] = "0";
//            imageView.setTag(val);
//            val = 0;
//            prevView.setImageResource(0);
//            prevView.setTag(0);
//            Set<Integer>legal;
//            legal = legalMoves(true);
//            if(legal.contains(findPiece("bk"))) {
//                ImageView bk = findViewById(position[(findPiece("bk"))]);
//                bk.setBackgroundColor(Color.RED);
//            }
//            else {
//                ImageView bk = findViewById(position[(findPiece("bk"))]);
//                bk.setBackgroundColor(0);
//            }
//            legal = legalMoves(false);
//            if(legal.contains(findPiece("wk"))) {
//                ImageView bk = findViewById(position[(findPiece("wk"))]);
//                bk.setBackgroundColor(Color.RED);
//            }
//            else {
//                ImageView bk = findViewById(position[(findPiece("wk"))]);
//                bk.setBackgroundColor(0);
//            }
//            //set the image resource to null again to change the checkstatus
//            ImageView bk = findViewById(Integer.parseInt(prevView.getContentDescription().toString()));
//            bk.setBackgroundColor(0);
//
//
//
//
//
//
//
//
//
//
//
//
//            queen.setImageResource(0);
//            rook.setImageResource(0);
//            bishop.setImageResource(0);
//            knight.setImageResource(0);
//            x.setBackgroundColor(0);
//            queen.setOnClickListener(null);
//            rook.setOnClickListener(null);
//            bishop.setOnClickListener(null);
//            knight.setOnClickListener(null);
//            x.setTag(0);
//            currentPlayer = switchPlayer();
//        }
        val = currentPlayer == "white" ? R.drawable.wq : R.drawable.bq;
    }
    public void change() {
        return;
    }
    public void checkIfCheckMate() {
        Set<Integer> legal = legalMoves(currentPlayer == "white");

        for(int i = 0; i < 64; i++) {
            if(stringBoard[i].charAt(0) == currentPlayer.charAt(0)) {
                getValidMoves((ImageView)(findViewById(position[i])), Integer.parseInt(((ImageView)(findViewById(position[i]))).getTag().toString()), i);
                for(int move : validMoves) {
                    String temp = stringBoard[move];
                    stringBoard[move] = stringBoard[i];
                    stringBoard[i] = "0";
                    legal = legalMoves(currentPlayer == "black");
                    int k = findPiece(currentPlayer == "white" ? "wk" : "bk");
                    stringBoard[i] = stringBoard[move];
                    stringBoard[move] = temp;

                    if(!legal.contains(k)){return;}

                }
            }
        }
        TextView checkMate = findViewById(R.id.checkMate);
        checkMate.setText("CheckMate! " + currentPlayer + " Lost");
        checkMate.setVisibility(checkMate.VISIBLE);
    }
    public void setBoardAccordingTostringBoard() {

        for(int i = 0; i < 64; i++) {
            Log.d("hello", "setBoardAccordingTostringBoard: stringboardx" + stringBoard[i]);
            ImageView img = (ImageView)findViewById(position[i]);
            Log.d("hello", "setBoardAccordingTostringBoard: helloworld" + img);
            ImageView img1 = (ImageView)findViewById(Integer.parseInt(img.getContentDescription().toString()));
            int imageResource = getTag(stringBoard[i]);
            img.setImageResource(imageResource);
            img.setTag(imageResource);
            img1.setTag(0);

            img1.setImageResource(0);
        }
        return;


    }
    public int getTag(String str) {
        if (str == "wp") return R.drawable.wp;
        else if (str == "bp") return R.drawable.bp;
        else if (str == "wr") return R.drawable.wr;
        else if (str == "br") return R.drawable.br;
        else if (str == "wb") return R.drawable.wb;
        else if (str == "bb") return R.drawable.bb;
        else if (str == "wn") return R.drawable.wn;
        else if (str == "bn") return R.drawable.bn;
        else if (str == "wq") return R.drawable.wq;
        else if (str == "bq") return R.drawable.bq;
        else if (str == "wk") return R.drawable.wk;
        else if (str == "bk") return R.drawable.bk;
        else return 0;

    }
    public void undo(View view) {
        if(index == 0)return;
        index = index - 2 >= 0 ? index - 2 : 0;
        for(int i = 0; i < 64; i++)
            stringBoard[i] = Game[index][i];

        index++;
        val = 0;
        touchedPiece = 0;
        setBoardAccordingTostringBoard();
        currentPlayer = switchPlayer();
        return;
    }
}