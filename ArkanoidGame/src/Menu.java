import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.GridLayout;

public class Menu extends JFrame {
	private int option;
	public void setOption(int option) {
		this.option=option;
	}
	public int getOption() {
		return option;
	}
	
	public Menu() {
		super("Arkanoid");
		JButton newgame=new JButton("New Game");
		JButton options=new JButton("Options");
		JButton scores=new JButton("Scores");
		JButton help=new JButton("Help");
		JButton about=new JButton("About");
		 JButton exit=new JButton("Exit");
		/////////image background///////
		final JLabel background = new JLabel(new ImageIcon(getClass().getResource("/background.jpg")));
		add(background);
		
			
			
			
		background.add(newgame);
		background.add(options);
		background.add(scores);
		background.add(help);
		background.add(about);
		background.add(exit);
		//frame.setLayout(new FlowLayout());
		background.setLayout(new GridLayout(6,6,20,30));
		background.setSize(300,300);
		background.setVisible(true);
			
		//small window for info in about button
		final JFrame frame1=new JFrame("About Developer");
		frame1.getContentPane().setBackground(Color.CYAN);
		final  JTextArea jTextArea = new JTextArea();
		jTextArea.setBackground(Color.CYAN);
		jTextArea.setSize(700,1000);
		jTextArea.setEditable(false);
		jTextArea.setText("Name:Emine Eda"+"\n"+"Surname:Gülþen"+"\n"+"School Number:20180702035"+"\n"+
		"Email:emineeda.gulsen@std.yeditepe.edu.tr");
		
		//for help
		final JFrame framee=new JFrame("Help");
		framee.getContentPane().setBackground(Color.pink);
		final  JTextArea text = new JTextArea();
		text.setBackground(Color.pink);
		text.setSize(700,700);
		text.setEditable(false);
		text.setText("Welcome the Arkanoid Game"+"\n"+"Press New Game button to start the game"+"\n"+
		"Press Exit button to exit the game"+"\n"+"Press Option button to choose level"+"\n"+"Game has 3 level:Level 1 has red bricks ,if you hit one time bricks break "+"\n"+
				"Level 2 has also red bricks which can break if you hit 2 times"+"\n"+"Level 3 has also green bricks which can break if you hit 3 times"+"\n"+"Press Score button to show score,name of player"+"\n"+"Press About button to know about developer");
		
			
	
		
			

		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							Sound("click.wav",1);
							try {
								final JFrame frame1 = new JFrame();
								Game game = new Game();
								frame1.setSize(800, 700);
								frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame1.add(game);
								frame1.setLocationRelativeTo(null);//ortalýyo
								frame1.setResizable(false);
								frame1.setVisible(true);
								game.addKeyListener(game);	
								game.setFocusable(true);
								new Thread(game).start();
								JButton exit2=new JButton("Exit");
								game.add(exit2);
								exit2.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										frame1.setVisible(false);
									}
									
								});
								
								//Sound mysound=new Sound();
								//mysound.play(1);
							} catch (Exception e1) {
								// TODO: handle exception
							}
					
							
						}
		});
		
			
		scores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				Sound("click.wav",1);
				JFrame frame = new JFrame();
				frame.setSize(400, 400);
				frame.setLayout(new GridLayout(5,5,4,4));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);//ortalýyo
				frame.setResizable(false);
				frame.setVisible(true);
				
			}
		});
		

			
			options.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					Sound("click.wav",1);
					final JFrame frame = new JFrame();
					frame.setSize(400, 400);
					frame.setLayout(new GridLayout(5,5,4,4));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);//ortalýyo
					frame.setResizable(false);
					frame.setVisible(true);
					final JButton level1=new JButton("Level 1");
					final JButton level2=new JButton("Level 2");
					final JButton level3=new JButton("Level 3");
					frame.add(level1);
					frame.add(level2);
					frame.add(level3);
					final JButton exit1=new JButton("Exit");
					frame.add(exit1);
					exit1.addActionListener(new ActionListener() {


						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							Sound("click.wav",1);
							frame.setVisible(false);
							
						}
						
					});
					level1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Sound("click.wav",1);
							// TODO Auto-generated method stub
							JFrame framegame=new JFrame();
							framegame.setSize(800, 700);
							framegame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							framegame.setLocationRelativeTo(null);//ortalýyo
							framegame.setResizable(false);
							framegame.setVisible(true);
							Game game = new Game();
							framegame.add(game);
							game.addKeyListener(game);	
							game.setFocusable(true);
							new Thread(game).start();
							frame.setVisible(false);
							framegame.setVisible(true);
							
							
						}
						
					});
					
				}
			});
			

			
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sound("click.wav",1);
					JOptionPane.showMessageDialog(null,"EXIT","Exit",JOptionPane.QUESTION_MESSAGE);
					System.exit(0);
				}
			});
		
			
			help.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sound("click.wav",1);
					framee.setLayout(new GridLayout(5,5,8,8) );
					framee.setSize(700,2000);
					framee.setVisible(true);
					framee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					framee.add(text);
					JButton exit3=new JButton("Exit");
					framee.add(exit3);
					exit3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							framee.setVisible(false);
							
						}
						
					});
					
					}
			});
			about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					Sound("click.wav",1);
					frame1.setLayout(new GridLayout(5,5,10,10) );
					frame1.setSize(400,500);
					frame1.setVisible(true);
					frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame1.add(jTextArea);
					JButton exit3=new JButton("Exit");
					frame1.add(exit3);
					exit3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							frame1.setVisible(false);
							
						}
						
					});
					
					}
				
			});
		
			
				
			

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
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
