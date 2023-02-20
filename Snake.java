/**
 * Snake
 */
import java.util.Random;
 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Snake extends JPanel implements KeyListener {


    private int length;
    private int score = 0;
   
    private int AppleX;
    private int AppleY;

    private ArrayList <Integer> x = new ArrayList<Integer>();
    private ArrayList <Integer> y = new ArrayList<Integer>();

    private final int PANEL_WIDTH =  500;
    private final int PANEL_HEIGHT = 500;

    private final int APPLE_WIDTH = 25;
    private final int APPLE_HEIGHT = 25;

    private Timer timer;
    private Apple apple;
   
    private enum Direction {NORTH,SOUTH,WEST,EAST};
    private char directionLetter;
   
    public Snake(){
        
        x.add(PANEL_WIDTH / 2);
        y.add(PANEL_HEIGHT / 2);

        directionLetter = 'w';
        
        apple = new Apple("apple.jpeg");
        setApple();
        this.add(apple);
        timer = new Timer(1000,new ClickListener());
        timer.start();
    }

    public void setApple(){
        Random rand = new Random();
        AppleX = rand.nextInt(PANEL_WIDTH / 25) * 25;
        AppleY = rand.nextInt(PANEL_HEIGHT / 25) * 25;
        apple.setLocation(AppleX,AppleY);
        
    }

    public void move(){
        if(directionLetter == 'w')
        {
            y.add(y.get(y.size() - 1) - 25 );   
            x.add(x.get(x.size()-1));
        }
        else if(directionLetter == 'a')
        {
            x.add(x.get(x.size() - 1) - 25 );
            y.add(y.get(y.size() - 1));
        }
        else if(directionLetter == 's')
        {
            y.add(y.get(y.size() - 1) + 25 );
            x.add(x.get(x.size()-1));
        }
        else if(directionLetter == 'd')
        {
            x.add(x.get(x.size() - 1) + 25 );
            y.add(y.get(y.size() - 1));
        }
        //to be continued... border lines + not crossing into itself.
        if(!(AppleX + APPLE_WIDTH >= x.get(x.size()-1) && x.get(x.size()-1) + 25 > AppleX 
        &&
        AppleY + APPLE_WIDTH >= y.get(y.size()-1) && y.get(y.size()-1) + 25 > AppleY   ))
        { 
            x.remove(0);
            y.remove(0);
        }        
        else
        {
            eat();
        }
        repaint();
    }
    public void eat(){
        score++;
        setApple();
    }
    
    class ClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            move();
        }
    }
    

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            if(e.getKeyCode() == 37 || e.getKeyChar() == 'a')
            {
                directionLetter = 'a';
            }
            else if(e.getKeyCode() == 38 || e.getKeyChar() == 'w')
            {
                directionLetter = 'w';
            }
            else if(e.getKeyCode() == 39 || e.getKeyChar() == 'd')
            {
                directionLetter = 'd';
            }
            else if(e.getKeyCode() == 40 || e.getKeyChar() == 's')
            {
                directionLetter = 's';
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        
        
    }
    public void paint(Graphics g){
        
       
        Graphics2D g2d = (Graphics2D) g;
       /* */  g2d.setBackground(Color.black);
        super.paint(g2d);
        
        g2d.setPaint(Color.green);
        for(int i = 0; i < x.size();i++)
        {
            g2d.fillRect(x.get(i),y.get(i) ,25,25);
        }
       
    }   
    public static void main(String[] args) {
        new Snake();
    }
}