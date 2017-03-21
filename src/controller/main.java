package controller;

import view.MainFrame;
import view.WelcomeScreen;
import model.BoardSpace;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		WelcomeScreen screen = new WelcomeScreen();
//		screen.inputBoardSize();
//		
//		BoardMechanics game = new BoardMechanics();
//		game.initGameboard();
//		game.drawBoard();
		
		GameInit game = new GameInit();
		game.addButtonsToFrame();
		game.initMainFrame();
	}

}
