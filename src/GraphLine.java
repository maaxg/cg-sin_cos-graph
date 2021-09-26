import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GraphLine extends JPanel {
    private static final double 
        WIDTH = 640, 
        HEIGHT = 480, 
        AMPLITUDE = HEIGHT / 12;

    private static final int 
        MARGIN = 32, 
        DOT_SIZE = 2, 
        SPEED = 10;

    private double x = MARGIN;

    private final double 
        sinY = HEIGHT / 2, 
        cosY = HEIGHT / 2.10;

    private final int dX = 1;


    private final List<Point2D.Double> sinPoints;
    private final List<Point2D.Double> cosPoints;
    private final Timer timer;

    public GraphLine(){
        setPreferredSize(new Dimension((int) WIDTH, (int) HEIGHT));
        sinPoints = new ArrayList<>();
        cosPoints = new ArrayList<>();
        timer = new Timer(SPEED, event -> {addSinPoints(); addCosPoints();}); 
        timer.start();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2sin = (Graphics2D)g;
        Graphics2D g2cos = (Graphics2D)g;
        
        
        sinDraw(g2sin);
        cosDraw(g2cos);
        
        drawX(g);
        drawY(g);
        
        g.setColor(Color.BLUE);
        
        drawValuesX(g);
        drawValuesY(g); 
        
 
    }

    private void cosDraw(Graphics2D g2cos){
        g2cos.setColor(Color.GREEN);
        // draw my sin elipse
        for(Point2D.Double p : cosPoints){
            Shape point = new Ellipse2D.Double(p.getX(), p.getY(), DOT_SIZE, DOT_SIZE);
            g2cos.draw(point);
        }

    }

    private void sinDraw(Graphics2D g2sin){
        g2sin.setColor(Color.RED);
        // draw my sin elipse
        for(Point2D.Double p : sinPoints) {
            Shape point = new Ellipse2D.Double(p.getX(), p.getY(), DOT_SIZE, DOT_SIZE);
            g2sin.draw(point);
        }

    }

    private void addCosPoints(){
        double angle = - Math.PI + 2 * Math.PI * (( x - MARGIN )/( WIDTH - 11 * MARGIN));//angle in radians
        double newY = cosY + AMPLITUDE  * Math.cos(angle);
        cosPoints.add(new Point2D.Double(x, newY));
        x += dX;
        if(x >= WIDTH - MARGIN) {
            timer.stop();
        }
        repaint();
    }

    private void addSinPoints() {
        double angle = - Math.PI + 2 * Math.PI * (( x - MARGIN )/( WIDTH - 11 * MARGIN));//angle in radians
        double newY = sinY + AMPLITUDE  * Math.sin(angle);
        sinPoints.add(new Point2D.Double(x, newY));
        x += dX;
        if(x >= WIDTH - MARGIN) {
            timer.stop();
        }
        repaint();
    }

    private void drawX(Graphics g){
        g.drawLine(0, 240, 640, 240); // x
    }

    private void drawY(Graphics g){
        g.drawLine(40, 480, 40, 0); // y
    }

    private void drawValuesX(Graphics g){
        final int value = 45;
        int position = 45;

        for(int i = 1; i < 13; ++i){
            g.drawString(String.valueOf(i), position += value, 250);
        }
    }   

    private void drawValuesY(Graphics g){
        final int value = 50;
        int position = 0;

        for(int i = 4; i > -5; --i){
            if(i == 0) g.drawString(String.valueOf(i), 32, position += value);
            else g.drawString(String.valueOf(i), 30, position += value);
        }
    }

}
