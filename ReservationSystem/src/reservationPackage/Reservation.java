package reservationPackage;

public class Reservation {

	private String name;
	private String group;
	private Boolean occupency;
	
	public Reservation(String name, String group) {
		//Basic object constructor, used by the reservation array constructor
		this.name = name;
		this.group = group;
		this.occupency = false;
	}
	
	public void setName(String nameInput) {
		name = nameInput;
	}
	public void setGroup(String groupInput) {
		group = groupInput;
	}
	public String getName() {
		return name;
	}
	public String getGroup() {
		return group;
	}
	public void establish() {
		//System.out.println("Check 6");
		this.name = "";
		this.group = "";
		//occupency = false;
	}
	public Boolean checkSeat() {
		return occupency;
	}
	public void isOccupied() {
		occupency = true;
	}
	public void bookSeat(String inputName, String inputGroup) {
		//Generic function for booking the object
		name = inputName;
		group = inputGroup;
		occupency = true;
	}
	public void unBook() {
		//Returns the object to an ideal unbooked state
		name = "";
		group = "";
		occupency = false;
	}
	public String quickDesignation() {
		//Used for checkManifest methods
		if (name != "") {
			return name;
		}
		if (group != "") {
			return group;
		}
		else {
			return "Vacent";
		}
	}
}

