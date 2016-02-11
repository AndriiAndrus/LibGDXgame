package com.example.game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;

public class GameObjects {

    private static Texture BgGame = new Texture("img/GameBg1.png");
    private static Music BgMusic = Gdx.audio.newMusic(Gdx.files.internal("BgMusic.mp3"));
    private static Rectangle BgRect = new Rectangle().set(0, 0, 800, 480);

    private static BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/CoolFont.fnt"),
            Gdx.files.internal("fonts/CoolFont.png"), false);
    private static BitmapFont PausedFont = new BitmapFont(Gdx.files.internal("fonts/CoolFont.fnt"),
            Gdx.files.internal("fonts/CoolFont.png"), false);

    private static Texture EnemyOne = new Texture("img/blue0.png");
    private static Texture EnemyTwo = new Texture("img/green1.png");
    private static Texture PlayerTexture = new Texture("img/player.png");
    private static Texture EnemyThree = new Texture("img/greenyellow2.png");
    private static Texture EnemyFour = new Texture("img/opponent3.png");
    private static Texture PauseBg = new Texture("img/PausedBg.png");
    private static Rectangle PauseBgRect = new Rectangle().set(0, 0, 800, 480);

    public static Texture getBgGame() {
        return BgGame;
    }

    public static Music getBgMusic() {
        return BgMusic;
    }

    public static Rectangle getBgRect() {
        return BgRect;
    }

    public static BitmapFont getFont() {
        font.setColor(Color.valueOf("006666"));
        return font;
    }

    public static BitmapFont getPausedFont() {
        return PausedFont;
    }

    public static Texture getEnemyOne() {
        return EnemyOne;
    }

    public static Texture getEnemyTwo() {
        return EnemyTwo;
    }

    public static Texture getPlayerTexture() {
        return PlayerTexture;
    }

    public static Texture getEnemyThree() {
        return EnemyThree;
    }

    public static Texture getEnemyFour() {
        return EnemyFour;
    }

    public static Texture getPauseBg() {
        return PauseBg;
    }

    public static Rectangle getPauseBgRect() {
        return PauseBgRect;
    }
}
