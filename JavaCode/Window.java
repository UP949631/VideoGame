import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 9034494958129720942L;

    public Window(int width, int height, String title, Game game) {

        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit Button on Window.
        frame.setResizable(false); //Prevent resizing of the window.
        frame.setLocationRelativeTo(null); //Make window start in middle of screen to make it seem nicer.
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }

}