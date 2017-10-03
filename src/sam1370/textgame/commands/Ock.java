package sam1370.textgame.commands;

import sam1370.textgame.*;

public class Ock implements CommandBypassesArgs {

    @Override
    public String getCommand() {
	return "ock";
    }

    @Override
    public String getDescription() {
	return "Make every word after this command have OCK in it, then copy to clipboard!";
    }

    @Override
    public String[] getAliases() {
	String[] aliases =  { "makeock" };
	return aliases;
    }

    @Override
    public String getUsage() {
	return getCommand() + " <text>";
    }

    @Override
    public Integer argsNeeded() {
	return null;
    }

    @Override
    public void onCommand(String[] args) {
	if (args.length > 0) {
	    StringBuilder ocked = new StringBuilder();
		for (String arg : args) {
		    char[] argCharArray = arg.toCharArray();
		    char lastArgChar = argCharArray[argCharArray.length - 1];
		    if (Character.isUpperCase(lastArgChar)) {
			ocked.append(arg + "OCK ");
		    } else {
			ocked.append(arg + "ock ");
		    }
		}
		String ockedString = ocked.toString();
		Utils.println(ockedString);
		Utils.setClipboard(ockedString);
		Utils.println("Copied to clipboard!");
	} else {
	    Utils.println("Not enough arguments! Usage: " + getUsage());
	}
    }

}
