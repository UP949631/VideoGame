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

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                switch (key){
                    case (KeyEvent.VK_W):
                        tempObject.setSpeedY(-10);
                        break;
                    case(KeyEvent.VK_S):
                        tempObject.setSpeedY(10);
                        break;
                    case(KeyEvent.VK_A):
                        tempObject.setSpeedX(-10);
                        break;
                    case(KeyEvent.VK_D):
                        tempObject.setSpeedX(10);
                        break;
                    case(KeyEvent.VK_UP):
                        bulletDirection = "up";
                        tempObject.shoot(handler, bulletDirection);    
                        break;
                    case(KeyEvent.VK_DOWN):
                        bulletDirection = "down";
                        tempObject.shoot(handler, bulletDirection);  
                        break;
                    case(KeyEvent.VK_LEFT):
                        bulletDirection = "left";
                        tempObject.shoot(handler, bulletDirection);
                        break;
                    case(KeyEvent.VK_RIGHT):
                        bulletDirection = "right";
                        tempObject.shoot(handler, bulletDirection);
                        break;
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

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                switch(key){
                    case(KeyEvent.VK_W):
                        tempObject.setSpeedY(0);
                        break;
                    case(KeyEvent.VK_S):
                        tempObject.setSpeedY(0);
                        break;
                    case(KeyEvent.VK_A):
                        tempObject.setSpeedX(0);
                        break;
                    case(KeyEvent.VK_D):
                        tempObject.setSpeedX(0);
                }
            }

        }

    }

}