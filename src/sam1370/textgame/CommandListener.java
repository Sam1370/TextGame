package sam1370.textgame;

public interface CommandListener {
	String getCommand();

	String getDescription();

	String[] getAliases();

	String getUsage();

	Integer argsNeeded();

	void onCommand(String[] args);
}
