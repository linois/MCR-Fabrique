import Shapes.Bouncable;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BounceApp
{
    // Liste contenant toutes les formes
    private final LinkedList<Bouncable> bouncers = new LinkedList();
    // Référence sur l'unique fenêtre
    Window window;

    /**
     * Constructeur
     */
    public BounceApp() {
        window = Window.getInstance();
        int nbFullShapes = 20;
        int nbEmptyShapes = 20;
        // Crée des formes pleines au lancement de l'application
        new FullFactory().fillFormList(window, bouncers, nbFullShapes);
        // Gère les touches appuyées par l'utilisateur
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                switch(ke.getKeyChar()) {
                    // Supprime les formes
                    case 'e':
                        bouncers.clear();
                        break;
                    // Crée des formes vides
                    case 'b':
                        new EmptyFactory().fillFormList(window, bouncers,
                                nbEmptyShapes);
                        break;
                    // Crée des formes pleines
                    case 'f':
                        new FullFactory().fillFormList(window, bouncers,
                                nbFullShapes);
                        break;
                    // Quitte l'application
                    case 'q':
                        System.exit(0);
                }
            }
        });
    }

    public void loop() {
        while(true) {
            // Gère les accès concurrents en cas d'appui répété sur une touche
            try {
                for(Bouncable b : bouncers){
                    b.draw();
                    b.move();
                }
            } catch(ConcurrentModificationException cme){
                System.out.println("A ConcurrentModificationException occured." +
                        "\nThe last key press has been dropped.\n");
            }
            window.repaint();
            TimeUnit.MILLISECONDS.sleep(20);
        }
    }

    public static void main(String ... args) {
        try {
            new BounceApp().loop();
        } catch (InterruptedException ex) {
            Logger.getLogger(BounceApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}