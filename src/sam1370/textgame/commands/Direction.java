package sam1370.textgame.commands;

import sam1370.textgame.*;

public class Direction implements MultiCommand {

	@Override
	public String[] getCommands() {
		return null;
	}

	@Override
	public String getName() {
		return "Direction";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Enter in one of the cardinal directions to go somewhere.";
	}

	@Override
	public Integer argsNeeded() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCommand(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
