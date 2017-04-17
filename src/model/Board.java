package model;

import java.util.ArrayList;

public class Board {
	private static int row, col;
	private static ArrayList[][] board = new ArrayList[row][col];
	
	public Board() {
		
	}
	public void setInternalBoardSize(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public static ArrayList[][] getInstance() {
		return board;
	}
}
