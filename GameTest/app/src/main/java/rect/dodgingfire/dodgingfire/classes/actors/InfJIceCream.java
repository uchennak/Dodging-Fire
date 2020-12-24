package rect.dodgingfire.dodgingfire.classes.actors;

import android.graphics.Rect;

import rect.dodgingfire.dodgingfire.classes.util.Assets;


public class InfJIceCream {

    private static int ACCEL_GRAVITY = 1500 ;//1800
    private static int JUMP_VELOCITY = -500 ; //-600

    private float x,y;
    private int width,height;
    private Rect rect,ground;


    private int velY;

    public InfJIceCream(float x, float y, int width, int height){


        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        ground = new Rect(0, 405, 800, 405 + 45);
        rect = new Rect();


    }

       public void update1(float delta) {

        if (!isGrounded()) {

            velY += ACCEL_GRAVITY * delta; ;
            if(y<35){
                y=35;
            }
        } else {
            y = 406 - height;
            velY = 0;
        }
        y += velY * delta;
        updateRect1();
    }

    public void update2(float delta) {

        if (!isGrounded()) {

            velY += ACCEL_GRAVITY * delta;

            if(y<15){
                y=15;
            }
        } else {
            y = 406 - height;
            velY = 0;
        }
        y += velY * delta;
        updateRect2();
    }

    public void update3 (float delta) {

        if (!isGrounded()) {

            velY += ACCEL_GRAVITY * delta; ;

           if(y<-10){
                y=-10;
            }
        } else {
            y = 406 - height;
            velY = 0;
        }
        y += velY * delta;
        updateRect3();
    }

    public void jump(){

            Assets.playSound(Assets.onJumpID);
            y -= 10;
            velY = JUMP_VELOCITY;

    updateRect1();
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void updateRect1() {
        rect.set((int) x, (int) y, (int) x + width, (int) y + height);

    }
    public void updateRect2() {
        rect.set((int) x, (int) y + 25, (int) x + width, (int) y + height  );

    }
    public void updateRect3() {
        rect.set((int) x, (int) y + 50, (int) x + width, (int) y + height );


    }
    public Rect getRect(){
        return rect;
    }

    public boolean isGrounded() {
        return Rect.intersects(rect, ground);
    }
}



