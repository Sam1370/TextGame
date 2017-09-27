package sam1370.textgame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class EnterInitiator {
	public static List<EnterListener> listeners = new ArrayList<EnterListener>();
	public static void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			StringBuilder fieldTextStrBuild = new StringBuilder(GameWindow.getInputFieldText());
			fieldTextStrBuild.delete(0, 2);
			String fieldTextFinal = fieldTextStrBuild.toString();
			for (EnterListener el : listeners) {
				if (fieldTextFinal.equalsIgnoreCase(el.getCommand())) {
					Utils.println();
					el.enterPress();
				}
			}
			GameWindow.resetInputField();
		}
	}
	public static void registerListener(EnterListener listener) {
		listeners.add(listener);
	}
}
