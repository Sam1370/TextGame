package sam1370.textgame;

// Contains information about the game
public class Game {
	public static Room currentRoom = null;
	
	public static void setRoom(Room r) {
	    currentRoom = r;
	}
}