package sam1370.textgame;

import java.util.Vector;

public class Room {
	private String roomTitle;
	private String roomDescription;
	private Vector<Exit> vecExits;

	// Blank constructor
	public Room() {
		assignVariables(null, null);
	}

	// Partial constructor
	public Room(String title) {
		assignVariables(title, null);
	}

	// Full constructor
	public Room(String title, String description) {
		assignVariables(title, description);
	}

	private void assignVariables(String title, String description) {
		if (title != null) {
			roomTitle = title;
		} else {
			roomTitle = new String();
		}
		if (description != null) {
			roomDescription = description;
		} else {
			roomDescription = new String();
		}
		vecExits = new Vector<Exit>();
	}

	@Override
	public String toString() {
		return roomTitle;
	}

	public void addExit(Exit exit) {
		vecExits.addElement(exit);
	}

	public void removeExit(Exit exit) {
		if (vecExits.contains(exit)) {
			vecExits.removeElement(exit);
		}
	}

	@SuppressWarnings("unchecked")
	public Vector<Exit> getExits() {
		return (Vector<Exit>) vecExits.clone();
	}

	public String getTitle() {
		return roomTitle;
	}

	public void setTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public String getDescription() {
		return roomDescription;
	}

	public void setDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
}
