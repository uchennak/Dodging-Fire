package rect.dodgingfire.dodgingfire.classes.state.otherstates;

import android.view.MotionEvent;

import rect.dodgingfire.dodgingfire.classes.gamemain.GameMainActivity;
import rect.dodgingfire.dodgingfire.classes.util.Painter;


public abstract class State {
    public void setCurrentState(State newState) {
        GameMainActivity.sGame.setCurrentState(newState);
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Painter g);

    public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);
}