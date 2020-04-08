package Renderer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import Shapes.Bouncable;

public class EmptyShapeRenderer implements Renderable {

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(2));
        g.draw(b.getShape());
        b.move();
    }
}
