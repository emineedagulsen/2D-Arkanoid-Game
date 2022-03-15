import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Game extends JPanel implements ActionListener,KeyListener, Runnable {

	private int XPaddle = 350;
	private int XBall = 50;
	private int YBall= 50;
	private int speedX=1;
	private int speedY=1;
	private int lives=3;
	private int score=0;
	private int level=1;
	private int total=20;
	private int x=80,x1=80,x2=80, x3=80 ,x4=80,x5=80, x6=80, x7=80,x8=80,x9=80;
	private int y=30, y1=30,y2=30,y3=30,y4=30,y5=30,y6=30 ,y7=30,y8=30, y9=30;
	private int a=80,a1=80,a2=80,a3=80,a4=80,a5=80,a6=80,a7=80,a8=80,a9=80;
	private int b=30,b1=30,b2=30,b3=30,b4=30,b5=30,b6=30,b7=30,b8=30,b9=30;
	private int k=80,k1=80,k2=80, k3=80 ,k4=80,k5=80, k6=80, k7=80,k8=80,k9=80;
	private int l=30,l1=30,l2=30,l3=30,l4=30,l5=30,l6=30,l7=30,l8=30,l9=30;
	
	private boolean game=true;
	
	public void MoveBall() { 
		game=true;
		XBall+=speedX;
		YBall+=speedY;
		if(XBall<0)
			speedX=-speedX;
		if(XBall>770)
			speedX=-speedX;
		if(YBall<0)
			speedY=-speedY;	
		
		
	}
	public void CollisionPaddleBall() {
		game=true;
	    Rectangle paddle=new Rectangle(XPaddle,600,200,30);
		Rectangle ball=new Rectangle(XBall,YBall,20,20);
		if(ball.intersects(paddle))
				speedY=-speedY;	
	}
	

	public void MoveLeft(){
		game=true;
		if(XPaddle<101)//duvarýn kenarýndan çýkmamasý için
			XPaddle=101;
		XPaddle-=100;//hareket hýzý gibi bir þey
		
	}
	
	
	
	public void MoveRight() {
		game=true;
		if(XPaddle>494)
			XPaddle=494;
		XPaddle+=100;
	}	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//clear drawing area
		g.setColor(Color.black);
		g.fillRect(0, 0, 900, 900);
		//
		g.setColor(Color.blue);
		g.fillRect(XPaddle,600,190,27);
		//
		g.setColor(Color.white);
		g.fillOval(XBall,YBall,20,20);
		//
		if(total!=10) {
			g.setColor(Color.red);
			g.fillRect(120, 90, x, y);
			g.fillRect(220, 90, x1, y1);
			g.fillRect(320, 90, x2, y2);
			g.fillRect(420, 90, x3, y3);
			g.fillRect(520, 90, x4, y4);
			g.fillRect(120, 180, x5, y5);
			g.fillRect(220, 180, x6, y6);
			g.fillRect(320, 180, x7, y7);
			g.fillRect(420, 180, x8, y8);
			g.fillRect(520, 180, x9, y9);
			
		}
		if(total==10)  {
			g.setColor(Color.orange);
			g.fillRect(120, 90, a ,b);
			g.fillRect(220, 90, a1, b1);
			g.fillRect(320, 90, a2, b2);
			g.fillRect(120, 180,a5, b5);

			
			g.setColor(Color.red);
			g.fillRect(420, 90, a3, b3);
			g.fillRect(520, 90, a4, b4);
			g.fillRect(220, 180, a6, b6);
			g.fillRect(320, 180, a7, b7);
			g.fillRect(420, 180, a8, b8);
			g.fillRect(520, 180, a9, b9);
					
			level=2;
		
		}
		if(score>=240) {
			g.setColor(Color.GREEN);
			g.fillRect(120, 90, k,l);
			g.fillRect(220, 90, k1,l1);
			g.fillRect(320, 90, k2, l2);
			
			g.setColor(Color.red);
			g.fillRect(420, 90, k3, l3);
			g.fillRect(520, 90, k4, l4);
			g.fillRect(120, 180, k5, l5);
			g.fillRect(220, 180, k6, l6);
			
			g.setColor(Color.orange);
			
			g.fillRect(320, 180, k7,l7);
			g.fillRect(420, 180, k8, l8);
			g.fillRect(520, 180, k9, l9);
		
		
			level=3;
		}
			
		
		//
		g.setColor(Color.white);
		Font f1 = new Font("Arial", Font.ROMAN_BASELINE, 20);
		g.setFont(f1);
		g.drawString("Score:"+score, 0, 20);
		//
		Font f2 = new Font("Arial", Font.ROMAN_BASELINE, 20);
		g.setFont(f2);
		g.drawString("Lives:"+lives, 700, 20);
		//
		Font f3 = new Font("Arial", Font.ROMAN_BASELINE, 20);
		g.setFont(f3);
		g.drawString("Level:"+level, 290, 20);
		//
		if((YBall>700)&&(score!=460))  {
			game=false;
			Font f6 = new Font("Arial", Font.ROMAN_BASELINE, 20);
			g.setFont(f6);
			g.drawString("CLÝCK SPACE TO RESTART", 250, 350);
			
			
			
		}
		if((lives==0)&&(score!=460)) {
			
			Font f5 = new Font("Arial", Font.ROMAN_BASELINE, 20);
			g.setFont(f5);
			g.drawString("GAME OVER", 350, 350);
			
			//System.exit(0);
		}
		if(score==460) {
			
			Font f6 = new Font("Arial", Font.ROMAN_BASELINE, 20);
			g.setFont(f6);
			g.drawString("YOU WIN", 350, 350);
			
			//System.exit(0);
		}
		
		//
	}	
	
	
	public void Level1() {
		
		Rectangle ball=new Rectangle(XBall,YBall,20,20);
		Rectangle brick1=new Rectangle(120, 90,x,y);
		Rectangle brick2=new Rectangle(220, 90,x1,y1);
		Rectangle brick3=new Rectangle(320, 90,x2,y2);
		Rectangle brick4=new Rectangle(420, 90,x3,y3);
		Rectangle brick5=new Rectangle(520, 90,x4,y4);
		Rectangle brick6=new Rectangle(120, 180,x5,y5);
		Rectangle brick7=new Rectangle(220, 180,x6,y6);
		Rectangle brick8=new Rectangle(320, 180,x7,y7);
		Rectangle brick9=new Rectangle(420, 180,x8,y8);
		Rectangle brick10=new Rectangle(520, 180,x9,y9);
		if(brick1.intersects(ball)) {
			Sound("hit.wav",1);
			x=0;
			y=0;
			speedY=-speedY;
			total--;
			score+=10;
		}
		
		
		if(brick2.intersects(ball)) {
			Sound("hit.wav",1);
			x1=0;
			y1=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick3.intersects(ball)) {
			Sound("hit.wav",1);
			x2=0;
			y2=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick4.intersects(ball)) {
			Sound("hit.wav",1);
			x3=y3=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick5.intersects(ball)) {
			Sound("hit.wav",1);
			x4=y4=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick6.intersects(ball)) {
			Sound("hit.wav",1);
			x5=y5=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick7.intersects(ball)) {
			Sound("hit.wav",1);
			x6=y6=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick8.intersects(ball)) {
			Sound("hit.wav",1);
			x7=y7=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick9.intersects(ball)) {
			Sound("hit.wav",1);
			x8=y8=0;
			speedY=-speedY;
			score+=10;
			total--;
		}
		if(brick10.intersects(ball)) {
			Sound("hit.wav",1);
			x9=y9=0;
			speedY=-speedY;
			score+=10;
			total--;
		}	
	
	}
		
	
	public void Level2() {
		
		Rectangle ball=new Rectangle(XBall,YBall,20,20);
		Rectangle brick1=new Rectangle(120, 90,a,b);
		Rectangle brick2=new Rectangle(220, 90,a1,b1);
		Rectangle brick3=new Rectangle(320, 90,a2,b2);
		Rectangle brick4=new Rectangle(420, 90,a3,b3);
		Rectangle brick5=new Rectangle(520, 90,a4,b4);
		Rectangle brick6=new Rectangle(120, 180,a5,b5);
		Rectangle brick7=new Rectangle(220, 180,a6,b6);
		Rectangle brick8=new Rectangle(320, 180,a7,b7);
		Rectangle brick9=new Rectangle(420, 180,a8,b8);
		Rectangle brick10=new Rectangle(520, 180,a9,b9);
	
		if(brick1.intersects(ball)) {
			Sound("hit.wav",1);
				a-=20;
				b-=20;
				speedY=-speedY;
				score+=10;
				
		}
		
		
		
		if(brick2.intersects(ball)) {
			Sound("hit.wav",1);
				a1-=20;
				b1-=20;
				speedY=-speedY;		
				score+=10;
				
		}
		
		
		if(brick3.intersects(ball)) {
			Sound("hit.wav",1);
			a2-=20;
			b2-=20;
			speedY=-speedY;		
			score+=10;
		}
		
		if(brick4.intersects(ball)) {
			Sound("hit.wav",1);
			a3=0;
			b3=0;
			speedY=-speedY;		
			score+=10;
			
		}
		
		if(brick5.intersects(ball)) {
			Sound("hit.wav",1);

			a4=0;
			b4=0;
			speedY=-speedY;		
			score+=10;
			
		}
		
		if(brick6.intersects(ball)) {
			Sound("hit.wav",1);

			a5-=20;
			b5-=20;
			speedY=-speedY;
			score+=10;
			
			
		}
		
		if(brick7.intersects(ball)) {
			Sound("hit.wav",1);

			a6=b6=0;
			speedY=-speedY;
			score+=10;
			
				
		}
		
		if(brick8.intersects(ball)) {
			Sound("hit.wav",1);

			a7=0;
			b7=0;
			speedY=-speedY;
			score+=10;
			
		}
		
		if(brick9.intersects(ball)) {
			Sound("hit.wav",1);

			a8=b8=0;
			speedY=-speedY;
			score+=10;
			
		}
		
		if(brick10.intersects(ball)) {
			Sound("hit.wav",1);

			a9=0;
			b9=0;
			speedY=-speedY;
			score+=10;	
		}
	
	}
public void Level3() {
	
		
		Rectangle ball=new Rectangle(XBall,YBall,20,20);
		Rectangle brick1=new Rectangle(120, 90,k,l);
		Rectangle brick2=new Rectangle(220, 90,k1,l1);
		Rectangle brick3=new Rectangle(320, 90,k2,l2);
		Rectangle brick4=new Rectangle(420, 90,k3,l3);
		Rectangle brick5=new Rectangle(520, 90,k4,l4);
		Rectangle brick6=new Rectangle(120, 180,k5,l5);
		Rectangle brick7=new Rectangle(220, 180,k6,l6);
		Rectangle brick8=new Rectangle(320, 180,k7,l7);
		Rectangle brick9=new Rectangle(420, 180,k8,l8);
		Rectangle brick10=new Rectangle(520, 180,k9,l9);
		if(brick1.intersects(ball)) {
			Sound("hit.wav",1);
			k-=10;
			l-=10;
			speedY=-speedY;
			score+=10;
			
		}
		if(brick2.intersects(ball)) {
			Sound("hit.wav",1);
			k1-=10;
			l1-=10;
			speedY=-speedY;		
			score+=10;
				
		}
		
		
		if(brick3.intersects(ball)) {
			Sound("hit.wav",1);
			k2-=10;
			l2-=10;
			speedY=-speedY;		
			score+=10;
		}
		
		if(brick4.intersects(ball)) {
			Sound("hit.wav",1);
			k3-=10;
			l3-=10;
			speedY=-speedY;		
			score+=10;
			
		}
		
		if(brick5.intersects(ball)) {
			Sound("hit.wav",1);
			k4=0;
			l4=0;
			speedY=-speedY;		
			score+=10;
			
		}
		
		if(brick6.intersects(ball)) {
			Sound("hit.wav",1);
			k5=0;
			l5=0;
			speedY=-speedY;
			score+=10;
			
			
		}
		
		if(brick7.intersects(ball)) {
			Sound("hit.wav",1);
			k6=l6=0;
			speedY=-speedY;
			score+=10;
			
				
		}
		
		if(brick8.intersects(ball)) {
			Sound("hit.wav",1);
			k7-=20;
			l7-=20;
			speedY=-speedY;
			score+=10;
			
		}
		
		if(brick9.intersects(ball)) {
			Sound("hit.wav",1);
			k8-=20;
			l8-=20;
			speedY=-speedY;
			score+=10;
			
		}
		
		if(brick10.intersects(ball)) {
			Sound("hit.wav",1);
			k9-=10;
			l9-=10;
			speedY=-speedY;
			score+=10;	
		}
	
	}


	
	public void restart() {
		game=false;
		level=1;
		XPaddle = 350;
		XBall = 50;
		YBall= 50;
		speedX=1;
		speedY=1;
		
		Level1();
		
		if(total==10) {
			Level2();
		}
		if(score>=240)
			Level3();
		
		
	}
		
				
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String whichKey=KeyEvent.getKeyText(e.getKeyCode());	
		if(whichKey.compareTo("Left")==0){
			
			MoveLeft();
		}
		else if(whichKey.compareTo("Right")==0){	
			
			MoveRight();
		}
		else if(whichKey.compareTo("Space")==0){
			
				restart();
				lives--;
				
				
		
		}
		if((e.getKeyCode()==KeyEvent.VK_Q) && (e.getKeyCode()==KeyEvent.CTRL_MASK)!=true) {
			System.exit(0);
		}
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void run() {
		
		while (true) {
			Level1();
			if(total==10) {
				for(int i=0;i<10;i++) 
					Level2();
			}
		
			if(score>=240) {
				for(int i=0;i<15;i++) {
					Level3();
				}
			}
					
			
			
			MoveBall();
			CollisionPaddleBall();
			
			repaint(); //refresh it on screen
			try {
				Thread.sleep(6);//bir süre program durur 
			} catch (InterruptedException e) {
			}

		}
		

	}

	public void Sound(String File, int times) {
		try {
		URL soundLocation = new URL(File);
		AudioInputStream audio = AudioSystem.getAudioInputStream(soundLocation);
		Clip clip = AudioSystem.getClip();
		clip.open(audio);
		clip.loop(times);
		clip.start();
		} catch(UnsupportedAudioFileException x) {
		} catch(IOException y) {
		} catch(LineUnavailableException z) {
		}
		}
		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	

}
		



	