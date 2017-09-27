package sam1370.textgame.listeners;

import java.util.List;

import sam1370.textgame.*;

public class Help implements EnterListener {

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
		List<EnterListener> listeners = EnterInitiator.listeners;
		for (EnterListener el : listeners) {
			Utils.println(el.getCommand() + " | " + el.getDescription());
		}
	}

}
