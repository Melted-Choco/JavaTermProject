import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
	int f_pos_x; // frame position
	int f_pos_y;
	int f_width; // frame size
	int f_height;
	
	Toolkit tk = Toolkit.getDefaultToolkit(); // get info. from local platform
	
	GameFrame() { // constructor
		init();
		
		setTitle("Ground Conquer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(f_width, f_height);
		
		Dimension screen = tk.getScreenSize(); // get screen size of local platform
		f_pos_x = (int)(screen.getWidth() / 2 - f_width / 2); // set position of game frame 
		f_pos_y = (int)(screen.getHeight() / 2 - f_height / 2);
		
		setLocation(f_pos_x, f_pos_y);
		setResizable(false);
		setVisible(true);
	}
	
	public void init() { // initialize
		f_width = 800;
		f_height = 600;
	}
}
