import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
public class GameManager {
    private JFrame frame;
    private Snake panel;

    public GameManager(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new Snake();
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(500,500));
        
        frame.add(panel);
        

        frame.pack();
        frame.addKeyListener(panel); // IMPORTANT: do not forget to add keylistener to the frame. do it anyhow.
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GameManager();
    }
}
