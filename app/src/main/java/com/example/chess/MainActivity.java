package com.example.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public int touchedPiece;// value of the position in stringBoard
    Set<Integer> validMoves;
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
        ImageView img = findViewById(R.id.a1);
        img.setTag(R.drawable.wr);
        img.setContentDescription("1");


        img = findViewById(R.id.b1);
        img.setContentDescription("2");
        img.setTag(R.drawable.wn);

        img = findViewById(R.id.c1);
        img.setContentDescription("3");

        img.setTag(R.drawable.wb);
        img = findViewById(R.id.d1);
        img.setContentDescription("4");
        img.setTag(R.drawable.wq);
        img = findViewById(R.id.e1);
        img.setContentDescription("5");
        img.setTag(R.drawable.wk);
        img = findViewById(R.id.f1);
        img.setContentDescription("6");
        img.setTag(R.drawable.wb);
        img = findViewById(R.id.g1);
        img.setContentDescription("7");
        img.setTag(R.drawable.wn);
        img = findViewById(R.id.h1);
        img.setContentDescription("8");
        img.setTag(R.drawable.wr);
        img = findViewById(R.id.a2);
        img.setContentDescription("9");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.b2);
        img.setContentDescription("10");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.c2);
        img.setContentDescription("11");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.d2);
        img.setContentDescription("12");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.e2);
        img.setContentDescription("13");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.f2);
        img.setContentDescription("14");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.g2);
        img.setContentDescription("15");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.h2);
        img.setContentDescription("16");
        img.setTag(R.drawable.wp);
        img = findViewById(R.id.a8);
        img.setContentDescription("57");
        img.setTag(R.drawable.br);
        img = findViewById(R.id.b8);
        img.setContentDescription("58");
        img.setTag(R.drawable.bn);
        img = findViewById(R.id.c8);
        img.setContentDescription("59");
        img.setTag(R.drawable.bb);
        img = findViewById(R.id.d8);
        img.setContentDescription("60");
        img.setTag(R.drawable.bq);
        img = findViewById(R.id.e8);
        img.setContentDescription("61");
        img.setTag(R.drawable.bk);
        img = findViewById(R.id.f8);
        img.setContentDescription("62");
        img.setTag(R.drawable.bb);
        img = findViewById(R.id.g8);
        img.setContentDescription("63");
        img.setTag(R.drawable.bn);
        img = findViewById(R.id.h8);
        img.setContentDescription("64");
        img.setTag(R.drawable.br);
        img = findViewById(R.id.a7);
        img.setContentDescription("49");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.b7);
        img.setContentDescription("50");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.c7);
        img.setContentDescription("51");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.d7);
        img.setContentDescription("52");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.e7);
        img.setContentDescription("53");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.f7);
        img.setContentDescription("54");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.g7);
        img.setContentDescription("55");
        img.setTag(R.drawable.bp);
        img = findViewById(R.id.h7);
        img.setContentDescription("56");
        img.setTag(R.drawable.bp);

        img = findViewById(R.id.a5);
        img.setContentDescription("33");
        img.setTag(0);
        img = findViewById(R.id.b5);
        img.setContentDescription("34");
        img.setTag(0);
        img = findViewById(R.id.c5);
        img.setContentDescription("35");
        img.setTag(0);
        img = findViewById(R.id.d5);
        img.setContentDescription("36");
        img.setTag(0);
        img = findViewById(R.id.e5);
        img.setContentDescription("37");
        img.setTag(0);
        img = findViewById(R.id.f5);
        img.setContentDescription("38");
        img.setTag(0);
        img = findViewById(R.id.g5);
        img.setContentDescription("39");
        img.setTag(0);
        img = findViewById(R.id.h5);
        img.setContentDescription("40");
        img.setTag(0);
        img = findViewById(R.id.a4);
        img.setContentDescription("25");
        img.setTag(0);
        img = findViewById(R.id.b4);
        img.setContentDescription("26");
        img.setTag(0);
        img = findViewById(R.id.c4);
        img.setContentDescription("27");
        img.setTag(0);
        img = findViewById(R.id.d4);
        img.setContentDescription("28");
        img.setTag(0);
        img = findViewById(R.id.e4);
        img.setContentDescription("29");
        img.setTag(0);
        img = findViewById(R.id.f4);
        img.setContentDescription("30");
        img.setTag(0);
        img = findViewById(R.id.g4);
        img.setContentDescription("31");
        img.setTag(0);
        img = findViewById(R.id.h4);
        img.setContentDescription("32");
        img.setTag(0);


        img = findViewById(R.id.a3);
        img.setContentDescription("17");
        img.setTag(0);
        img = findViewById(R.id.b3);
        img.setContentDescription("18");
        img.setTag(0);
        img = findViewById(R.id.c3);
        img.setContentDescription("19");
        img.setTag(0);
        img = findViewById(R.id.d3);
        img.setContentDescription("20");
        img.setTag(0);
        img = findViewById(R.id.e3);
        img.setContentDescription("21");
        img.setTag(0);
        img = findViewById(R.id.f3);
        img.setContentDescription("22");
        img.setTag(0);
        img = findViewById(R.id.g3);
        img.setContentDescription("23");
        img.setTag(0);
        img = findViewById(R.id.h3);
        img.setContentDescription("24");
        img.setTag(0);
        img = findViewById(R.id.a6);
        img.setContentDescription("41");
        img.setTag(0);
        img = findViewById(R.id.b6);
        img.setContentDescription("42");
        img.setTag(0);
        img = findViewById(R.id.c6);
        img.setContentDescription("43");
        img.setTag(0);
        img = findViewById(R.id.d6);
        img.setContentDescription("44");
        img.setTag(0);
        img = findViewById(R.id.e6);
        img.setContentDescription("45");
        img.setTag(0);
        img = findViewById(R.id.f6);
        img.setContentDescription("46");
        img.setTag(0);
        img = findViewById(R.id.g6);
        img.setContentDescription("47");
        img.setTag(0);
        img = findViewById(R.id.h6);
        img.setContentDescription("48");
        img.setTag(0);






    }
    public void click(View view) {
        ImageView imageView = (ImageView)view;



        if (val != 0) {
            changeImageResource();
            Log.d("hello", "click: " + validMoves);
            int move = findMove(imageView.getId());
            if(validMoves.contains(move)) {
                imageView.setImageResource(val);
                stringBoard[move] = checkTag(val);
                stringBoard[touchedPiece] = "0";
                imageView.setTag(val);
                val = 0;
                prevView.setImageResource(0);
                prevView.setTag(0);
                currentPlayer = switchPlayer();
            }
            else val = 0;



        } else {
            if(validatePlayer(imageView)) {
                val = (int) imageView.getTag();
                prevView = imageView;
                prevView.setBackgroundColor(0);
                touchedPiece = Integer.parseInt(imageView.getContentDescription().toString()) - 1;
                Log.d("hello", "click: color" + touchedPiece);
                getValidMoves(imageView);
                for(Integer validMove : validMoves) {
                    ImageView imx = findViewById(position[validMove]);
                    imx.setImageResource(R.drawable.legal);
                }


            }

        }
        Log.d("hello", "click: this is " + val);


    }
    //Return the string of which piece is occupying the square for eg. wp->white pawn
    public String checkTag(int val) {
        if(val == R.drawable.wp)return "wp";
        else if(val == R.drawable.bp)return "bp";
        else if(val == R.drawable.wr)return "wr";
        else if(val == R.drawable.br)return "br";
        else if(val == R.drawable.wb)return "wb";
        else if(val == R.drawable.bb)return "bb";
        else if(val == R.drawable.wn)return "wn";
        else if(val == R.drawable.bn)return "bn";
        else if(val == R.drawable.wq)return "wq";
        else if(val == R.drawable.bq)return "bq";
        else if(val == R.drawable.wk)return "wk";
        else if(val == R.drawable.bk)return "bk";
        else return "0";
    }
    //Check if the correct player is playing
    public boolean validatePlayer(final ImageView imageView) {
        String tag = checkTag((int)imageView.getTag());
        if(tag.charAt(0) == currentPlayer.charAt(0)) {
            imageView.setBackgroundColor(Color.GRAY);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {changeColor(imageView);
                }
            }, 500);   //0.5 seconds
            return true;
        }
        else {
            imageView.setBackgroundColor(Color.RED);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {changeColor(imageView);
                }
            }, 500);   //0.5 seconds

            return false;


        }
    }
    //Return the switched player
    public String switchPlayer() {
        if(currentPlayer == "white")return "black";
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
        char piece = checkTag(val).charAt(1);
        Log.d("hello", "getValidMoves: " + piece);
        if (currentPlayer == "white") {
            if (piece == 'p') {
                Log.d("hello", "getValidMoves: first");
                if (touchedPiece <= 16 && touchedPiece >= 9) {
                    if (stringBoard[touchedPiece + 16] == "0") validMoves.add(touchedPiece + 16);
                    Log.d("hello", "getValidMoves: validMoves" + validMoves);
                }
                if (stringBoard[touchedPiece + 8] == "0") validMoves.add(touchedPiece + 8);
                if (stringBoard[touchedPiece + 9].charAt(0) == 'b')
                    validMoves.add(touchedPiece + 9);
                if (stringBoard[touchedPiece + 7].charAt(0) == 'b')
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
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'b') {
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
                    else if (stringBoard[touchedPiece + i * 8].charAt(0) == 'b') {
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
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece + 9 <= 63 ? touchedPiece + 9 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 9);
                    if (stringBoard[touchedPiece - 7 >= 0 ? touchedPiece - 7 : touchedPiece].charAt(0) == 'b')
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
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece + 8 <= 63 ? touchedPiece + 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 8);
                    if (stringBoard[touchedPiece - 8 >= 0 ? touchedPiece - 8 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 8);
                    if (stringBoard[touchedPiece - 9 >= 0 ? touchedPiece - 9 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece - 9);
                    if (stringBoard[touchedPiece + 7 <= 63 ? touchedPiece + 7 : touchedPiece].charAt(0) == 'b')
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
                    if (stringBoard[touchedPiece + 1 <= 63 ? touchedPiece + 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 1);
                    if (stringBoard[touchedPiece - 1 >= 0 ? touchedPiece - 1 : touchedPiece].charAt(0) == 'b')
                        validMoves.add(touchedPiece + 1);
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
            }


        } else {
            if (piece == 'p') {
                Log.d("hello", "getValidMoves: first");
                if (touchedPiece <= 56 && touchedPiece >= 49) {
                    if (stringBoard[touchedPiece - 16] == "0") validMoves.add(touchedPiece - 16);
                    Log.d("hello", "getValidMoves: validMoves" + validMoves);
                }
                if (stringBoard[touchedPiece - 8] == "0") validMoves.add(touchedPiece - 8);
                if (stringBoard[touchedPiece - 9].charAt(0) == 'w')
                    validMoves.add(touchedPiece - 9);
                if (stringBoard[touchedPiece - 7].charAt(0) == 'w')
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
                        validMoves.add(touchedPiece + 1);
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
        for(Integer validMove : validMoves) {
            ImageView imx = findViewById(position[validMove]);
            imx.setImageResource((int)imx.getTag());
        }
    }

    public int findMove(int id) {
        for(int i = 0; i < 64; i++) {
            if(id == position[i])return i;
        }
        return 0;
    }
}