package sam1370.textgame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CommandInitiator {
	public static List<CommandListener> listeners = new ArrayList<CommandListener>();

	public static void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			String inputFieldText = GameWindow.getInputFieldText();
			Utils.println(inputFieldText);
			StringBuilder fieldTextStrBuild = new StringBuilder(inputFieldText);
			fieldTextStrBuild.delete(0, 2);
			String fieldTextStr = fieldTextStrBuild.toString();
			String[] fieldTextSplit = fieldTextStr.split(Pattern.quote(" "));
			String cmdName = fieldTextSplit[0];
			String[] cmdArgs = shiftArray(fieldTextSplit);
			boolean unknownCommand = true;
			for (CommandListener cl : listeners) {
				if (identifyCommand(cmdName, cl)) {
					unknownCommand = false;
					if (!cl.argsNeeded().equals(cmdArgs.length)) {
						Utils.println("Wrong number of arguments! Usage: " + cl.getUsage());
						GameWindow.resetInputField();
						return;
					}
					cl.onCommand(cmdArgs);
				}
			}
			if (unknownCommand == true) {
				Utils.println("Unknown command. Type \"help\" for a list of commands.");
			}
			GameWindow.resetInputField();
		}
	}

	public static boolean identifyCommand(String identification, CommandListener cl) {
		boolean identified = false;
		if (cl.getCommand().equalsIgnoreCase(identification)) {
			identified = true;
		}
		for (String alias : cl.getAliases()) {
			if (alias.equalsIgnoreCase(identification)) {
				identified = true;
			}
		}
		return identified;
	}

	public static String[] shiftArray(String[] array) {
		String[] arrayNew = new String[array.length - 1];
		for (int i = 1; i < array.length; i++) {
			String arr = array[i];
			arrayNew[i - 1] = arr;
		}
		return arrayNew;
	}

	public static void registerListener(CommandListener listener) {
		listeners.add(listener);
	}
}
