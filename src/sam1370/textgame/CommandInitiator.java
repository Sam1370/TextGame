package sam1370.textgame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CommandInitiator {
	public static List<Command> commands = new ArrayList<Command>();
	public static List<MultiCommand> multiCommands = new ArrayList<MultiCommand>();

	public static void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			String inputFieldText = GameWindow.getInputFieldText();
			if (inputFieldText.length() == 2) {
			    return;
			}
			Utils.println(inputFieldText);
			StringBuilder fieldTextStrBuild = new StringBuilder(inputFieldText);
			fieldTextStrBuild.delete(0, 2);
			String fieldTextStr = fieldTextStrBuild.toString();
			String[] fieldTextSplit = fieldTextStr.split(Pattern.quote(" "));
			String cmdName = fieldTextSplit[0];
			String[] cmdArgs = Utils.shiftArray(fieldTextSplit);
			boolean unknownCommand = true;
			for (Command cl : commands) {
				if (identifyCommand(cmdName, cl)) {
					unknownCommand = false;
					if (checkArgs(cl, cmdArgs)) {
					    return;
					}
					cl.onCommand(cmdArgs);
				}
			}
			for (MultiCommand mcl : multiCommands) {
			    Object[] multiCommandIdentified = identifyMultiCommand(cmdName, mcl);
			    boolean identified = Boolean.valueOf(multiCommandIdentified[0].toString());
			    String name = multiCommandIdentified[1].toString();
			    if (identified) {
				unknownCommand = false;
				if (checkArgs(mcl, cmdArgs)) {
				    return;
				}
				mcl.onCommand(name, cmdArgs);
			    }
			}
			if (unknownCommand == true) {
				Utils.println("Unknown command. Type \"help\" for a list of commands.");
			}
			GameWindow.resetInputField();
		}
	}
	
	private static boolean checkArgs(Command cl, String[] cmdArgs) {
	    if (cl instanceof CommandBypassesArgs) {
		return false;
	    }
	    if (cl.argsNeeded().equals(cmdArgs.length)) {
		argStuff(cl.getUsage());
		return false;
	    }
	    return true;
	}
	
	private static void argStuff(String usage) {
	    Utils.println("Wrong number of arguments! Usage: " + usage);
	    GameWindow.resetInputField();
	}
	
	private static boolean checkArgs(MultiCommand ml, String[] cmdArgs) {
	    if (ml.argsNeeded().equals(cmdArgs.length)) {
		argStuff(ml.getUsage());
		return true;
	    }
	    return false;
	}
	
	public static boolean identifyCommand(String identification, Command cl) {
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
	
	public static Object[] identifyMultiCommand(String identification, MultiCommand mcl) {
	    Object[] identifiedAndCmd = { false, null };
	    for (String name : mcl.getCommands()) {
		if (name.equalsIgnoreCase(identification)) {
		    identifiedAndCmd[0] = true;
		    identifiedAndCmd[1] = name;
		}
	    }
	    return identifiedAndCmd;
	}

	public static void registerCommand(Command command) {
		commands.add(command);
	}
	
	public static void registerMultiCommand(MultiCommand multiCommand) {
	    multiCommands.add(multiCommand);
	}
	
	
}
