import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    int x;
    int y;
    int playerPosX;
    int playerPosY;
    String bulletDirection;


    public KeyInput(Handler handler){

        this.handler = handler;

    }

    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();
        //System.out.println(key);

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                if(key == KeyEvent.VK_W){tempObject.setSpeedY(-10);} //Movement Controls
                if(key == KeyEvent.VK_S){tempObject.setSpeedY(10);}
                if(key == KeyEvent.VK_A){tempObject.setSpeedX(-10);}
                if(key == KeyEvent.VK_D){tempObject.setSpeedX(10);}

                if(key == KeyEvent.VK_UP) {
                    bulletDirection = "up";
                    tempObject.shoot(handler, bulletDirection);
                }
                if(key == KeyEvent.VK_DOWN) {
                    bulletDirection = "down";
                    tempObject.shoot(handler, bulletDirection);
                }
                if(key == KeyEvent.VK_LEFT) {
                    bulletDirection = "left";
                    tempObject.shoot(handler, bulletDirection);
                }
                if(key == KeyEvent.VK_RIGHT) {
                    bulletDirection = "right";
                    tempObject.shoot(handler, bulletDirection);
                }

            }

        }

    }

    public int[] getPlayerPos(){

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                playerPosX = tempObject.getX();
                playerPosY = tempObject.getY();

            }

        }

        return new int[] {playerPosX, playerPosY};

    }

    public void keyReleased(KeyEvent e){

        int key = e.getKeyCode();
        //System.out.println(key);

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                if(key == KeyEvent.VK_W) tempObject.setSpeedY(0); //Letting go of key will stop player moving.
                if(key == KeyEvent.VK_S) tempObject.setSpeedY(0);
                if(key == KeyEvent.VK_A) tempObject.setSpeedX(0);
                if(key == KeyEvent.VK_D) tempObject.setSpeedX(0);

            }

        }

    }

}