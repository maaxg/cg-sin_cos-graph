import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Draw bsier curves");
        CreatePanel();

    }
    public static void CreatePanel(){
        JFrame jframe = new JFrame("Exercício 2");
        GraphLine graphLine = new GraphLine();


        jframe.add(graphLine);
        jframe.setDefaultCloseOperation(3);

        jframe.setSize(640, 480);

        jframe.setVisible(true);

    }

}
