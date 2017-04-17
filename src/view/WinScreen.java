package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WinScreen extends JFrame {
	
	private JPanel panel = new JPanel(new BorderLayout());
	private JPanel selection = new JPanel();
	private JLabel label = new JLabel("lel");
	private JButton btnAgain, btnQuit;
	
	public WinScreen() {
		
	}
	
	public void setUpVictorScreen() {
		this.setTitle("-| VICTORY |-");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 500);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addEndSelection();
	}

	public void playerWinsMessage(String text) {
		add(panel);
		panel.add(selection, BorderLayout.SOUTH);
		panel.add(label, BorderLayout.NORTH);
		
		label.setFont(new Font("Serif", Font.HANGING_BASELINE, 64));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		if(text.equals("DRAW")) {
			label.setText("It's a draw!");
		} else
		label.setText(text + " Wins!");
		
		pack();
	}

	public void addEndSelection() {
		btnAgain = new JButton("Play Again?");
		btnAgain.setFont(new Font("Serif", Font.BOLD, 20));
		selection.add(btnAgain);
		
		// QUIT BUTTON
		btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Serif", Font.BOLD, 20));
		selection.add(btnQuit);		
	}

	public void closeWindow() {
		this.dispose();
	}
	
	public JButton getAgainButton() {
		return btnAgain;
	}

	public JButton getQuitButton() {
		return btnQuit;
	}
	
}
