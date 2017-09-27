package sam1370.textgame.listeners;

import java.util.List;

import sam1370.textgame.*;

public class Help implements CommandListener {

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
		String[] aliases = { "helpme" };
		return aliases;
	}

	@Override
	public void onCommand(String[] args) {
		Utils.println("--[ Help ]--");
		Utils.println("Format: command | description");
		Utils.println("Aliases are not listed here");
		Utils.println();
		List<CommandListener> listeners = CommandInitiator.listeners;
		for (CommandListener cl : listeners) {
			Utils.println(cl.getUsage() + " | " + cl.getDescription());
		}
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
