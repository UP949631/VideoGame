import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int speedX, speedY;

    protected GameObject(int x, int y, ID id){

        this.x = x;
        this.y = y;
        this.id = id;

    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setX(int x){this.x = x;}

    public int getX(){return x;}

    public void setY(int y){this.y = y;}

    public int getY(){return y;}

    public void setId(ID id){this.id = id;}

    public ID getId(){return id;}

    public void setSpeedX(int speedX){this.speedX = speedX;}

    public int speedX(){return speedX;}

    public void setSpeedY(int speedY){this.speedY = speedY;}

    public int speedY(){return speedY;}

    public synchronized void shoot(Handler handler, String bulletDirection){

        if(this.getId() == ID.Player){

            GameObject tempBullet = handler.addObject(new PlayerBullet(x + 32, y + 32, ID.PlayerBullet, handler));

            if(bulletDirection == "up") tempBullet.setSpeedY(-50);
            else if(bulletDirection == "down") tempBullet.setSpeedY(50);
            else if(bulletDirection == "left") tempBullet.setSpeedX(-50);
            else if(bulletDirection == "right") tempBullet.setSpeedX(50);

        }

    }

}