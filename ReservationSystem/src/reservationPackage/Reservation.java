package reservationPackage;

public class Reservation {

	private String name;
	private String group;
	private Boolean occupency;
	
	public Reservation(String name, String group) {
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
	public void bookSeat(String inputName, String inputGroup) {
		name = inputName;
		group = inputGroup;
		occupency = true;
	}
	public void unBook() {
		name = "";
		group = "";
		occupency = false;
	}
	public String quickDesignation() {
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

