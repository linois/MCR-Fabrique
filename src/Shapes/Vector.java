package Shapes;

public class Vector {
    // Déplacement sur l'axe des X
    private int x;
    // Déplacement sur l'axe des Y
    private int y;

    /**
     * Constructeur de la classe vecteur
     * @param x la valeur de déplacement sur l'axe des X
     * @param y la valeur de déplacement sur l'axe des Y
     */
    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne la valeur de déplacement sur l'axe des X
     * @return La valeur de déplacement sur l'axe des X
     */
    public int getX(){return x;}

    /**
     * Retourne la valeur de déplacement sur l'axe des Y
     * @return La valeur de déplacement sur l'axe des Y
     */
    public int getY(){return y;}

    /**
     * Inverse la valeur de déplacement sur l'axe des X en cas de rebond
     */
    public void reverseX(){x *= -1;}

    /**
     * Inverse la valeur de déplacement sur l'axe des Y en cas de rebond
     */
    public void reverseY(){y *= -1;}
}

