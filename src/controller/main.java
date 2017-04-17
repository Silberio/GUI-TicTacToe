package controller;

import view.MainFrame;
import view.WelcomeScreen;
import model.BoardSpace;

public class main {

	public static void main(String[] args) {

		GameInit game = new GameInit();

		// Initiates a game board with user-selected amount of spaces
		game.gameInit();

	}
}