package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private int row;
	private int col;
	private String turn = " ";
	private JPanel gamePanel;
	
	public MainFrame(){
		
	}
	
	public void MainFrameInit(int row, int col){
		this.setTitle("-| Three in row |-| " + turn + " |-");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650,650);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(new GridLayout(row,col));
		this.setLocationRelativeTo(null);
	}	
	
	
	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public int getrow() {
		return row;
	}

	public void setrow(int row) {
		this.row = row;
	}

	public int getcol() {
		return col;
	}

	public void setcol(int col) {
		this.col = col;
	}
	
	public void closeWindow() {
		this.dispose();
	}

}
