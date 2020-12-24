package rect.dodgingfire.dodgingfire.classes.actors;

import android.graphics.Rect;


public class Fire {
    private float x, y;
    private int width, height;
    private Rect rect;
    private boolean visible;
    public static final int UPPER_Y = 0;
    public static final int RIGHT_BELOW_UPPER_Y = 32;
    public static final int RIGHT_ABOVE_LOWER_Y = 303;
    public static final int LOWER_Y = 345;

    public Fire(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rect((int) x, (int) y, (int) x + width, (int) y + height);
        visible = false;
    }


   public void update(float delta, int fireSpeed) {
        x += fireSpeed * delta;


       if(y == LOWER_Y && x < -50){
          resetLow();
       }
       if (y == RIGHT_ABOVE_LOWER_Y && x < -50){
           resetRALY();
       }
       if (y == RIGHT_BELOW_UPPER_Y && x < -50){
           resetRBUY();
       }
       if (y==UPPER_Y && x < -50){
           resetHigh();
       }

       updateRect();
   }

    public void updateRect() {
        rect.set((int) x, (int) y, (int) x + width, (int) y + height);
    }

    public void resetLow() {

        visible = true;

        y = LOWER_Y;
        x = x + 1000;

    }
    public void resetRALY(){
        visible = true;
        y = RIGHT_ABOVE_LOWER_Y;
        x = x + 4500;
    }
    public void resetRBUY(){
        visible = true;
        y = RIGHT_BELOW_UPPER_Y;
        x = x + 4500;
    }
    public void resetHigh(){

        visible = true;

        y = UPPER_Y;
        x = x + 1500;


    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rect getRect(){
        return rect;
    }
}