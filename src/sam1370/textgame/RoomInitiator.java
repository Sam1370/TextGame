package sam1370.textgame;

import java.util.ArrayList;
import java.util.List;

class RoomInitiator {
	public static List<Room> rooms = new ArrayList<Room>();
	
	public static void registerRoom(Room room) {
		rooms.add(room);
	}
}
