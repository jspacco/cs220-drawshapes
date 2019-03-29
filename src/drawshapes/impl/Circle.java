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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Point point) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setColor(Color color) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isSelected() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setSelected(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public Point getAnchorPoint() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAnchorPoint(Point p) {
        // TODO Auto-generated method stub
    }

    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        return null;
    }
}
