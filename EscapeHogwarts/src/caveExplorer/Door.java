package caveExplorer;

public class Door {

	private boolean locked;
	private boolean open;
	private String description;
	private String details;
	private boolean roomH;
	
	public Door(String des, boolean npcR) {
		locked = false;
		open = true;
		description = des;
		roomH = npcR;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public  String getDescription() {
		return description;
	}
	
	public boolean getRoom()
	{
		return roomH;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}