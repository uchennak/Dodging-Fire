package rect.dodgingfire.dodgingfire.classes.state.otherstates;

import android.view.MotionEvent;

import rect.dodgingfire.dodgingfire.classes.util.Assets;
import rect.dodgingfire.dodgingfire.classes.util.Painter;
import rect.dodgingfire.dodgingfire.classes.util.UIButton;


public class MenuState extends State {
    private UIButton startButton, scoreButton;


    @Override
    public void init() {
        startButton = new UIButton(316, 227, 484, 286, Assets.start,
                Assets.startDown);
        scoreButton = new UIButton(316, 300, 484, 359, Assets.score,
                Assets.scoreDown);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(Painter g) {

        g.drawImage(Assets.dodgingFireWelcome, 0, 0);
        startButton.render(g);
       scoreButton.render(g);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            startButton.onTouchDown(scaledX, scaledY);
            scoreButton.onTouchDown(scaledX, scaledY);
        }
        if (e.getAction() == MotionEvent.ACTION_UP) {
            if (startButton.isPressed(scaledX, scaledY)) {
                startButton.cancel();
                setCurrentState(new ChooseLevelState());
            } else if (scoreButton.isPressed(scaledX, scaledY)) {
                scoreButton.cancel();
                setCurrentState(new ScoreState());
            } else {
                startButton.cancel();
                scoreButton.cancel();
            }
        }
        return true;
    }
}