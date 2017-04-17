package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BoardSpace extends JButton{
	
	private int row, col;
	
	public BoardSpace(String text) {
		setFont(new Font("Arial", Font.PLAIN, 120));
		setBackground(Color.DARK_GRAY);
		setText(text);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}


}
