import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
class MouseAdapterExample extends MouseAdapter{
    JFrame f = new JFrame();
    int count=0;
    MouseAdapterExample(){
        f.setTitle("Swing App");
        JButton b = new JButton("Click Me!!");
        b.setBounds(200,50,200,20);
        JLabel l = new JLabel();
        JTextArea area = new JTextArea(20,20);
        JScrollPane scrollTextArea = new JScrollPane(area);
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,40,10);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                l.setText("value of slider" + slider.getValue());
            }
        });
        //slider.setBounds(20,50,400,400);
        l.setForeground(Color.GREEN);
        l.setFont(new Font("Serif", Font.BOLD,12));
        l.setBounds(20,50,200,20);
        scrollTextArea.setBounds(20,80,300,300);
        f.addMouseListener(this);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;
                l.setText("count"+count);
            }
        });
        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = area.getText();
                String word[]= text.split("\\s");
                l.setText("words: "+word.length+" Characters: "+text.length());
            }
        });
        f.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g=f.getGraphics();
                g.setColor(Color.BLUE);
                g.drawLine(e.getX(),e.getY(),30,30);
            }
        });
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.add(l);f.add(b);
        f.add(slider);
        f.add(scrollTextArea);
        f.setResizable(false);
        f.pack();
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g=f.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(e.getX(),e.getY(),30,30);
    }


    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}