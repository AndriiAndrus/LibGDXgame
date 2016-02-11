package com.example.game.GameLogic;

public class GameLevels {

    public static int PLAYER_SPEED = 40;
    public static int OPPONENT_SPEED = 20;

    public static CharSequence TextLvl = "1";

    public static int DIFFICULTY = 1;
    public static int MAX_DIFF = 10;

    public static int TIME_COUNT = 1;

    public static void ONNewGame(){
        PLAYER_SPEED = 40;
        OPPONENT_SPEED = 20;
    }
}
