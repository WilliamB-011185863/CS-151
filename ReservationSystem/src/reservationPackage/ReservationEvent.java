package reservationPackage;

import java.util.ArrayList;

public class ReservationEvent {

	private static Reservation[][] firstClass;
	private static Reservation[][] economyClass;
	
	public static void airlineConstructor() {
		//System.out.println("Check 1");
		firstClass = new Reservation[2][4];
		//System.out.println("Check 3");
		for (int i = 0; i < 2; i++) {
			//System.out.println("Check 4");
			for (int j = 0; j < 4; j++) {
				//System.out.println("Check 5");
				firstClass[i][j] = new Reservation("","");//.establish() = new Reservation(); 
			}
		}
		economyClass = new Reservation[20][6];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				economyClass[i][j] = new Reservation("","");//.establish(); 
			}
		}
		//System.out.println("Check 2");
	}
	
	public static Reservation getSeatByName(String nameToSeek) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (nameToSeek == firstClass[i][j].getName()) {
					return firstClass[i][j];//convertSeatId(i, j)
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				if (nameToSeek == economyClass[i][j].getName()) {
					return economyClass[i][j];//convertSeatId(i, j)
				}
			}
		}
		System.out.println("Request failed, no entry '" + nameToSeek + "' found.");
		return null;
	}
	
	public String getSeatByGroup(String groupToSeek) { //need to return multiple
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (groupToSeek == firstClass[i][j].getName()) {
					return convertSeatId(i, j);
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				if (groupToSeek == economyClass[i][j].getName()) {
					return convertSeatId(i, j);
				}
			}
		}
		return ("No match found");
	}
	
	private static String convertSeatId(int i, int j) {
		i++;
		j++;
		String altJ;
		if (j == 1) {
			altJ = "A";
		}
		else if (j == 2) {
			altJ = "B";
		}
		else if (j == 3) {
			altJ = "C";
		}
		else if (j == 4) {
			altJ = "D";
		}
		else if (j == 5) {
			altJ = "E";
		}
		else if (j == 6) {
			altJ = "F";
		}
		else {
			altJ = "Z";
		}
		return (i + altJ);
	}
	
	public void bookFirstClassSeat(int i, int j, String name, String group) {
		i--;
		j--;
		firstClass[i][j].bookSeat(name, group);
	}
	public void bookEconomyClassSeat(int i, int j, String name, String group) {
		i--;
		j--;
		economyClass[i][j].bookSeat(name, group);
	}
	
	public static void checkFirstClassManifest() {
		
		for (int i = 0; i < 2; i++) {
			System.out.print("First     ");
			for (int j = 0; j < 4; j++) {
				System.out.print(convertSeatId(i, j) + ": " + firstClass[i][j].quickDesignation() + "    ");
			}
			System.out.println();
		}
	}
	
	public static void checkEconomyClassManifest() {
		for (int i = 0; i < 20; i++) {
			System.out.print("Economy     ");
			for (int j = 0; j < 6; j++) {
				System.out.print(convertSeatId(i, j) + ": " + economyClass[i][j].quickDesignation() + "    ");
			}
			System.out.println();
		}
	}
	
	public static String jToLetter(int j) {
		j++;
		String altI;
		if (j == 1) {
			altI = "A";
		}
		else if (j == 2) {
			altI = "B";
		}
		else if (j == 3) {
			altI = "C";
		}
		else if (j == 4) {
			altI = "D";
		}
		else if (j == 5) {
			altI = "E";
		}
		else if (j == 6) {
			altI = "F";
		}
		else {
			altI = "Z";
		}
		return altI;
	}
	
	public void printFirstClassSeating() { //First 1: B, D  2: C, D
		System.out.print("First ");
		int k = 0; //Counter for "None"
		for (int i = 0; i < 2; i++) {
			System.out.print(i++ + ": ");
			for (int j = 0; j < 4; j++) {
				if (firstClass[i][j].quickDesignation() == "Vacent") {
					System.out.print(jToLetter(j));
					if (firstClass[i][j+1].quickDesignation() == "Vacent") {
						System.out.print(", ");
					}
				}
				
			}
			System.out.print("   ");
		}
	}  
	
	public static void printEconomyClassSeating() { //First 1: B, D  2: C, D
		System.out.print("Economy ");
		//int k = 0; //Counter for "None"
		for (int i = 0; i < 20; i++) {
			System.out.print((i + 1) + ": ");
			for (int j = 0; j < 6; j++) {
				if (economyClass[i][j].quickDesignation() == "Vacent") {
					System.out.print(jToLetter(j));
					if (j != 5) {//(economyClass[i][j+1].quickDesignation().equals("Vacent")) {
						System.out.print(", ");
					}
				}
				
			}
			System.out.print("   ");
		}
	}  
	
	public int letterToNumber(String letter) {
		if (letter == "A") {
			return 0;
		}
		else if (letter == "B") {
			return 1;
		}
		else if (letter == "C") {
			return 2;
		}
		else if (letter == "D") {
			return 3;
		}
		else if (letter == "E") {
			return 4;
		}
		else if (letter == "F") {
			return 5;
		}
		else {
			System.out.println("Error: letterToNumber() is getting an invalid input");
			return 0;
		}
	}
	public static void bookPassenger(String passengerName, String seat) {
		int i;
		int j;
		i = seat.charAt(0);
		if ((Boolean) Character.isDigit(seat.charAt(1)) == true){ //Will probably bug
			//i = parseInt(i.toString().append(seat.charAt(1)));
			i = (i + seat.charAt(1));
			j = seat.charAt(2);
		} 
		else {
			j = seat.charAt(1);
			//second character (charAt(1)) is a letter
		}
		if (2 < i && i < 10) {
			System.out.println("Error: row is neither first nor economy.");
			return;
		}
		if (i >= 10) { //economy
			i = (i - 10);
			if (economyClass[i][j].checkSeat() == true) {
				System.out.println("Request failed, seat is already occupied.");
				return;
			}
			else {
				economyClass[i][j].bookSeat(passengerName, "");
			}
		}
		else {//first class
			if (firstClass[i][j].checkSeat() == true) {
				System.out.println("Request failed, seat is already occupied.");
				return;
			}
			else {
				firstClass[i][j].bookSeat(passengerName, "");
			}
		}
	}
	public static void cancelReservation(String passengerName) { //getSeatByName(String nameToSeek)
		Reservation results = getSeatByName(passengerName);
		if (results != null) {
			results.unBook();
		}
	}
	public void cancelGroup(String groupToSeek) { 
		int k = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (groupToSeek == firstClass[i][j].getGroup()) {
					firstClass[i][j].unBook();
					k++;
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				if (groupToSeek == economyClass[i][j].getGroup()) {
					firstClass[i][j].unBook();
					k++;	
				}
			}
		}
		if (k != 0) {
			System.out.println(k + " bookings canceled.");
		}
		else {
			System.out.println("Request failed, no entry '" + groupToSeek + "' found.");
			
		}
		
	}
	public static int seatsAvailable() {
		int open = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				Boolean truFalse = firstClass[i][j].checkSeat();
				if (truFalse = false) {
					open++;
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				Boolean truFalse = economyClass[i][j].checkSeat();
				if (truFalse = false) {
					open++;
				}
			}
		}
		return open;
	}
	
	public static void bookGroup(String groupName, String passengerNames) {
		int l = passengerNames.length(); // length of the passengerNames string
		//int m = 0; // bookmark used to record progress through passengerNames
		ArrayList<String> passengerGroup = new ArrayList<String>();
		String currentName = ""; //used to record current name before adding to passengerGroup
		int groupCount = 0; // Counter for passengerGroup
		for (int n = 0; n < l; n++) {
			if (',' == passengerNames.charAt(n) && currentName != "") {
				passengerGroup.add(currentName);
				currentName = "";
				for (int m = n; passengerNames.charAt(m) != ' ' && l > m ; m++) { //initialization condition not needed, remove later
					n++;
				}
			}
			else{ //if (' ' != passengerNames.charAt(n)) {
				currentName = currentName + passengerNames.charAt(n);
				//currentName.concat((passengerNames.charAt(n)).toString());
			}
		} //All passenger names are now entries in passengerGroup
		if (passengerGroup.size() >= seatsAvailable()) {
			System.out.println("Request failed, There are not enough seats available.");
		}
		int toServe = passengerGroup.size();
		int alreadyServed = 0;
		String passengerName = "";
		//reminder: arraylists are zero based
		for (int i = 0; i < 20 && toServe > alreadyServed; i++) {
			for (int j = 0; j < 6; j++) {
				Boolean truFalse = economyClass[i][j].checkSeat();
				if (truFalse = false) {
					passengerName = passengerGroup.get(alreadyServed);
					System.out.println("Customer '" + passengerName + "' placed in seat " + (i+10) + "," + j);
					alreadyServed++;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				Boolean truFalse = firstClass[i][j].checkSeat();
				if (truFalse = false) {
					passengerName = passengerGroup.get(alreadyServed);
					System.out.println("Customer '" + passengerName + "' placed in seat " + (i) + "," + j);
					alreadyServed++;
				}
			}
		}
		return;
	}
	
}

