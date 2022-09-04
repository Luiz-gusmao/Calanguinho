package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.Player;


public class GamePanel extends JPanel implements Runnable{

    //screen sttings

    final int originalTilsize = 90; //  JxJ tile size
    final int scale = 2;
    public final int tileSize = originalTilsize * scale;
    final int maxScreenCol = 10;
    final int maxScreenRow = 5;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int fps=60;


    //sets player anchors
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);



    public GamePanel(){
        //set screen
        this.setPreferredSize(new Dimension (screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
        public void startGameThread(){
            gameThread = new Thread(this);
            gameThread.start();

        }
    @Override
    public void run() {
        double drawInterval= 1000000000/fps;
        double delta=0;
        long lastTime= System.nanoTime();
        long currentTime;

        while (gameThread != null){

            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime=currentTime;

            if(delta >= 1 ){
                //update program
                update();
                //Image buffer
                repaint();
                delta--;
            }

        }

        
    }

    public void update(){

        player.update();

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }

}