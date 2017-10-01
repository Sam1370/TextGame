package sam1370.textgame.commands;

import sam1370.textgame.*;

public class ExitCommand implements Command {

	@Override
	public String getCommand() {
		return "exit";
	}

	@Override
	public String getDescription() {
		return "Exit the game";
	}

	@Override
	public String[] getAliases() {
		String[] aliases = { "systemexit", "byebye", "bye" };
		return aliases;
	}

	@Override
	public void onCommand(String[] args) {
		Program.g.windowClosing(null);
		Program.g.windowClosed(null);
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
