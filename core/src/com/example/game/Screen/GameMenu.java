package com.example.game.Screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GameMenu {

    private static Texture BgGameOver = new Texture("img/PausedBg.png");
    private static Rectangle GORect = new Rectangle().set(0, 0, 800, 480);

    public static Texture getBgGameOver() {
        return BgGameOver;
    }

    public static Rectangle getGORect() {
        return GORect;
    }
}
