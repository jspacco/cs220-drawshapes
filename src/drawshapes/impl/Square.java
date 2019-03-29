package drawshapes.impl;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Square implements IShape
{
    private Point anchor;
    private int length;
    private Color color;
    private boolean selected;
    private BoundingBox boundingBox;
    
    public Square(Color color, int centerX, int centerY, int length) {
        this.length=length;
        this.anchor=new Point(centerX - length/2, centerY - length/2);
        this.selected=false;
        this.color=color;
        this.boundingBox = new BoundingBox(anchor.x, anchor.x + length, anchor.y, anchor.y + length);
    }
    @Override
    public void draw(Graphics g){
        // TODO: Draw this shape differently if it is selected
        g.setColor(color);
        g.fillRect((int)anchor.x, (int)anchor.y,
                length, length);
    }
    @Override
    public Color getColor(){
        return color;
    }
    @Override
    public void setColor(Color color) {
        this.color=color;
    }
    @Override
    public boolean isSelected() {
        return this.selected;
    }
    @Override
    public void setSelected(boolean b) {
        this.selected = b;
    }
    @Override
    public Point getAnchorPoint() {
        return this.anchor;
    }
    @Override
    public void setAnchorPoint(Point p) {
        this.anchor = p;
    }
    @Override
    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    @Override
    public boolean contains(Point point) {
        throw new UnsupportedOperationException("Implement this method");
    }
    @Override
    public boolean intersects(IShape other) {
        throw new UnsupportedOperationException("Implement this method");
    }
}
