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

    private static final double WIDTH = 640, HEIGHT = 480, AMPLITUDE = HEIGHT / 3;
    private static final int MARGIN = 32, DOT_SIZE = 2, SPEED = 10;

    private double x = MARGIN;
    private final double y = HEIGHT / 2;
    private final int dX = 1;


    private final List<Point2D.Double> points;
    private final Timer timer;

    public GraphLine(){
        setPreferredSize(new Dimension((int) WIDTH, (int) HEIGHT));
        points = new ArrayList<>();
        timer = new Timer(SPEED, e -> addPoints()); 
        timer.start();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

 
        g2.setColor(Color.RED);
        // draw my sin elipse
        for(Point2D.Double p : points){
            Shape point = new Ellipse2D.Double(p.getX(), p.getY(), DOT_SIZE, DOT_SIZE);
            g2.draw(point);
        }
        // draw x and y line
        drawX(g);
        drawY(g);
  
        // set graph color
        g.setColor(Color.BLUE);
        // set value in x and y
        drawValuesX(g);
        drawValuesY(g); 


    
    }

    private void addPoints() {

        double angle = - Math.PI + 2 * Math.PI * ((x-MARGIN)/(WIDTH - 2 * MARGIN));//angle in radians
        double newY = y + AMPLITUDE  * Math.sin(angle);
        points.add(new Point2D.Double(x, newY));
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

    /*
    g.drawLine(30, 432, 40, 432); 
      g.drawLine(30, 384, 40, 384); 
      g.drawLine(30, 336, 40, 336); 
      g.drawLine(30, 288, 40, 288); 

      g.drawLine(30, 192, 40, 192); 
      g.drawLine(30, 144, 40, 144); 
      g.drawLine(30, 96, 40, 96); 
      g.drawLine(30, 48, 40, 48); 
    
    */

}
