package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Getaliases implements Command {

	@Override
	public String getCommand() {
		return "getaliases";
	}

	@Override
	public String getDescription() {
		return "Get the alias of a specific command.";
	}

	@Override
	public String[] getAliases() {
		String[] aliases = { "galiases", "getalias", "getaliase", "getaliass" };
		return aliases;
	}

	@Override
	public void onCommand(String[] args) {
		boolean unknownCommand = true;
		for (Command cl : CommandInitiator.listeners) {
			if (CommandInitiator.identifyCommand(args[0], cl)) {
				Utils.print("Aliases of " + getCommand() + ": ");
				for (int i = 0; i < cl.getAliases().length; i++) {
					String alias = cl.getAliases()[i];
					unknownCommand = false;
					Utils.print(alias + (!(i + 1 < cl.getAliases().length) ? "" : ", "));
				}
			}
		}
		if (unknownCommand == true) {
			Utils.println("Command not found.");
		} else {
			Utils.println();
		}
	}

	@Override
	public String getUsage() {
		return "getaliases <command>";
	}

	@Override
	public Integer argsNeeded() {
		return 1;
	}

}
