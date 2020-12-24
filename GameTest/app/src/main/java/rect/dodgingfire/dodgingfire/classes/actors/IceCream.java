package rect.dodgingfire.dodgingfire.classes.actors;

import android.graphics.Rect;

import rect.dodgingfire.dodgingfire.classes.util.Assets;


public class IceCream {

    private static  int ACCEL_GRAVITY = 1400 ;//1800
    private static  int JUMP_VELOCITY =-600 ; //-600

    private float x,y;
    private int width,height;
    private Rect rect,ground;


    private int velY;

    public IceCream(float x, float y, int width, int height){


        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        ground = new Rect(0, 405, 800, 405 + 45);
        rect = new Rect();


    }

    public void update(float delta) {

        if (!isGrounded()) {

            velY += ACCEL_GRAVITY * delta; ;
           if(y<50){
               y=50;
           }
        } else {
            y = 406 - height;
            velY = 0;
        }
        y += velY * delta;
        updateRect();
    }



   public void jump(){
       /*the isGrounded method returns false when jump() is called
       * because the rect of the iceCream no longer interects with the rect of the ground
       */

    if(isGrounded()) {
        Assets.playSound(Assets.onJumpID);
       y -= 10;
       velY = JUMP_VELOCITY;
        }


       updateRect();

   }





    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void updateRect() {

//Look at the update and updateRect() methods in InfJIceCream If you want to correctly
// adjust the top rect(int left, int top, int right, int bottom);
        rect.set((int) x, (int) y, (int) x + width, (int) y + height);


    }
    public Rect getRect(){
        return rect;
    }


    public boolean isGrounded() {
        return Rect.intersects(rect, ground);
    }
}
