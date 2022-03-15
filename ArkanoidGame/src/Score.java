import javax.swing.JLabel;
import javax.swing.JTextField;

public class Score extends JLabel {
	private JLabel label=new JLabel();
	private  JTextField name;
	
	public Score() {
		label.setBounds(10,20,80,20);
	
		name=new JTextField("Enter name:");
	}
}

