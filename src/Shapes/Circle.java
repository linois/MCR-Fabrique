package Shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends Shape {
    /**
     * Constructeur du cercle
     * @param height Sa hauteur/longueur
     * @param color Sa couleur
     * @param posX Sa position sur l'axe des X
     * @param posY Sa position sur l'axe des Y
     * @param vector Son vecteur de déplacement
     */
    public Circle(int height, Color color, int posX, int posY, Vector vector) {
        super(height, color, posX, posY, vector);
    }

    /**
     * Dessine la forme du cercle
     * @return Les paramètres du cercle sous la forme d'une shape
     */
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getX(), getY(), getHeight(), getHeight());
    }
}
