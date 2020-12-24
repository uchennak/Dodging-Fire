package rect.dodgingfire.dodgingfire.classes.state.otherstates;

import android.view.MotionEvent;

import rect.dodgingfire.dodgingfire.classes.util.Assets;
import rect.dodgingfire.dodgingfire.classes.util.Painter;

/**
 * Created by chiozokamalu on 11/4/15.
 */
public class LoadState extends State {
    @Override
    public void init() {
        Assets.load();
    }

    @Override
    public void update(float delta) {
        setCurrentState(new MenuState());
    }

    @Override
    public void render(Painter g) {

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
