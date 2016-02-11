package com.example.game.GameLogic;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.example.game.Controller.ScoresSave;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameState {

    public static final int GAME_READY = 0;
    public static final int GAME_RUNNING = 1;
    public static final int GAME_PAUSED = 2;
    public static final int GAME_OVER = 3;
    public static final int GAME_MENU = 4;

    public static int SOUND = 0;

    public static Date PAUSE_BEGAN;
    public static Date PAUSE_END;
    public static long WAS_INPAUSE;
    public static long WAS_INPAUSE_TOTAL;

    public static Date START_GAME_TIME;
    public static Date GAME_TIME;
    private static long TIME_INGAME;
    private static CharSequence TIME_IN_GAME = "test";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss:SSS");
    private static CharSequence PauseStr = "GAME PAUSED";

    private static int state = 4;

    public static void SetGameState(int num){
        state = num;
    }

    public static void RunGameTime(){
      START_GAME_TIME = new Date();
    }

    public static void ReleaseData(){
        PAUSE_BEGAN = null;
        PAUSE_END = null;
        WAS_INPAUSE = 0;
        WAS_INPAUSE_TOTAL = 0;
    }

    public static void NewGameTime(){
        try {
            if (WAS_INPAUSE != (PAUSE_END.getTime() - PAUSE_BEGAN.getTime())) {
                WAS_INPAUSE = (PAUSE_END.getTime() - PAUSE_BEGAN.getTime());
                WAS_INPAUSE_TOTAL += WAS_INPAUSE;
            }
        } catch(Exception ex){ /* LATER */}

        GAME_TIME = new Date();
        TIME_INGAME = (GAME_TIME.getTime() - START_GAME_TIME.getTime()) - WAS_INPAUSE_TOTAL;
        TIME_IN_GAME = "" + dateFormat.format(TIME_INGAME);
        IncreaseSpeedWithTime();
    }

    private static void IncreaseSpeedWithTime(){
        if(TIME_INGAME > (GameLevels.TIME_COUNT*1000*(30-(GameLevels.DIFFICULTY-1)*3))){
           if(GameLevels.TIME_COUNT < 10){
               GameLevels.TIME_COUNT++;
               GameLevels.OPPONENT_SPEED += (GameLevels.TIME_COUNT * 10);
               GameLevels.PLAYER_SPEED += (GameLevels.TIME_COUNT * 10);
           }
        }
    }

    public static CharSequence getPauseStr() {
        return PauseStr;
    }

    public static CharSequence getTimeInGame() {
        if(ScoresSave.CheckScores(TIME_INGAME)){
            TIME_IN_GAME = "New Best! \n" + dateFormat.format(TIME_INGAME);
        }
        return TIME_IN_GAME;
    }

    public static CharSequence getBestTime(){
        CharSequence toReturn = "...";
        try {
            toReturn = dateFormat.format(ScoresSave.getLastTopScores());
        } catch(Exception ex){ /* NOTHING */ }
       return toReturn;
    }

    public static int getState() {
        return state;
    }
}
