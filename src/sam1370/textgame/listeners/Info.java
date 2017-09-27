package sam1370.textgame.listeners;

import sam1370.textgame.*;

public class Info implements CommandListener {

    @Override
    public String getCommand() {
	return "info";
    }

    @Override
    public String getDescription() {
	return "Retrieve information about this game";
    }

    @Override
    public String[] getAliases() {
	String[] aliases = { "information", "info." };
	return aliases;
    }

    @Override
    public void onCommand(String[] args) {
	Utils.println("This TextGame was created by an 11-year-old kid named Sam with an"
		+ " online name of Sam1370. Hope you enjoy the game!");
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
