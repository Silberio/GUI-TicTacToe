package controller;

import view.*;
import model.*;

public class GameInit implements Game {
	
	private MainFrame mainFrame = new MainFrame();
	private int row, col;
	
	public GameInit() {

	}
	
	public void setBoardSize(int row, int col){
		this.row = row;
		this.col = col;
	}

	public void initMainFrame() {
		mainFrame.MainFrameInit(3, 3);
	}

	public void addButtonsToFrame() {
		for (int i = 0; i < mainFrame.getrow(); i++) {
			for (int j = 0; j < mainFrame.getcol(); j++) {
				mainFrame.addSpace(new BoardSpace());
			}
		}
	}

	@Override
	public boolean move(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
