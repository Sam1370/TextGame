package sam1370.textgame;

public class Exit {
	// Numerical codes
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST = 3;
	public static final int WEST = 4;
	public static final int UP = 5;
	public static final int DOWN = 6;
	public static final int NORTHEAST = 7;
	public static final int NORTHWEST = 8;
	public static final int SOUTHEAST = 9;
	public static final int SOUTHWEST = 10;
	public static final int IN = 11;
	public static final int OUT = 12;
	public static final String[] dirName = { "UNDEFINED", "NORTH", "SOUTH", "EAST", "WEST", "UP", "DOWN", "NORTHEAST",
			"NORTHWEST", "SOUTHEAST", "SOUTHWEST", "IN", "OUT" };

	public static final String[] shortDirName = { "NULL", "N", "S", "E", "W", "U", "D", "NE", "NW", "SE", "SW", "I",
			"O" };

	private Room leadsTo = null;
	private int direction;

	// Full name of direction
	private String directionName;

	// Shortened version of direction
	private String shortDirectionName;

	// Default constructor
	public Exit() {
		direction = Exit.UNDEFINED;
		leadsTo = null;
		directionName = dirName[0];
		shortDirectionName = shortDirName[0];
	}

	// Full constructor
	public Exit(int direction, Room leadsTo) {
		this.direction = direction;
		if (direction <= dirName.length) {
			directionName = dirName[this.direction];
		}
		if (direction <= shortDirName.length) {
			this.shortDirectionName = shortDirName[this.direction];
		}
		
		// Assign location
		this.leadsTo = leadsTo;
	}
	
	@Override
	public String toString() {
		return directionName;
	}
	
	public void setDirectionName(String dirName) {
		directionName = dirName;
	}
	
	public String getDirectionName() {
		return directionName;
	}
	
	public void setShortDirectionName(String shortName) {
		shortDirectionName = shortName;
	}
	
	public String getShortDirectionName() {
		return shortDirectionName;
	}
	
	public void setLeadsTo(Room leadsTo) {
		this.leadsTo = leadsTo;
	}
	
	public Room getLeadsTo() {
		return leadsTo;
	}
}
