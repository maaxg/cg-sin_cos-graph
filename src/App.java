import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Sin and Cos");
        CreatePanel();

    }
    public static void CreatePanel(){
        JFrame jframe = new JFrame("Sin and Cos");
        GraphLine graphLine = new GraphLine();
       
        jframe.add(graphLine);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jframe.setSize(640, 480);

        jframe.setVisible(true);

    }

}
