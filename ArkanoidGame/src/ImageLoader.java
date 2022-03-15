
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageLoader extends JPanel{

		private java.awt.Image background;
		  private ImageIcon myBackgroundIcon; 
		  public ImageLoader(String fileName) throws IOException {
			myBackgroundIcon=new ImageIcon(getClass().getResource(fileName));
			
		    background =myBackgroundIcon.getImage(); 
		  }
		
		  public void paintComponent(Graphics g) {
		    super.paintComponents(g);
		    g.drawImage(background, 0, 0, null);
		  }
		  
	}
