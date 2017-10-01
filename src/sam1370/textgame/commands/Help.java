package sam1370.textgame.commands;

import java.util.List;

import sam1370.textgame.*;

public class Help implements Command {

	@Override
	public String getCommand() {
		return "help";
	}

	@Override
	public String getDescription() {
		return "Prints this help message";
	}

	@Override
	public String[] getAliases() {
		String[] aliases = { "helpme", "hepl", "heplme" };
		return aliases;
	}

	@Override
	public void onCommand(String[] args) {
		Utils.println("Help - Commands");
		Utils.println("Format: command | description");
		Utils.println("Aliases are not listed here");
		Utils.println();
		List<Command> listeners = CommandInitiator.listeners;
		for (Command cl : listeners) {
			Utils.println(cl.getUsage() + " | " + cl.getDescription());
		}
		Utils.println("Help - Multi-commands");
		Utils.println("Multi-commands contain multiple commands that do very similar things."
				+ "that y");
		Utils.println("Format: multi-command name | description | commands, separated by commas");
		Utils.println();
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
