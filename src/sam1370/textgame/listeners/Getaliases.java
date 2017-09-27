package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Getaliases implements CommandListener {

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
	for (CommandListener cl : CommandInitiator.listeners) {
	    if (CommandInitiator.identifyCommand(args[0], cl)) {
		Utils.print(getCommand() + " aliases: ");
		    for (String alias : cl.getAliases()) {
			unknownCommand = false;
			Utils.print(alias + ", ");
		    }
	    }
	}
	if (unknownCommand == true) {
	    Utils.println();
	    Utils.println("Command not found.");
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
