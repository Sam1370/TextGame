package sam1370.textgame;

public interface MultiCommand {
	String[] getCommands();
	
	String getName();
	
	String getDescription();

	Integer argsNeeded();

	void onCommand(String[] args);
}
