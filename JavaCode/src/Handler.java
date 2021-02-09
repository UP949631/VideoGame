import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){ //Update all game objects.

        for(int i = 0; i < object.size(); i++){ //For all game objects.

            GameObject tempObject = object.get(i); //Toggle through objects.

            tempObject.tick();

        }

    }

    public void render(Graphics g){ //Render all game objects.

        for(int i = 0; i < object.size(); i++){

            GameObject tempObject = object.get(i);

            tempObject.render(g);

        }

    }

    public GameObject addObject(GameObject object){

        this.object.add(object);

        return object;
    }

    public void removeObject(GameObject object){

        this.object.remove(object);

    }

}
