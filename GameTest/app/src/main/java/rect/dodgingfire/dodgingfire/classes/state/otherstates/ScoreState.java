package rect.dodgingfire.dodgingfire.classes.state.otherstates;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;

import rect.dodgingfire.dodgingfire.classes.gamemain.GameMainActivity;
import rect.dodgingfire.dodgingfire.classes.util.Painter;


public class ScoreState extends State {
    private String easyHighScore, hardHighScore, superHardHighScore, superDuperHardHighScore;

    @Override
    public void init() {
        easyHighScore = GameMainActivity.getEasyHighScore() + "";
        hardHighScore = GameMainActivity.getHardHighScore() + "";
        superHardHighScore = GameMainActivity.getSuperHardHighScore() + "";
        superDuperHardHighScore = GameMainActivity.getSuperDuperHardHighScore() + "";
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(Painter g) {
        g.setColor(Color.rgb(53, 156, 253));
        g.fillRect(0, 0, GameMainActivity.GAME_WIDTH,
                GameMainActivity.GAME_HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(Typeface.DEFAULT_BOLD, 70);
        g.drawString("High Scores", 200, 100);
        g.setFont(Typeface.DEFAULT_BOLD, 50);

        g.drawString("Easy: " + easyHighScore, 50, 190);
        g.drawString("Hard: " + hardHighScore, 200, 190);
        g.drawString("SuperHard: " + superHardHighScore, 50, 250);
        g.drawString("SuperDuperHard: " + superDuperHardHighScore, 200, 250);
        g.setFont(Typeface.DEFAULT_BOLD, 50);
        g.drawString("Touch the screen to Exit.", 120, 380);

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            setCurrentState(new MenuState());
        }
        return true;
    }
}