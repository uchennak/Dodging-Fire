package rect.dodgingfire.dodgingfire.classes.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import rect.dodgingfire.dodgingfire.classes.gamemain.GameMainActivity;
import rect.dodgingfire.dodgingfire.classes.state.otherstates.State;

public class InputHandler implements OnTouchListener {
    private State currentState;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int scaledX = (int) ((event.getX() / v.getWidth()) * GameMainActivity.GAME_WIDTH);
        int scaledY = (int) ((event.getY() / v.getHeight()) * GameMainActivity.GAME_HEIGHT);
        return currentState.onTouch(event, scaledX, scaledY);
    }


}
