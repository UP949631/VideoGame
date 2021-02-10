import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    public static void main(String args[]){

        new Game();

    }
    
    private static final long serialVersionUID = -8830209527649295064L;
    public static final int WIDTH = 1920, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;

    public synchronized void start(){

        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){

        try{

            thread.join();
            running = false;

        }

        catch(Exception e){

            e.printStackTrace(); //Print error.

        }

    }

    public void run(){

        this.requestFocus();

        long lastTime = System.nanoTime(); //Game loop to allow updating and make the game run.
        double amountOfTicks = 60.0;
        double nanosecondsPerTick = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running){

            long now = System.nanoTime();
            delta += (now - lastTime) / nanosecondsPerTick;
            lastTime = now;

            while(delta >= 1){

                tick();
                delta--;

            }

            if(running)
                render();

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                hud.fpsCounter(frames);
                frames = 0;
            }

        }

        stop();

    }

    private void tick(){

        handler.tick();
        hud.tick();

    }

    private void render(){

        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){ //BufferStrategy starts off as null

            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.darkGray); //Base Background
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();

    }

    public Game(){

        handler = new Handler();

        hud = new HUD();

        this.addKeyListener(new KeyInput(handler));

        new GameWindow(WIDTH, HEIGHT, "Dungeon Runner", this);

        handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2 -32, ID.Player, handler));

    }




    public static int clamp(int var, int min, int max){ //Method to ensure values stay within limits e.t.c Health, Position.

        if(var >= max){return var = max;}
        else if(var <= min){return var = min;}
        else return var;

    }

}
