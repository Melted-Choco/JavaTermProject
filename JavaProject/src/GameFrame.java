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
	
	JPanel panel_1;
	JPanel panel_2;
	JButton btn_gameStart;
	JButton btn_closePanel;
	JLabel label_title;
	
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
		getContentPane().setBackground(Color.red);
		
		Dimension screen = tk.getScreenSize(); // get screen size of local platform
		f_pos_x = (int)(screen.getWidth() / 2 - f_width / 2); // set position of game frame 
		f_pos_y = (int)(screen.getHeight() / 2 - f_height / 2);
		
		setLocation(f_pos_x, f_pos_y);
		setResizable(false);
		setVisible(true);
	}
	
	public void setPanel() {
		panel_1.setBackground(Color.cyan); // background color
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, f_width, f_width);
		
		btn_gameStart.setBounds((f_width / 2) - 50, 400, 100, 50);
		btn_gameStart.setActionCommand("Start");
		btn_gameStart.addActionListener(new ButtonClickListener());
		
		label_title.setBounds((f_width / 2) - 100, 100, 200, 50); // label position
		label_title.setHorizontalAlignment(JLabel.CENTER); // text alignment
		label_title.setVerticalAlignment(JLabel.CENTER);
		label_title.setFont(label_title.getFont().deriveFont(15.0f)); // text size
		
		panel_1.add(label_title);
		panel_1.add(btn_gameStart);
		
		
		panel_2.setBackground(Color.green);
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, f_width, f_height);
		
		btn_closePanel.setBounds(0, 0, 50, 50);
		btn_closePanel.setActionCommand("Close");
		btn_closePanel.addActionListener(new ButtonClickListener());
		
		panel_2.add(btn_closePanel);
		panel_2.setVisible(false);
		
		add(panel_2);
		add(panel_1);
	}
	
	public void init(GameManager gameManager) { // initialize
		this.gameManager = gameManager;		
		f_width = 800;
		f_height = 600;
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		btn_gameStart = new JButton("Game Start");
		btn_closePanel = new JButton("X");
		label_title = new JLabel("Ground Conquer");
	}
	
	class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if (command.equals("Start")) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			} else if (command.equals("Close")) {
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		}
	}
}
