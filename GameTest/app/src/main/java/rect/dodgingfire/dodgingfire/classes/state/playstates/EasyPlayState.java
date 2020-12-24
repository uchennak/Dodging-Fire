package rect.dodgingfire.dodgingfire.classes.state.playstates;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;

import android.view.MotionEvent;



import java.util.ArrayList;

import rect.dodgingfire.dodgingfire.classes.util.Assets;
import rect.dodgingfire.dodgingfire.classes.gamemain.GameMainActivity;
import rect.dodgingfire.dodgingfire.classes.actors.Fire;
import rect.dodgingfire.dodgingfire.classes.actors.IceCream;
import rect.dodgingfire.dodgingfire.classes.state.gameoverstates.EasyGameOverState;
import rect.dodgingfire.dodgingfire.classes.state.otherstates.State;
import rect.dodgingfire.dodgingfire.classes.util.Painter;


public class EasyPlayState extends State {
    private IceCream iceCream;
    private ArrayList<Fire> fires;
    private int fireX = 400;
    private int fireY = 0;

    private int cloudX = 0;
    private int cloudY = 100;

    private float duckDuration = .6f;

    private int playerY;

    private int playerScore = 1;

    private int fireSpeed = -200;
    private static int ICECREAM_WIDTH = 38;
    private static int IC1_HEIGHT = 77;
    private static int IC2_HEIGHT= 102;
    private static int IC3_HEIGHT = 127;

    private static int FIRE_WIDTH = 60;
    private static int FIRE_HEIGHT = 60;

    public boolean iceCream1,iceCream2,iceCream3,durationEnded;


    private float recentTouchY;

    @Override
    public void init() {
        /* In order to align the icecream properly on the y-axis, I replaced 45 with 44(The height of the ground) because
        * when 45 is part of the equation, it seems as if the iceCreams drops for a bit
        * or does some sort of funny business
        *
        * This detail is virtually irrelevant but I feel as if 44 does a better job in making sure
        * the iceCream is on the ground at the beginning of the gameplay
        */

        iceCream = new IceCream(160, GameMainActivity.GAME_HEIGHT - 44
                - IC3_HEIGHT, ICECREAM_WIDTH, IC3_HEIGHT);
        fires = new ArrayList<Fire>();
        for (int i = 0; i < 5; i++) {
            // The y position initialization for the fires are irrelevant because they are invisible
            // until the resetLow() method is called. Which will then change the y position
            Fire fire = new Fire(i * 200, 345
                    , FIRE_WIDTH, FIRE_HEIGHT);
            fires.add(i,fire);
        }
        // cloud = new Cloud(100, 100);
        // cloud2 = new Cloud(500, 50);
        iceCream3 = true;

    }


    @Override
    public void update(float delta) {
        for(Fire fire: fires){
        fire.update(delta, fireSpeed);

        }
     playerScore += 1;
        iceCream.update(delta);

    }


    @Override
    public void render(Painter g) {
        g.setColor(Color.rgb(30, 144, 255));
        g.fillRect(0, 0, GameMainActivity.GAME_WIDTH,
                GameMainActivity.GAME_HEIGHT);

        renderSun(g);
        renderClouds(g);

        g.drawImage(Assets.mountains, 0, 81);
        g.drawImage(Assets.grass, 0, 405);
        g.setColor(Color.BLACK);

        renderSwipeUp(g);
        renderFire(g);
        renderScore(g);
        renderIceCream(g);
    }

    private void renderSwipeUp(Painter g){

        for(Fire fire : fires) {

            if (!fire.isVisible()) {
                g.drawImage(Assets.swipeUp, 200, 15, 200, 230);
            }

            // All fires in the Array have to return isVisible = true before the
              // swipeUp image goes away
        }

    }

    private void renderScore(Painter g) {
        g.setFont(Typeface.SANS_SERIF, 25);
        g.setColor(Color.BLACK);
        g.drawString("" + playerScore / 100, 20, 30);

    }



    private void renderFire(Painter g) {

        for (Fire fire : fires) {
            if (fire.isVisible()) {
                g.drawImage(Assets.fire, (int) fire.getX(), (int) fire.getY(), FIRE_WIDTH, FIRE_HEIGHT);
                if (Rect.intersects(iceCream.getRect(), fire.getRect())) {
                    fire.resetLow();
                }
            }
        }
    }


    private void renderIceCream(Painter g) {
        // iceCream 3 is true by default
        for (Fire fire : fires){

        if (iceCream3) {
            g.drawImage(Assets.iceCream3, (int) iceCream.getX(), (int) iceCream.getY(), ICECREAM_WIDTH, IC3_HEIGHT);


                if (fire.isVisible() && Rect.intersects(iceCream.getRect(), fire.getRect())) {
                    iceCream3 = false;
                    iceCream2 = true;

            }
        } else if (iceCream2) {

            g.drawImage(Assets.iceCream2, (int) iceCream.getX(), (int) iceCream.getY() + 25, ICECREAM_WIDTH, IC2_HEIGHT);

                if (fire.isVisible() && Rect.intersects(iceCream.getRect(), fire.getRect())) {
                    iceCream2 = false;
                    iceCream1 = true;

            }
        } else if (iceCream1) {

            g.drawImage(Assets.iceCream1, (int) iceCream.getX(), (int) iceCream.getY() + 50, ICECREAM_WIDTH, IC1_HEIGHT);

                if (fire.isVisible() && Rect.intersects(iceCream.getRect(), fire.getRect())) {
                    setCurrentState(new EasyGameOverState(playerScore/100));

            }
        }}

    }

    private void renderSun(Painter g) {
        g.setColor(Color.rgb(255, 165, 0));
        g.fillOval(715, -85, 170, 170);
        g.setColor(Color.YELLOW);
        g.fillOval(725, -75, 150, 150);
    }

    private void renderClouds(Painter g) {
        g.drawImage(Assets.cloud1, cloudX, cloudY, 100, 60);
        cloudX += 2;

        if (cloudX > 950) {
            cloudX = -100;
        }

    }


    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            recentTouchY = scaledY;
        } else if (e.getAction() == MotionEvent.ACTION_UP) {
            if (scaledY - recentTouchY < -50) {
                iceCream.jump();
            } else if (scaledY - recentTouchY > 50) {

            }
        }
        return true;
    }
}