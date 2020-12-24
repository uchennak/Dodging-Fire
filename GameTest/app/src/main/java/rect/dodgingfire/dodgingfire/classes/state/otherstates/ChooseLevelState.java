package rect.dodgingfire.dodgingfire.classes.state.otherstates;

import android.view.MotionEvent;

import rect.dodgingfire.dodgingfire.classes.util.Assets;
import rect.dodgingfire.dodgingfire.classes.state.playstates.EasyPlayState;
import rect.dodgingfire.dodgingfire.classes.state.playstates.HardState;
import rect.dodgingfire.dodgingfire.classes.state.playstates.SuperHardState;
import rect.dodgingfire.dodgingfire.classes.util.Painter;
import rect.dodgingfire.dodgingfire.classes.util.UIButton;

/**
 * Created by kamalu on 5/27/2016.
 */
public class ChooseLevelState extends State {
    private UIButton easyB, hardB, superHardButton ;
    @Override
    public void init() {
        easyB = new UIButton(200, 190, 408, 333, Assets.easyB, Assets.easyBDown);
        hardB = new UIButton(400, 190, 609, 333, Assets.hardB, Assets.hardBDown);
        superHardButton = new UIButton(200, 332, 609, 432 , Assets.superHardB, Assets.superHardBDown );
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
    g.drawImage(Assets.dodgingFireWelcome, 0, 0);
    easyB.render(g);
    hardB.render(g);
    superHardButton.render(g);

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            easyB.onTouchDown(scaledX, scaledY);
            hardB.onTouchDown(scaledX, scaledY);
            superHardButton.onTouchDown(scaledX,scaledY);
        }
        if (e.getAction() == MotionEvent.ACTION_UP) {
            if (easyB.isPressed(scaledX, scaledY)) {
                easyB.cancel();
                setCurrentState(new EasyPlayState());
            }
            else if (hardB.isPressed(scaledX, scaledY)) {
                hardB.cancel();
                setCurrentState(new HardState());

            } else if(superHardButton.isPressed(scaledX, scaledY)) {
                superHardButton.cancel();
                setCurrentState(new SuperHardState());
            } else {
                easyB.cancel();
                hardB.cancel();
                superHardButton.cancel();
            }
            }

        return true;

    }
}
