package drawshapes.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class DrawShapes extends JFrame
{
    // The enum tracks the different types of shape
    // An enum is used for value that are constants
    private enum ShapeType {
        SQUARE,
        CIRCLE
    }
    
    // The panel we will draw the shapes on
    private DrawShapesPanel shapePanel;
    // The scene containing all of the shapes
    private Scene scene;
    // Default shape type is square
    private ShapeType shapeType = ShapeType.SQUARE;
    // The color we will use to draw the next shape
    private Color color = Color.RED;

    public DrawShapes(int width, int height)
    {
        setTitle("Draw Shapes!");
        
        scene = new Scene();
        
        // create our canvas, add to this frame's content pane
        shapePanel = new DrawShapesPanel(width, height, scene);
        
        // Sets the pane where we'll draw things to our special shape panel
        this.getContentPane().add(shapePanel, BorderLayout.CENTER);
        // We can't resize the JFrame
        this.setResizable(false);
        this.pack();
        this.setLocation(100,100);
        
        // Add key and mouse listeners to our canvas
        initializeMouseListener();
        initializeKeyListener();
        
        // initialize the menu options
        initializeMenu();

        // Handle closing the window.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // The System.exit method shuts down the JVM and
                // tells it to clean up any open resources
                // like GUI objects, open files, open network connections
                // and so on. This may not be necessary but often you see
                // System.exit used with GUI programs.
                System.exit(0);
            }
        });
    }
    
    private void initializeMouseListener()
    {
        // Add a listener for mouse motions (i.e. moving the mouse)
        shapePanel.addMouseMotionListener(new MouseMotionListener() {
            
            @Override
            public void mouseMoved(MouseEvent e) {
                // This method is called when you move the mouse
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                // A "drag" is when you move the mouse while one of
                // the buttons has been held down
                System.out.printf("mouse drag! (%d, %d)\n", e.getX(), e.getY());
            }
        });
        
        // Listen for mouse clicks
        shapePanel.addMouseListener(new MouseAdapter() {

            /* (non-Javadoc)
             * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
             */
            public void mouseClicked(MouseEvent e)
            {
                // mouseClicked() is called when you press and release a mouse button
                // WITHOUT MOVING THE MOUSE. If you move the mouse, instead you get a 
                // mousePressed(), some number mouse mouseDragged(), then a mouseReleased().
                
                if (e.getButton()==MouseEvent.BUTTON1) {
                    System.out.printf("Left click at (%d, %d)\n", e.getX(), e.getY());
                    if (shapeType == ShapeType.SQUARE) {
                        scene.addShape(new Square(color, 
                                e.getX(), 
                                e.getY(),
                                100));
                    } else if (shapeType == ShapeType.CIRCLE){
                        scene.addShape(new Circle(color,
                                e.getPoint(),
                                100));
                    }
                } else if (e.getButton()==MouseEvent.BUTTON3) {
                    // handle right-click
                    // right-click is button #3, middle button (if there is one) is button #2
                    System.out.printf("Right click at (%d, %d)\n", e.getX(), e.getY());
                } else if (e.getButton() == MouseEvent.BUTTON2){
                    System.out.printf("Middle click at (%d, %d)\n", e.getX(), e.getY());
                }
                // IMPORTANT
                // repaint() tells the JFrame to re-draw itself, which has the effect
                // of calling the paint() method for the DrawShapesPanel, which is what
                // tells the scene to draw itself
                // 
                // Call this from DrawShapes whenever you want to redraw the scene!
                repaint();
            }

            /* (non-Javadoc)
             * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
             */
            public void mousePressed(MouseEvent e)
            {
                if (e.getButton()==MouseEvent.BUTTON1) {
                    // Press left mouse button
                    System.out.printf("Pressed left button at (%d, %d)\n", e.getX(), e.getY());
                } else if (e.getButton()==MouseEvent.BUTTON3) {
                    // Press right mouse button
                    System.out.printf("Pressed right button at (%d, %d)\n", e.getX(), e.getY());
                } else if (e.getButton() == MouseEvent.BUTTON2){
                    // Press middle mouse button (if your mouse has a middle button)
                    System.out.printf("Pressed middle (%d, %d)\n", e.getX(), e.getY());
                }
                
            }

            /* (non-Javadoc)
             * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
             */
            public void mouseReleased(MouseEvent e)
            {
                // Called when you release the button you clicked
                if (e.getButton()==MouseEvent.BUTTON1) {
                    // Press left mouse button
                    System.out.printf("Released left button at (%d, %d)\n", e.getX(), e.getY());
                } else if (e.getButton()==MouseEvent.BUTTON3) {
                    // Press right mouse button
                    System.out.printf("Released right button at (%d, %d)\n", e.getX(), e.getY());
                } else if (e.getButton() == MouseEvent.BUTTON2){
                    // Press middle mouse button (if your mouse has a middle button)
                    System.out.printf("Released middle (%d, %d)\n", e.getX(), e.getY());
                }
            }
            
        });
    }
    
    /**
     * Initialize the menu options
     */
    private void initializeMenu()
    {
        // menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // file menu
        JMenu fileMenu=new JMenu("File");
        menuBar.add(fileMenu);
        // load
        JMenuItem loadItem = new JMenuItem("Load");
        fileMenu.add(loadItem);
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO load a file using a JFileDialog thing
                System.out.println(e.getActionCommand());
            }
        });
        // save
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        });
        fileMenu.addSeparator();
        // edit
        JMenuItem itemExit = new JMenuItem ("Exit");
        fileMenu.add(itemExit);
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=e.getActionCommand();
                System.out.println(text);
                System.exit(0);
            }
        });

        // color menu
        JMenu colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);

        // red color
        JMenuItem redColorItem= new JMenuItem ("Red");
        colorMenu.add(redColorItem);
        redColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=e.getActionCommand();
                System.out.println(text);
                // change the color instance variable to red
                color = Color.RED;
            }
        });
        
        
        // blue color
        JMenuItem blueColorItem = new JMenuItem ("Blue");
        colorMenu.add(blueColorItem);
        blueColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=e.getActionCommand();
                System.out.println(text);
                // change the color instance variable to blue
                color = Color.BLUE;
            }
        });
        
        // shape menu
        JMenu shapeMenu = new JMenu("Shape");
        menuBar.add(shapeMenu);
        
        // square
        JMenuItem squareItem = new JMenuItem("Square");
        shapeMenu.add(squareItem);
        squareItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Square");
                shapeType = ShapeType.SQUARE;
            }
        });
        
        // circle
        JMenuItem circleItem = new JMenuItem("Circle");
        shapeMenu.add(circleItem);
        circleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Circle");
                shapeType = ShapeType.CIRCLE;
            }
        });
        
        
        // new menu option
        JMenu operationModeMenu=new JMenu("new menu option");
        menuBar.add(operationModeMenu);
        
        // draw option
        JMenuItem drawItem=new JMenuItem("option #1");
        operationModeMenu.add(drawItem);
        drawItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=e.getActionCommand();
                System.out.println(text);
            }
        });
        
        // select option
        JMenuItem selectItem=new JMenuItem("option #2");
        operationModeMenu.add(selectItem);
        selectItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=e.getActionCommand();
                System.out.println(text);
            }
        });
        

        // set the menu bar for this frame
        this.setJMenuBar(menuBar);
    }
    
    /**
     * Initialize the keyboard listener.
     */
    private void initializeKeyListener()
    {
        shapePanel.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                System.out.println("key typed: " +e.getKeyChar());
            }
            public void keyReleased(KeyEvent e){
                // TODO implement this method if you need it
            }
            public void keyTyped(KeyEvent e) {
                // TODO implement this method if you need it
            }
        });
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        DrawShapes shapes=new DrawShapes(700, 600);
        shapes.setVisible(true);
    }

}
