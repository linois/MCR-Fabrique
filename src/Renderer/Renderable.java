package Renderer;

import Shapes.Bouncable;

import java.awt.*;

public interface Renderable
{
    void display(Graphics2D g, Bouncable b);
}
