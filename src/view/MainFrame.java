package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private int row;
	private int col;
	
	public MainFrame(){
		
	}
	
	public void MainFrameInit(int row, int col){
		this.row=row;
		this.col=col;
		
		setTitle("Three in row");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setLocation(500, 200);
		setVisible(true);
		setResizable(false);
		setLayout(new GridLayout(row,col));
	}
	
	public void addSpace(JButton c){
				add(c);	

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
	
	

}
