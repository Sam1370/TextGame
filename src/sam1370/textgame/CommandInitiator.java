package sam1370.textgame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CommandInitiator {
	public static List<CommandListener> listeners = new ArrayList<CommandListener>();
	public static void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		    	String inputFieldText = GameWindow.getInputFieldText();
		    	Utils.println(inputFieldText);
			StringBuilder fieldTextStrBuild = new StringBuilder(inputFieldText);
			fieldTextStrBuild.delete(0, 2);
			String fieldTextFinal = fieldTextStrBuild.toString();
			boolean unknownCommand = true;
			for (CommandListener el : listeners) {
				if (fieldTextFinal.equalsIgnoreCase(el.getCommand())) {
				    	unknownCommand = false;
					el.enterPress();
				}
			}
			if (unknownCommand == true) {
			    Utils.println("Unknown command. Type \"help\" for a list of commands.");
			}
			GameWindow.resetInputField();
		}
	}
	public static void registerListener(CommandListener listener) {
		listeners.add(listener);
	}
}
