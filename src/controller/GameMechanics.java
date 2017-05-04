package controller;

import javax.swing.JList;

import model.BoardSpace;
import model.PlayerObject;

public class GameMechanics {

	public GameMechanics() {

	}

	private static GameMechanics mechanics = new GameMechanics();

	private PlayerObject playerOne, playerTwo;
	private PlayerObject currentPlayer = new PlayerObject(null, 4, null);

	public static GameMechanics getInstance() {
		return mechanics;
	}

	public PlayerObject changePlayer() {

		if (currentPlayer == playerOne) {
			currentPlayer = playerTwo;
		} else
			currentPlayer = playerOne;

		return currentPlayer;
	}
	

	/*
	 * ############################### 
	 * #### GETTERS N SETTERS ########
	 * ###############################
	 */
	public PlayerObject getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(PlayerObject playerOne) {
		this.playerOne = playerOne;
	}

	public PlayerObject getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(PlayerObject playerTwo) {
		this.playerTwo = playerTwo;
	}

	public PlayerObject getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(PlayerObject currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/*
	 * ############################### 
	 * ##### WIN / LOSS MECHANICS ####
	 * ###############################
	 *
	 */
	private int row, col;
	private String marker;
	private String winner;
	
	public void setMoveCoords(int i, int j) {
		this.row = i;
		this.col = j;
	}

	// public String getMoveCoords() {
	// String coord = ""+row+""+col;
	// return coord;
	// }


	public void setSpaceMarker(BoardSpace btn) {
		int row = btn.getRow();
		int col = btn.getCol();

		if (row == this.row && col == this.col) {
			this.marker = btn.getText();

		}
	}

	/*
	 * ###################################### 
	 * ####### ALGORITHMS FOR WIN ########### 
	 * ####### AND LOSS           ###########
	 * ######################################
	 */

	private int moveCount;
	private String[][] board;

	public String setInternalBoardButtons(String marker) {
		return marker;
	}

	// this recieves a row and a col value from GameInit
	// and puts it in its' respective place on the
	// internal board

	public void getBoardMarkers(int row, int col) {
		board = new String[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = " ";
			}
		}
	}

	// This sets up a virtual board of the game being played
	// it can print out a reflection of the GUI Array in the console
	public void updateInternalBoard() {
		if (board[row][col].equals(" ")) {
			board[row][col] = marker;			
		}
		moveCount++;

		// THIS PRINTS OUT A BOARD ON THE CONSOLE 
		//saved for future debugging
//		System.out.println("   NEW BOARD   ");
//		System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
//		System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
//		System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
//		System.out.println("   END BOARD   ");
	}

	// this picks up what size player chose from selection menu
	// and converts it into its' respective board size
	public void checkWinner(int size) {
		
		switch (size) {
		case 0:
			size = 3;
			break;
		case 1:
			size = 4;
			break;
		case 2:
			size = 5;
			break;
		}
		
		//win algorithms from https://stackoverflow.com/questions/1056316/algorithm-for-determining-tic-tac-toe-game-over
		// variables are adapted. couldn't find any more efficient way of doing it on my own
		winner = "0";
		
		// check col
		for (int i = 0; i < size; i++) {
			if (board[row][i] != marker)
				break;
			if (i == size - 1) {
				winner = marker;
			}
		}

		// check row
		for (int i = 0; i < size; i++) {
			if (board[i][col] != marker)
				break;
			if (i == size - 1) {
				winner = marker;
			}
		}

		// check diag
		if (row == col) {
			// we're on a diagonal
			for (int i = 0; i < size; i++) {
				if (board[i][i] != marker)
					break;
				if (i == size - 1) {
					winner = marker;
				}
			}
		}

		// check anti diag (thanks rampion)
		if (row + col == size - 1) {
			for (int i = 0; i < size; i++) {
				if (board[i][(size - 1) - i] != marker)
					break;
				if (i == size - 1) {
					winner = marker;
				}
			}
		}

		// check draw
		if (moveCount == (size * size)) {
			winner = "DRAW";
		}
	}
	
	public String exportWinner() {
		return winner;
	}
	
	public void resetMoveCount() {
		moveCount = 0;
	}
	
	public void checkVictoryCondition(boolean b) {
		System.out.println(b);
	}

} // END OF FILE
