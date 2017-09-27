package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Fullscreen implements CommandListener {

	@Override
	public String getCommand() {
		return "fullscreen";
	}

	@Override
	public String getDescription() {
		return "Make this game fullscreen";
	}

	@Override
	public String[] getAliases() {
		String[] aliases = { "fullscr", "fullscreen" };
		return aliases;
	}

	@Override
	public void onCommand(String[] args) {
		GameWindow.fullscreen();
	}

	@Override
	public String getUsage() {
		return getCommand();
	}

	@Override
	public Integer argsNeeded() {
		return 0;
	}

}
