import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackToMenu extends JFrame {
	public BackToMenu() {
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/background.jpg")));
		add(background);
		JButton backtomenu=new JButton("Back to Menu");
		background.add(backtomenu);
		
		
		backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu=new Menu();
				menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menu.setSize(400,400);
				menu.setVisible(true);
			}
		});
		
	}	
		

}
