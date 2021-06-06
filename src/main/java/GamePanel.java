import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_Height = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNIT = (SCREEN_WIDTH*SCREEN_Height)/UNIT_SIZE;
    static final int DELAY = 75;

    final int x[] = new int[GAME_UNIT];
    final int y[] = new int[GAME_UNIT];


    int bodyParts = 6;
    int applesEaten = 6;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;



    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_Height) );
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        for(int i= 0; i<SCREEN_Height/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_Height);
            g.drawLine(0,i*UNIT_SIZE, SCREEN_WIDTH,i*UNIT_SIZE);
        }
        g.setColor(Color.RED);
        g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
    }

    public void newApple(){
            appleX = random.nextInt((int) (SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
            appleY = random.nextInt((int) (SCREEN_Height/UNIT_SIZE))*UNIT_SIZE;

    }

    public void move(){
        for(int i = bodyParts; i>0;i--){
            x[i] = x[i-1];
            x[i] = y[i-1];

        }
//        switch (direction){
//            case
//        }
    }

    public void checkApple(){


    }

    public void checkCollisions(){

    }

    public void gameOver(Graphics g){

    }


    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
