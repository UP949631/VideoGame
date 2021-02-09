import java.awt.*;

public class Player extends GameObject {

    Handler handler;
    GameObject gameObject;
    Game game;

    public Player(int x, int y, ID id, Handler handler){

        super(x, y, id);
        this.handler = handler;

    }

    public void tick(){

        x += speedX();
        y += speedY();

        x = Game.clamp(x, 0, Game.WIDTH - 64);
        y = Game.clamp(y, 0, Game.HEIGHT - 64);

        collision();

    }

    public Rectangle getBounds(){

        return new Rectangle(x, y, 64, 64);

    }

    private void collision(){

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.PlayerBullet){
                if(getBounds().intersects(tempObject.getBounds())){

                    HUD.HEALTH -= 1;

                }

            }

        }

    }

    public void render(Graphics g){

        g.setColor(Color.white);
        g.fillRect(x, y, 64, 64); //Base
        g.setColor(Color.black);
        g.fillRect(x + 16, y + 16, 4, 20); //Eye 1
        g.fillRect(x + 44, y + 16, 4, 20); //Eye 2
        g.drawRect(x, y, 64, 64); //Outline/DropShadow

    }

}
