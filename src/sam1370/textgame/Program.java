package sam1370.textgame;

import sam1370.textgame.commands.*;

public class Program {
	public static GameWindow g;

	void start() {
		g = new GameWindow();
		registerListeners();
		println("Welcome to a text game.");
		println();
		main();
	}

	private void registerListeners() {
		registerCommand(new Help());
		registerCommand(new Info());
		registerCommand(new ExitCommand());
		registerCommand(new Getaliases());
		registerCommand(new Fullscreen());
		registerCommand(new Look());
		registerCommand(new Ock());
		
		registerMultiCommand(new Direction());
		
		Room defaultRoom = new Room("Default Room", "The world waits for your command.");
		setRoom(defaultRoom);
	}
	
	private void setRoom(Room r) {
		Player.setRoom(r);
	}
	
	private void registerMultiCommand(MultiCommand multiCommand) {
	    CommandInitiator.registerMultiCommand(multiCommand);
	}
	
	private void registerCommand(Command command) {
		CommandInitiator.registerCommand(command);
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
	/*
	 * private void playSound(String filePath) { try { File auFile = new
	 * File(filePath); AudioInputStream audioInputStream =
	 * AudioSystem.getAudioInputStream(auFile); Clip clip =
	 * AudioSystem.getClip(); clip.open(audioInputStream); clip.start(); } catch
	 * (Exception ex) { Utils.println("Error playing sound.");
	 * ex.printStackTrace(); } }
	 */
}
