import javax.swing.*;

public class KBC extends JFrame{
    private JPanel mainScreen;
    private JTextField textField1;
    private JButton button1;

    public KBC() {
        button1.addActionListener(actionEvent -> {

        });
        add(mainScreen);
        setSize(400,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new KBC();
    }
}
