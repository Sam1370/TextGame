package sam1370.textgame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class EnterInitiator {
	public static List<EnterListener> listeners = new ArrayList<EnterListener>();
	public static void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		    	String inputFieldText = GameWindow.getInputFieldText();
		    	Utils.println(inputFieldText);
			StringBuilder fieldTextStrBuild = new StringBuilder(inputFieldText);
			fieldTextStrBuild.delete(0, 2);
			String fieldTextFinal = fieldTextStrBuild.toString();
			boolean unknownCommand = true;
			for (EnterListener el : listeners) {
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
	public static void registerListener(EnterListener listener) {
		listeners.add(listener);
	}
}
