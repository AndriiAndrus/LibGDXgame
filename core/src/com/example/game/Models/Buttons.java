package com.example.game.Models;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Buttons {

    private static Texture MedalIcon = new Texture("icons/MedalWhite.png");
    private static Rectangle MedalRect = new Rectangle().set(250, 230, 64, 64);

    private static Texture PauseIcon = new Texture("icons/Pause.png");
    private static Rectangle PauseRect = new Rectangle().set(720, 400, 128, 128);

    private static Texture StartBtn = new Texture("icons/Play1.png");
    private static Rectangle StartBtnRect = new Rectangle().set(350, 200, 128, 128);

    private static Rectangle ReplayBtnRect = new Rectangle().set(420, 100, 64, 64);
    private static Texture ReplayBtn = new Texture("icons/ReplayWhite.png");

    private static Rectangle MenuBtnRect = new Rectangle().set(300, 100, 64, 64);
    private static Texture MenuBtn = new Texture("icons/MenuWhite.png");

    private static Texture PlayMenuTexture = new Texture("icons/Play2w.png");
    private static Rectangle PlayMenuRect = new Rectangle().set(150, 180, 128, 128);

    private static Texture SoundOnTexture = new Texture("icons/AudioOnWhite.png");
    private static Rectangle SoundOnRect = new Rectangle().set(700, 400, 64, 64);

    private static Texture SoundOffTexture = new Texture("icons/AudioOffWhite.png");
    private static Rectangle SounfOffRect = new Rectangle().set(700, 400, 64, 64);

    private static Texture LeaderTexture = new Texture("icons/LeaderWhite.png");
    private static Rectangle LeaderRect = new Rectangle().set(150, 50, 64, 64);

    private static Texture LevelerTexture = new Texture("icons/Leveler.png");
    private static Rectangle LevelerRect = new Rectangle().set(350, 200, 180, 80);

    private static Texture ExitTexture = new Texture("icons/ExitWhite.png");
    private static Rectangle ExitRect = new Rectangle().set(700, 50, 64, 64);

    public static Texture getPlayMenuTexture() {
        return PlayMenuTexture;
    }

    public static Rectangle getPlayMenuRect() {
        return PlayMenuRect;
    }

    public static Texture getSoundOnTexture() {
        return SoundOnTexture;
    }

    public static Rectangle getSoundOnRect() {
        return SoundOnRect;
    }

    public static Texture getSoundOffTexture() {
        return SoundOffTexture;
    }

    public static Rectangle getSounfOffRect() {
        return SounfOffRect;
    }

    public static Texture getLeaderTexture() {
        return LeaderTexture;
    }

    public static Rectangle getLeaderRect() {
        return LeaderRect;
    }

    public static Texture getMedalIcon() {
        return MedalIcon;
    }

    public static Rectangle getMedalRect() {
        return MedalRect;
    }

    public static Texture getPauseIcon() {
        return PauseIcon;
    }

    public static Rectangle getPauseRect() {
        return PauseRect;
    }

    public static Texture getStartBtn() {
        return StartBtn;
    }

    public static Rectangle getStartBtnRect() {
        return StartBtnRect;
    }
    public static Rectangle getReplayBtnRect() {
        return ReplayBtnRect;
    }

    public static Rectangle getMenuBtnRect() {
        return MenuBtnRect;
    }

    public static Texture getReplayBtn() {
        return ReplayBtn;
    }

    public static Texture getMenuBtn() {
        return MenuBtn;
    }

    public static Texture getLevelerTexture() {
        return LevelerTexture;
    }

    public static Rectangle getLevelerRect() {
        return LevelerRect;
    }

    public static Texture getExitTexture() {
        return ExitTexture;
    }

    public static Rectangle getExitRect() {
        return ExitRect;
    }
}
