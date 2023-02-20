import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Apple extends JLabel {
    private Image image;
    private Snake snake;
    private int x;
    private int y;
    public Apple(String filename){
        
        this.setIcon(new ImageIcon(filename));
        this.setPreferredSize(new Dimension(25,25));
        this.setBackground(Color.red);
        this.setOpaque(true);
        
        
    }
    public void Eaten(){
        
    }
    public void handleEaten() {
    }

}
