package com.example.chess;

import android.widget.ImageView;

public class Castle {
    private static  boolean canWhiteCastleKingSide = true;
    private  static boolean canWhiteCastleQueenSide = true;
    private static boolean canBlackCastleKingSide = true;
    private static boolean canBlackCastleQueenSide = true;

    public static boolean isCanWhiteCastleKingSide() {
        return canWhiteCastleKingSide;
    }



    public void setCanWhiteCastleKingSide(boolean canWhiteCastleKingSide) {
        this.canWhiteCastleKingSide = canWhiteCastleKingSide;
    }

    public static boolean isCanWhiteCastleQueenSide() {
        return canWhiteCastleQueenSide;
    }

    public void setCanWhiteCastleQueenSide(boolean canWhiteCastleQueenSide) {
        this.canWhiteCastleQueenSide = canWhiteCastleQueenSide;
    }

    public static boolean isCanBlackCastleKingSide() {
        return canBlackCastleKingSide;
    }

    public void setCanBlackCastleKingSide(boolean canBlackCastleKingSide) {
        this.canBlackCastleKingSide = canBlackCastleKingSide;
    }

    public static boolean isCanBlackCastleQueenSide() {
        return canBlackCastleQueenSide;
    }

    public void setCanBlackCastleQueenSide(boolean canBlackCastleQueenSide) {
        this.canBlackCastleQueenSide = canBlackCastleQueenSide;
    }
}
