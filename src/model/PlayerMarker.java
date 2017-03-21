package model;

public enum PlayerMarker {
	
	X('X'), 
	O('O');
	
	private final char MARK;
	
	private PlayerMarker(char MARK){
		this.MARK = MARK;
	}

}
