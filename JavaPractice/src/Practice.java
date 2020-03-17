import javax.swing.*;
import java.awt.*;

public class Practice {
    JFrame f = new JFrame("Practice");
    JPanel panel = new JPanel();
    public Practice(){
        JToggleButton t = new JToggleButton("ON");
        t.addActionListener(actionEvent -> {
            if(t.isSelected())
                t.setText("OFF");
            else t.setText("on");
        });
        JButton b = new JButton("Hello");
        //b.setBounds(10,10,100,30);

        JMenuBar menuBar = new JMenuBar();
        JMenu c = new JMenu("File");
        JPasswordField p = new JPasswordField();
        p.setEchoChar('*');
        //p.setSize(new Dimension(200,20));
        f.add(b);
        f.add(p);
        f.add(t);
        //f.add(menuBar);
        menuBar.add(c);
        //f.setJMenuBar(menuBar);
        f.setSize(300,300);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Practice();
    }
}
