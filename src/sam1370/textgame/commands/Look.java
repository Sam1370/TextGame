package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Look implements Command {

	@Override
	public String getCommand() {
		return "look";
	}

	@Override
	public String getDescription() {
		return "Look around and retrieve information";
	}

	@Override
	public String[] getAliases() {
		String[] aliases = { "lookaround", "see" };
		return aliases;
	}

	@Override
	public void onCommand(String[] args) {
		Utils.println(Game.currentRoom.getName());
		Utils.println(Game.currentRoom.getLook());
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
