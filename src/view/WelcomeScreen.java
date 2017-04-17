package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class WelcomeScreen {

	// for message windows
	private String message;
	private String input;

	// for windows created in this class
	private JFrame frame = new JFrame("Select board size");
	private JPanel panel = new JPanel(new BorderLayout());
	private JButton buttons[] = new JButton[3];
	
	public WelcomeScreen() {

	}

	/*
	 * WINDOWS PERTINENT TO BORD SIZE
	 */
	public void inputBoardSize() {
		initWelcomeButtons();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	
	
public JButton[] getButtons() {
		return buttons;
	}

public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	//	adds  buttons with board size options at startup
	// called in function inputBoardSize()
	public void initWelcomeButtons(){
		JPanel textPanel = new JPanel();
		JPanel btnPanel = new JPanel();


		textPanel.add(new JLabel("Choose board size: "));
		
		for(int i = 0; i < buttons.length; i++) {
			String btnText = "null";			
			JButton btn = new JButton(btnText);
			btn.setText(setSizeButtonText(i));
			buttons[i] = btn;
			btnPanel.add(buttons[i]);
		}
		
		panel.add(textPanel, BorderLayout.NORTH);	
		panel.add(btnPanel, BorderLayout.SOUTH);
		
	}


	//sets label for the JButton size selection
	public String setSizeButtonText(int i){
		String btnText = "null";
		
		switch(i){
		case 0:
			btnText = "3x3 Board";
			break;
		case 1:
			btnText = "4x4 Board";
			break;
		case 2:
			btnText = "5x5 Board";
			break;
		default:
			btnText = "NOT FOUND";
			break;
		}
		return btnText;
	}
	
/*
 * 	WINDOWS PERTINENT TO PLAYER INITIALIZATION
 */
	
	// input window that takes player name
	// when called, returns player name.
	public String playerNameWindows() {
		String input = JOptionPane.showInputDialog("Player name?");
		return input; 
	}

	public void closeWindow() {
		frame.dispose();
	}
}

