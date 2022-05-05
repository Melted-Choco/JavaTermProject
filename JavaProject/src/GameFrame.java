import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	int f_pos_x; // frame position
	int f_pos_y;
	int f_width; // frame size
	int f_height;
	
	GameManager gameManager;
	Toolkit tk = Toolkit.getDefaultToolkit(); // get info. from local platform
	
	GameFrame(GameManager gameManager) { // constructor
		init(gameManager);
		mainFrame();
		setPanel();
	}
	
	public void mainFrame() {
		setTitle("Ground Conquer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(f_width, f_height);
		getContentPane().setBackground(Color.black);
		
		Dimension screen = tk.getScreenSize(); // get screen size of local platform
		f_pos_x = (int)(screen.getWidth() / 2 - f_width / 2); // set position of game frame 
		f_pos_y = (int)(screen.getHeight() / 2 - f_height / 2);
		
		setLocation(f_pos_x, f_pos_y);
		setResizable(false);
		setVisible(true);
	}
	
	public void setPanel() {
		
	}
	
	public void init(GameManager gameManager) { // initialize
		this.gameManager = gameManager;		
		f_width = 800;
		f_height = 600;
	}
	
	class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
		}
	}
}
