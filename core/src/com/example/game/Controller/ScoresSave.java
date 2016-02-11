package com.example.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoresSave {

   private static Preferences prefs = Gdx.app.getPreferences("MyPreferences");

    private static long LastTopScores = prefs.getLong("scores", 0);

    public static boolean CheckScores(long scores){
        boolean toSend = false;
     LastTopScores = prefs.getLong("scores", 0);
        if(LastTopScores < scores){
            prefs.putLong("scores", scores);
            prefs.flush();
            toSend = true;
        }
        return toSend;
    }

    public static long getLastTopScores() {
        return LastTopScores;
    }

}

