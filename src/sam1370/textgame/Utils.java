package sam1370.textgame;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Utils {
	public static void println(Object o) {
		GameWindow.setCaretPosition();
		System.out.println(o);
	}

	public static void println() {
		GameWindow.setCaretPosition();
		System.out.println();
	}

	public static void print(Object o) {
		GameWindow.setCaretPosition();
		System.out.print(o);
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static boolean opposite(boolean toBeTransformed) {
		boolean newBoolean = toBeTransformed;
		if (newBoolean == true) {
			newBoolean = false;
		} else {
			newBoolean = true;
		}
		return newBoolean;
	}
	
	public static String[] shiftArray(String[] array) {
		String[] arrayNew = new String[array.length - 1];
		for (int i = 1; i < array.length; i++) {
			String arr = array[i];
			arrayNew[i - 1] = arr;
		}
		return arrayNew;
	}
	
	public static String[] concat(String[] first, String[] second) {
	        int length = first.length + second.length;
	        String[] result = new String[length];
	        System.arraycopy(first, 0, result, 0, first.length);
	        System.arraycopy(second, 0, result, first.length, second.length);
	        return result;
	    }
	
	public static void setClipboard(String contents) {
	    StringSelection stringSelection = new StringSelection(contents);
	    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clpbrd.setContents(stringSelection, null);
	}
}