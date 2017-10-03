package sam1370.textgame.commands;

import sam1370.textgame.*;

public class Direction implements MultiCommand {

	@Override
	public String[] getCommands() {
	    	String[] commands = Utils.concat(Utils.shiftArray(Exit.dirName), Utils.shiftArray(Exit.shortDirName));
		return commands;
	}

	@Override
	public String getName() {
		return "Direction";
	}

	@Override
	public String getDescription() {
		return "Enter in one of the cardinal directions to go somewhere.";
	}

	@Override
	public Integer argsNeeded() {
		return 0;
	}

	@Override
	public void onCommand(String multiCmdName, String[] args) {
		
	}

}
