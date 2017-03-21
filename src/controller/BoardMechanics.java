package controller;

import java.util.Arrays;

import model.Board;
import model.BoardSpace;
import model.PlayerMarker;
import model.PlayerObject;

public class BoardMechanics {

	// PLACEHOLDER initialized player object
	private PlayerObject player = new PlayerObject("tom", 2, PlayerMarker.O);

	private String playerName;
	private int playerNumber;
	private char playerChar;

	private int row = 3;
	private int col = 3;

	private Board board;

	public BoardMechanics() {
	}
	
	
	public void initGameboard(){
		 board = Board.getInstance();
	}

	// This is to be used for predetermined board sizes.
	// Method is to be called in general mechanics at GameINIT
	public void setBoardSize(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void drawBoard() {

		for (int i = 0; i < board.getBoard().length; i++) {
			for (int j = 0; j < board.getBoard().length; j++) {
				for (int k = 0; k < i; k++) {


					if (k == 3)
						System.out.println("\n");
					board.getBoard()[i][j] = player;
					System.out.println("[ " + board.getBoard()[i][j] + " ]");
				}

			}
		}

	}

	
}
