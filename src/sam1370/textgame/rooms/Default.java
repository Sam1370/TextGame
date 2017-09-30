package sam1370.textgame.rooms;

import sam1370.textgame.Room;

public class Default implements Room {

	@Override
	public String getName() {
		return "Default Room";
	}

	@Override
	public String getLook() {
		return "All around you there is void. The world is waiting for your command. Tell it to start. Do it.";
	}

}
