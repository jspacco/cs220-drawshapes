package drawshapes.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * THIS CLASS IS NOT FINISHED
 * 
 * Add and compute the bounding box.
 * 
 * Implement the rest of the methods.
 * 
 * @author jspacco
 *
 */
public class Circle implements IShape
{
    private Point center;
    private Color color;
    private int diameter;
    
    public Circle(Color color, Point center, int diameter) {
        this.color = color;
        this.center = center;
        this.diameter= diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval((int)center.getX() - diameter/2,
                (int)center.getY() - diameter/2,
                diameter,
                diameter);
    }

    @Override
    public boolean intersects(IShape other) {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public boolean contains(Point point) {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public boolean isSelected() {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public void setSelected(boolean b) {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public Point getAnchorPoint() {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public void setAnchorPoint(Point p) {
        throw new UnsupportedOperationException("Implement this");
    }

    @Override
    public BoundingBox getBoundingBox() {
        throw new UnsupportedOperationException("Implement this");
    }
}
