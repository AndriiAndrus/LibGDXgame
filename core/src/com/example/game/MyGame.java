package com.example.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.example.game.GameLogic.GameLevels;
import com.example.game.GameLogic.GameState;
import com.example.game.Models.Buttons;
import com.example.game.Models.GameObjects;
import com.example.game.Screen.GameMenu;
import com.example.game.Screen.GameOverWindow;
import com.example.game.GameLogic.Opponent;
import com.example.game.GameLogic.PlayerControler;

import java.util.Date;

public class MyGame implements ApplicationListener {

    private static SpriteBatch batch;
    private static OrthographicCamera camera;
    private static Opponent oppOne;
    private static Opponent oppTwo;
    private static Opponent oppThree;
    private static Opponent oppFour;
    private static PlayerControler Player;

    @Override
    public void create() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Gdx.input.setInputProcessor(new OnTouchListener());
        SetNewGame();
        GameObjects.getBgMusic().setLooping(true);
      //  BgMusic.play();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        StartDrawCall();
        SwitchGameModes();
        batch.end();
    }

    private void SwitchGameModes() {
        switch(GameState.getState()) {
            case GameState.GAME_READY:
                // GAME_READY
                SetNewGame();
                GameState.RunGameTime();
                GameState.SetGameState(1);
                break;
            case GameState.GAME_RUNNING:
               // GAME_RUNNING
                GameState.NewGameTime();
                MakeMoves();
                GameObjects.getFont().draw(batch, GameState.getTimeInGame(), 510, 455);
                batch.draw(Buttons.getPauseIcon(), Buttons.getPauseRect().x, Buttons.getPauseRect().y);
                break;
            case GameState.GAME_PAUSED:
               // GAME_PAUSED
                batch.draw(GameObjects.getPauseBg(), GameObjects.getPauseBgRect().x, GameObjects.getPauseBgRect().y);
                batch.draw(Buttons.getStartBtn(), Buttons.getStartBtnRect().x, Buttons.getStartBtnRect().y);
                GameObjects.getPausedFont().draw(batch, GameState.getPauseStr(), 305, 170);
                break;
            case GameState.GAME_OVER:
                // GAME_OVER
                OnGameOver();
                break;
            case GameState.GAME_MENU:
                // GAME_MENU
                OnGameMenu();
                break;
        }
    }

    private void OnGameMenu() {
        batch.draw(GameMenu.getBgGameOver(), GameMenu.getGORect().x, GameMenu.getGORect().y);
        batch.draw(Buttons.getPlayMenuTexture(), Buttons.getPlayMenuRect().x, Buttons.getPlayMenuRect().y);
        if(GameState.SOUND == 0) {
            batch.draw(Buttons.getSoundOnTexture(), Buttons.getSoundOnRect().x, Buttons.getSoundOnRect().y);
        } else {
            batch.draw(Buttons.getSoundOffTexture(), Buttons.getSounfOffRect().x, Buttons.getSounfOffRect().y);
        }
        batch.draw(Buttons.getLeaderTexture(), Buttons.getLeaderRect().x, Buttons.getLeaderRect().y);
        batch.draw(Buttons.getLevelerTexture(), Buttons.getLevelerRect().x, Buttons.getLevelerRect().y);
        batch.draw(Buttons.getExitTexture(), Buttons.getExitRect().x, Buttons.getExitRect().y);
        GameObjects.getPausedFont().draw(batch, GameLevels.TextLvl, 400, 260);
        GameObjects.getPausedFont().draw(batch, GameState.getBestTime(), 230, 100);
    }

    private void OnGameOver() {
        batch.draw(GameOverWindow.getBgGameOver(), GameOverWindow.getGORect().x, GameOverWindow.getGORect().y);
        batch.draw(Buttons.getReplayBtn(), Buttons.getReplayBtnRect().x, Buttons.getReplayBtnRect().y);
        batch.draw(Buttons.getMenuBtn(), Buttons.getMenuBtnRect().x, Buttons.getMenuBtnRect().y);
        batch.draw(Buttons.getMedalIcon(), Buttons.getMedalRect().x, Buttons.getMedalRect().y);
        GameObjects.getPausedFont().draw(batch, GameOverWindow.getGameOverStr(), 310, 450);
        GameObjects.getPausedFont().draw(batch, GameState.getTimeInGame(), 330, 300);
    }

    private void MakeMoves() {
        Player.MovePlayer();
        Player.getPolygon().setPosition(Player.getPlayerRect().x, Player.getPlayerRect().y);
        oppOne.Move();
        oppOne.getPolygon().setPosition(oppOne.GetOppRect().x, oppOne.GetOppRect().y);
        oppTwo.Move();
        oppTwo.getPolygon().setPosition(oppTwo.GetOppRect().x, oppTwo.GetOppRect().y);
        oppThree.Move();
        oppThree.getPolygon().setPosition(oppThree.GetOppRect().x, oppThree.GetOppRect().y);
        oppFour.Move();
        oppFour.getPolygon().setPosition(oppFour.GetOppRect().x, oppFour.GetOppRect().y);
    }

    private void StartDrawCall() {
        batch.draw(GameObjects.getBgGame(), GameObjects.getBgRect().x, GameObjects.getBgRect().y);
        batch.draw(GameObjects.getPlayerTexture(), Player.getPlayerRect().x, Player.getPlayerRect().y);
        batch.draw(oppOne.getOppTexture(), oppOne.GetOppRect().x, oppOne.GetOppRect().y);
        batch.draw(oppTwo.getOppTexture(), oppTwo.GetOppRect().x, oppTwo.GetOppRect().y);
        batch.draw(oppThree.getOppTexture(), oppThree.GetOppRect().x, oppThree.GetOppRect().y);
        batch.draw(oppFour.getOppTexture(), oppFour.GetOppRect().x, oppFour.GetOppRect().y);
    }

    private void SetNewGame() {
        oppOne = new Opponent(GameObjects.getEnemyOne(), 30, 30);
        oppTwo = new Opponent(GameObjects.getEnemyTwo(), 30, 380);
        oppThree = new Opponent(GameObjects.getEnemyThree(), 700, 30);
        oppFour = new Opponent(GameObjects.getEnemyFour(), 700, 380);
        Player = new PlayerControler(GameObjects.getPlayerTexture());
        GameState.ReleaseData();
        GameLevels.ONNewGame();
    }

    public static Vector3 ScreenToCamera(int screenX, int screenY) {
        Vector3 temp = new Vector3(screenX, screenY, 0);
        camera.unproject(temp);
        return temp;
    }

    @Override
    public void pause() {
        if(GameState.getState() == 1)
        GameState.SetGameState(2);
        GameState.PAUSE_BEGAN = new Date();
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}
