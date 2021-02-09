import java.awt.*;

public class PlayerBullet extends GameObject{

    Handler handler;
    Player player;

    public PlayerBullet(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;

    }

    public void tick() {

        x += speedX();
        y += speedY();

        collision();

    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, 10, 10);

    }

    private void collision(){

        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                if(getBounds().intersects(tempObject.getBounds())){

                    handler.removeObject(this);

                }

            }

        }

        if(this.getX() >= Game.WIDTH - 10 || this.getX() <= 10){

            handler.removeObject(this);

        }
        else if(this.getY() >= Game.HEIGHT - 10 || this.getY() <= 10){

            handler.removeObject(this);

        }

    }


    public void render(Graphics g) {

        g.setColor(Color.yellow);
        g.fillRect(x, y, 10, 10);
        g.setColor(Color.black);
        g.drawRect(x, y, 10, 10);

    }

}