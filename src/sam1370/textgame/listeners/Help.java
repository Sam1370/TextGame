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
	public void enterPress() {
		Utils.println("--[ Help ]--");
		Utils.println("Format: command | description");
		Utils.println();
		List<CommandListener> listeners = CommandInitiator.listeners;
		for (CommandListener cl : listeners) {
			Utils.println(cl.getCommand() + " | " + cl.getDescription());
		}
	}

}
