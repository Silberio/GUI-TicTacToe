package model;

import java.util.Arrays;

public class Board {

	private static int row = 3;
	private static int col = 3;

	private String playerName;
	private int playerNumber;
	private char playerChar;

	private static PlayerObject player = new PlayerObject("tom", 2, PlayerMarker.O);
	private static PlayerObject[][] playerBoard = new PlayerObject[row][col];

	private static Board board = new Board();

	private Board() {
		
	}

	public static Board getInstance() {

		return board;
	}
	public PlayerObject[][] getBoard(){
		
		return playerBoard;
	}

}
