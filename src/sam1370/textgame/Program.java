package sam1370.textgame;

import sam1370.textgame.listeners.*;
/* import java.io.File;
import javax.sound.sampled.*; */

public class Program {
	void start() {
		new GameWindow();
		registerListeners();
		println("Welcome to a text game.");
		println();
		main();
	}
	
	private void registerListeners() {
		registerListener(new Help());
		registerListener(new Info());
		registerListener(new Gluttonick());
	}
	
	private void registerListener(EnterListener listener) {
		EnterInitiator.registerListener(listener);
	}

	private void main() {
		println("Type \"help\" for a list of commands.");
	}
	

	private void println() {
		Utils.println();
	}

	public void print(String text) {
		Utils.print(text);
	}

	public void println(String text) {
		Utils.println(text);
	}

	public void registerEnterListener() {
		
	}
	/*
	 * private void playSound(String filePath) { try { File auFile = new
	 * File(filePath); AudioInputStream audioInputStream =
	 * AudioSystem.getAudioInputStream(auFile); Clip clip =
	 * AudioSystem.getClip(); clip.open(audioInputStream); clip.start(); } catch
	 * (Exception ex) { Utils.println("Error playing sound.");
	 * ex.printStackTrace(); } }
	 */
}
