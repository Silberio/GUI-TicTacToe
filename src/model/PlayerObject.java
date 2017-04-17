package model;

public class PlayerObject {

	private String name;
	private int playerNo;
	private PlayerMarker marker;

	public PlayerObject(String name, int playerNo, PlayerMarker marker){
		
		this.marker = marker;
		this.name = name;
		this.playerNo = playerNo;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public PlayerMarker getMarker() {
		return marker;
	}

	public void setMarker(PlayerMarker marker) {
		this.marker = marker;
	}

	public String toString() {
		String mark = marker.toString();

		return mark;
	}

}
