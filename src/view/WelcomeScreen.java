package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WelcomeScreen {

	// for message windows
	private String message;
	private String input;

	// for windows created in this class
	private JFrame frame = new JFrame("Select board size");
	private JPanel panel = new JPanel();
	private JButton btn;

	public WelcomeScreen() {

	}

	public void inputBoardSize() {
		frame.setSize(265, 300);
		frame.setLocation(50, 50);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(panel);
		
		panel.setLayout(new GridLayout());
		for (int i = 3; i < 3; i++) {
			panel.add(btn);
		}

	}

	public void questionWindow() {
		input = JOptionPane.showInputDialog("Player name?");
	}

	public void messageWindow() {
		JOptionPane.showMessageDialog(null, message);
	}

	// Predefined messages depending on game condition
	public String gameMessages(int condition) {
		switch (condition) {
		// test message
		case 1:
			message = "thank you " + input;
			break;
		case 2:
			message = "second message";
			break;
		default:
			message = "lolwat";
			break;
		}

		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
