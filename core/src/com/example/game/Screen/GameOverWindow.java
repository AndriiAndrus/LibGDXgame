package com.example.game.Screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.example.game.GameLogic.GameState;

public class GameOverWindow {

    private static Texture BgGameOver = new Texture("img/PausedBg.png");
    private static Rectangle GORect = new Rectangle().set(0, 0, 800, 480);
    private static CharSequence GameOverStr = "GAME OVER!";

    public static Texture getBgGameOver() {
        return BgGameOver;
    }

    public static Rectangle getGORect() {
        return GORect;
    }

    public static CharSequence getGameOverStr() {
        return GameOverStr;
    }
}
