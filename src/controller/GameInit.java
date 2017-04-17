package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.BoardSpace;
import model.PlayerMarker;
import model.PlayerObject;
import view.MainFrame;
import view.WelcomeScreen;
import view.WinScreen;

public class GameInit implements Game {

	private WelcomeScreen welcomeScreen = new WelcomeScreen();

	public GameInit() {

	}

	public void gameInit() {
		initPlayers();

		welcomeScreen.inputBoardSize();
		setButtons(welcomeScreen.getButtons());
		boardSizeListeners();
	}

	/*
	 * THIS ENTIRE PART INITIALIZES GAME BOARD
	 * 
	 * in method gameInit it does the following: from WelcomeScreen, it sets the
	 * size of the board
	 * 
	 * size of the board is decided by setRowColValue method it changes the
	 * values of row and col thru a switch statement
	 * 
	 * the switch statement takes boardSizeOption from whatever player selected
	 * in the window inputBoardSize
	 * 
	 * it den selects the correct rowColValue inserts it onto setBoardsize which
	 * initializes a window with the selected amount of spaces thru an
	 * eventlistener
	 */

	/*
	 * INITIALIZATION FOR PLAYERS AND VICTORY CONDITIONS
	 */
	private PlayerObject playerOne, playerTwo, victorPlayer;
	private String input;
	private int players = 1;
	private boolean gameRunning = true;
	WinScreen win = new WinScreen();
	/*
	 * INITIALIZATION FOR MAINFRAME AND MAIN GAME WINDOW
	 */
	private static GameMechanics mechanics = GameMechanics.getInstance();
	private MainFrame mainFrame = new MainFrame();
	private int row, col;
	private JButton buttons[];
	// used on size selection
	private int boardSizeOption;

	// this function takes rows n cols from welcome screen
	public void setRowColValue() {
		int i = getBoardSizeOption();

		switch (i) {
		case 0:
			setBoardSize(3, 3);
			break;
		case 1:
			setBoardSize(4, 4);
			break;
		case 2:
			setBoardSize(5, 5);
			break;
		}
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	// This is actionlisteners for welcome screen buttons
	public void boardSizeListeners() {
		// This adds events to the buttons so they initialize with
		// set amount of rows and cols
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBoardSizeOption(0);
				initMainFrame();
				welcomeScreen.closeWindow();
			}
		});

		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBoardSizeOption(1);
				initMainFrame();
				welcomeScreen.closeWindow();
			}
		});

		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBoardSizeOption(2);
				initMainFrame();
				welcomeScreen.closeWindow();
			}
		});
	}

	public int getBoardSizeOption() {
		return boardSizeOption;
	}

	public void setBoardSizeOption(int boardSizeOption) {
		this.boardSizeOption = boardSizeOption;
	}

	public void setBoardSize(int row, int col) {
		this.row = row;
		this.col = col;
	}

	// this puts the values from setBoardSize into mainFrame size
	public void initMainFrame() {
		setRowColValue();
		addButtonsToFrame();
		mechanics.getBoardMarkers(this.row, this.col);
		mainFrame.MainFrameInit(this.row, this.col);
	}


	// creates a space in the gameboard for each row and col available
	public BoardSpace createBoardSpace(int row, int col) {

		BoardSpace btn = new BoardSpace(null);
		btn.setRow(row);
		btn.setCol(col);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setTitle("-| Three in row |-| " + mechanics.getCurrentPlayer().getName() + "'s Turn |-");
				move(btn.getRow(), btn.getCol());
				btn.setText(changeTextOnButton(btn));
				btn.setEnabled(false);
				mechanics.setSpaceMarker(btn);
				mechanics.changePlayer();
				mechanics.updateInternalBoard();
				mechanics.checkWinner(boardSizeOption);
				getMessage();
			}
		});
		
		
		return btn;
	}

	// returns the value of BoardSpace text as a string to put into
	// internal board in GameMechanics. this is to check what marker
	// is in the selected space.
	public String createInternalBoardspace(int row, int col) {
		BoardSpace btn = new BoardSpace(null);
		btn.setRow(row);
		btn.setCol(col);

		String msg = btn.getText();

		return msg;
	}

	// changes text on a spaceboard button. row n col are for coordinate storing
	public String changeTextOnButton(BoardSpace btn) {
		int row = btn.getRow();
		int col = btn.getCol();
		move(row, col);
		String marker = setMarkerOnButton();

		return marker;
	}

	// grabs player marker variable from a player and returns it as a
	// PlayerMarker
	// it also stores the coordinate of said space as a string for use in win
	// check
	public String setMarkerOnButton() {
		PlayerObject currentPlayer = mechanics.getCurrentPlayer();

		PlayerMarker markerToString = currentPlayer.getMarker();
		String msg = markerToString.toString();

		return msg;
	}

	// this adds the gameboard spaces
	public void addButtonsToFrame() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mainFrame.add(createBoardSpace(i, j));
				mechanics.setInternalBoardButtons(createInternalBoardspace(i, j));
			}
		}
	}

	// from class Game
	@Override
	public boolean move(int i, int j) {
		mechanics.setMoveCoords(i, j);
		return false;
	}

	@Override
	public String getStatus(int i, int j) {
	
		return null;
	}

	@Override
	public String getMessage() {

		if (mechanics.exportWinner().equals(playerOne.toString())) {
			gameRunning = false;
			victorPlayer = playerOne;
			victoryScreen();
		} else if (mechanics.exportWinner().equals(playerTwo.toString())) {
			gameRunning = false;
			victorPlayer = playerTwo;
			victoryScreen();
			mainFrame.closeWindow();
		} else if (mechanics.exportWinner().equals("DRAW")) {
			gameRunning = false;
			drawScreen();
		}
		return null;
	}

	/*
	 * <<<< END GAMEBOARD INITIALIZATION >>>>
	 */

	// ########################################################

	/*
	 * THIS PART INITIALIZES PLAYERS AS WELL AS PERTINENT POP UP WINDOWS
	 */

	// initializes two players with given parameters
	public void initPlayers() {

		while (players < 2) {

			switch (players) {
			case 1:
				input = userInputToVariable();
				playerOne = createPlayers(input, players, PlayerMarker.X);
				mechanics.setPlayerOne(playerOne);

			case 2:
				input = userInputToVariable();
				playerTwo = createPlayers(input, players, PlayerMarker.O);
				mechanics.setPlayerTwo(playerTwo);
			}
			players++;
		}
		mechanics.setCurrentPlayer(playerOne);
	}

	// pops up a window asking for player name
	public String userInputToVariable() {
		input = welcomeScreen.playerNameWindows();
		return input;
	}

	// creates a player object
	public PlayerObject createPlayers(String input, int playerNo, PlayerMarker playerMarker) {
		PlayerObject player = new PlayerObject(input, playerNo, playerMarker);

		return player;
	}
	
	//sets up buttons and listeners
	public void setVictoryScreenButtons() {
		win.getAgainButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.closeWindow();
				win.closeWindow();
				resetGame();
				initMainFrame();
			}
		});
		win.getQuitButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void drawScreen() {
		win.setUpVictorScreen();
		win.playerWinsMessage("DRAW");
		setVictoryScreenButtons();
		
	}

	// this window shows up when either player wins or draw is declared
	public void victoryScreen() {
		win.setUpVictorScreen();
		win.playerWinsMessage(victorPlayer.getName());
		setVictoryScreenButtons();
	}
	
	private boolean newGameValue;

	public boolean getNewGameValue() {
		return newGameValue;
	}

	public void setNewGameValue(boolean b) {
		newGameValue = b;
	}
	
	//Reset all game values for new game
	public void resetGame() {
		mainFrame = new MainFrame();
		mechanics = GameMechanics.getInstance();
		win = new WinScreen();
		mechanics.resetMoveCount();
		
	}
	// END OF FILE
}
