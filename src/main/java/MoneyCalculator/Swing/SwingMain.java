package MoneyCalculator.Swing;

import javax.swing.*;
import java.awt.*;

public class SwingMain extends JFrame {

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        main.setVisible(true);
    }
    public SwingMain() throws HeadlessException {
        setTitle("Money Calculator");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
    }
}
