package sam1370.textgame;

// Contains information about the game
public class Player {
	private static Room currentRoom = null;
	
	public static Room getRoom() {
	    return currentRoom;
	}
	
	public static void setRoom(Room r) {
	    currentRoom = r;
	}
}