package Renderer;

import Shapes.Bouncable;
import java.awt.Graphics2D;

public class FullShapeRenderer implements Renderable {

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
