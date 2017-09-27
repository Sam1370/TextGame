package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Info implements CommandListener {

	@Override
	public String getCommand() {
		return "info";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Retrieve information about this game";
	}

	@Override
	public void enterPress() {
		Utils.println("This TextGame was created by an 11-year-old kid named Sam with an"
				+ " online name of Sam1370. Hope you enjoy the game!");
	}

}
