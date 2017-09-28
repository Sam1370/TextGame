package sam1370.textgame;

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
		}
		else {
			newBoolean = true;
		}
		return newBoolean;
	}
}