package sam1370.textgame;

public interface Command {
	String getCommand();

	String getDescription();

	String[] getAliases();

	String getUsage();

	Integer argsNeeded();

	void onCommand(String[] args);
}
