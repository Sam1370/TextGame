package sam1370.textgame;

public interface MultiCommand {
	String[] getCommands();
	
	String getName();
	
	String getDescription();
	
	default String getUsage() {
	    StringBuilder usageBuild = new StringBuilder();
	    for (String cmdName : getCommands()) {
		usageBuild.append(cmdName + ", ");
	    }
	    usageBuild.delete(usageBuild.length() - 2, usageBuild.length());
	    return usageBuild.toString();
	}

	Integer argsNeeded();

	void onCommand(String multiCmdName, String[] args);
}
