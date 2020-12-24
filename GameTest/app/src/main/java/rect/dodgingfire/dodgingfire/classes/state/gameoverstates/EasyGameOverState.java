package rect.dodgingfire.dodgingfire.classes.state.gameoverstates;

import android.view.MotionEvent;
import android.graphics.Color;
import android.graphics.Typeface;

import rect.dodgingfire.dodgingfire.classes.gamemain.GameMainActivity;
import rect.dodgingfire.dodgingfire.classes.state.otherstates.MenuState;
import rect.dodgingfire.dodgingfire.classes.state.otherstates.State;
import rect.dodgingfire.dodgingfire.classes.util.Painter;


public class EasyGameOverState extends State {

    private String playerScore;
    private String gameOverMessage = "GAME OVER";

    public EasyGameOverState(int playerScore) {
        this.playerScore = playerScore + ""; // Convert int to String
        if (playerScore > GameMainActivity.getEasyHighScore()) {
            GameMainActivity.setEasyHighScore(playerScore);
            gameOverMessage = "HIGH SCORE";
        }
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Painter g) {
        g.setColor(Color.rgb(255, 145, 0));
        g.fillRect(0, 0, GameMainActivity.GAME_WIDTH,
                GameMainActivity.GAME_HEIGHT);
        g.setColor(Color.DKGRAY);
        g.setFont(Typeface.DEFAULT_BOLD, 50);
        g.drawString(gameOverMessage, 257, 175);
        g.drawString(playerScore, 385, 250);
        g.drawString("Touch the screen.", 220, 350);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            setCurrentState(new MenuState());
        }
        return true;
    }

}