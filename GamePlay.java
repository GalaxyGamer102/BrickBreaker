import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

   private int score = 0;
   private int totalBricks = 48;
   private int playerX = 310;
   private int ballPosX = 120;
   private int ballPosY = 350;
   private int ballXdir = -1;
   private int ballYdir = -2;
   private boolean play = false;
   private boolean pause = false;
   private MapGenerator map;
   private Timer timer;
   private int delay = 8;

   public GamePlay(){
      map = new MapGenerator(4,12);
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
      timer = new Timer(delay,this);
      timer.start();
   }

   public void paint(Graphics g){
      //background
      g.setColor(Color.black);
      g.fillRect(1,1,692,592);
      
      //drawing map
      map.draw((Graphics2D) g);

      //Setting Borders
      g.setColor(Color.cyan);
      g.fillRect(0, 0, 3, 592);
      g.fillRect(0, 0, 692, 3);
      g.fillRect(691, 0, 3, 592);

      //Score
      g.setColor(Color.white);
      g.setFont(new Font("serif", Font.BOLD, 25));
      g.drawString("" + score, 590, 30);

      //Paddle
      g.setColor(Color.cyan);
      g.fillRect(playerX, 550, 100, 8);

      //The Ball
      g.setColor(Color.green);
      g.fillOval(ballPosX, ballPosY, 20, 20);

      if(totalBricks <= 0){
         play = false;
         ballXdir = 0;
         ballYdir = 0;

         g.setColor(Color.white);
         g.setFont(new Font("serif", Font.BOLD, 30));
         g.drawString("You Won :D!!!", 260, 300);

         g.setColor(Color.red);
         g.setFont(new Font("serif", Font.BOLD, 30));
         g.drawString("You should Press (ENTER) to Restart... NOW!", 230, 350);
      }

      if(ballPosY > 570) {
         play = false;
         ballXdir = 0;
         ballYdir = 0;

         g.setColor(Color.red);
         g.setFont(new Font("serif", Font.BOLD, 30));
         g.drawString("Game Over, Score: " + score, 190, 300);

         g.setColor(Color.red);
         g.setFont(new Font("serif", Font.BOLD, 30));
         g.drawString("You should Press (ENTER) to Restart... NOW!", 230, 350);
      }
   }

   @Override
   public void keyPressed(KeyEvent event){
      if (e.getKeyCode() == KeyEvent.VK_SPACE) {
         play = false;
         pause = true;
      }
   
      if(e.getKeyCode() == KeyEvent.VK_RIGHT){
         pause = false;
         if(playerX >= 600){
            playerX = 600;
         }
         else{
            moveRight();
         }
      }
      if(e.getKeyCode() == KeyEvent.VK_LEFT){
         pause = false;

      }


   @Override
   public void keyReleased(KeyEvent e){
     
   }

   @Override
   public void keyTyped(KeyEvent event){

   }

   public void moveRight(){
      play = true;
      playerX +=20;
   }

   public void moveLeft(){
      play = true;
      playerX -=20;
   }
   public void actionPerformed(ActionEvent event){

   }

}