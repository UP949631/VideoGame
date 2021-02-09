import java.awt.*;

public class HUD {

    public static int HEALTH = 10;
    public int fps;

    public void tick(){

        HEALTH = Game.clamp(HEALTH, 0, 10);

    }

    public void render(Graphics g){

        g.setColor(Color.red); //Health Bar
        g.fillRect(40, Game.HEIGHT - 100, 400, 50);
        g.setColor(Color.green);
        g.fillRect(40, Game.HEIGHT - 100, HEALTH * 40, 50);

        g.drawString("FPS :" + fps, 15, 15); //FPS Counter

    }

    public void fpsCounter(int frames){

        fps = frames;

    }

}