package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Gluttonick implements EnterListener {

	@Override
	public String getCommand() {
		return "gluttonick";
	}

	@Override
	public void enterPress() {
		Utils.println("YOU GLUTTONICK!");
	}

	@Override
	public String getDescription() {
		return "Silly gluttonick thing";
	}

}
