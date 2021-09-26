import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Sin and Cos");
        CreatePanel();

    }
    public static void CreatePanel(){
        JFrame jframe = new JFrame("Sin and Cos");
        GraphLine graphLine = new GraphLine();
       
        jframe.add(graphLine);
        jframe.setDefaultCloseOperation(3);

        jframe.setSize(640, 480);

        jframe.setVisible(true);

    }

}
