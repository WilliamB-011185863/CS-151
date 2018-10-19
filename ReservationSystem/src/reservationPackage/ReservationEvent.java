package reservationPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationEvent {

	private static Reservation[][] firstClass;
	private static Reservation[][] economyClass;
	
	public static void airlineConstructor() {
		//Used at the start of the run to create the Reservation[][] arrays
		//(which are subsequently populated by LoadFiles())
		firstClass = new Reservation[2][4];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				firstClass[i][j] = new Reservation("","");
			}
		}
		economyClass = new Reservation[20][6];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				economyClass[i][j] = new Reservation("","");
			}
		}
	}
	
	public static Reservation getSeatByName(String nameToSeek) {
		//Takes a String name, searches than returns the first match (or null)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (nameToSeek.equals(firstClass[i][j].getName())) {
					return firstClass[i][j];
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				if (nameToSeek.equals(economyClass[i][j].getName())) {
					return economyClass[i][j];
				}
			}
		}
		System.out.println("Request failed, no entry '" + nameToSeek + "' found.");
		return null;
	}
	
	private static String convertSeatId(int i, int j) {
		//Converts i,j to a String for the seat, for example 1,0 becomes 1A
		String altJ;
		if (j == 0) {
			altJ = "A";
		}
		else if (j == 1) {
			altJ = "B";
		}
		else if (j == 2) {
			altJ = "C";
		}
		else if (j == 3) {
			altJ = "D";
		}
		else if (j == 4) {
			altJ = "E";
		}
		else if (j == 5) {
			altJ = "F";
		}
		else {
			altJ = "Z";
		}
		return (i + altJ);
	}
	
	public void bookFirstClassSeat(int i, int j, String name, String group) {
		//simple booking function, basically a wrapper for bookSeat
		i--;
		j--;
		firstClass[i][j].bookSeat(name, group);
	}A
	public void bookEconomyClassSeat(int i, int j, String name, String group) {
		//simple booking function, basically a wrapper for bookSeat
		i--;
		j--;
		economyClass[i][j].bookSeat(name, group);
	}
	
	public static void checkFirstClassManifest() {
		//Used for printing the Manifest
		for (int i = 0; i < 2; i++) {
			System.out.print("First     ");
			for (int j = 0; j < 4; j++) {
				System.out.print(convertSeatId(i, j) + ": " + firstClass[i][j].quickDesignation() + "    ");
			}
			System.out.println();
		}
	}
	
	public static void checkEconomyClassManifest() {
		//Used for printing the Manifest
		for (int i = 0; i < 20; i++) {
			System.out.print("Economy     ");
			for (int j = 0; j < 6; j++) {
				System.out.print(convertSeatId(i+10, j) + ": " + economyClass[i][j].quickDesignation() + "    ");
			}
			System.out.println();
		}
	}
	
	public static String jToLetter(int j) {
		//Converts the int j to cooresponding letter
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
	
	public void printFirstClassSeating() { 
		System.out.print("First ");
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
	
	public static void printEconomyClassSeating() { 
		System.out.print("Economy ");
		for (int i = 0; i < 20; i++) {
			System.out.print((i + 1) + ": ");
			for (int j = 0; j < 6; j++) {
				if (economyClass[i][j].quickDesignation() == "Vacent") {
					System.out.print(jToLetter(j));
					if (j != 5) {
						System.out.print(", ");
					}
				}
				
			}
			System.out.print("   ");
		}
	}  
	
	public static int letterToNumber(String letter) {
		if (letter.equals("A")) {
			return 0;
		}
		else if (letter.equals("B")) {
			return 1;
		}
		else if (letter.equals("C")) {
			return 2;
		}
		else if (letter.equals("D")) {
			return 3;
		}
		else if (letter.equals("E")) {
			return 4;
		}
		else if (letter.equals("F")) {
			return 5;
		}
		else {
			System.out.println("Error: letterToNumber() is getting an invalid input");
			return -1;
		}
	}
	public static void bookPassenger(String passengerName, String seat) { 
		//places passengerName at seat
	    List<String> seatDissect = new ArrayList<String>();
	    Matcher match = Pattern.compile("[0-9]+|[a-z]+|[A-Z]+").matcher(seat);
	    while (match.find()) {
	    	seatDissect.add(match.group());
	    }
	    
		if (seatDissect.size() != 2) {
			System.out.println("Error: Invalid seat input");
			return;
		}
		int seat123 = Integer.parseInt(seatDissect.get(0));
		int seatABC = letterToNumber(seatDissect.get(1)); 
		System.out.println("Debug: seatABC = " + seatABC);
		if (seatABC == -1) {
			return;
		}
		if (2 < seat123 && seat123 < 10) {
			System.out.println("Error: row is neither first nor economy.");
			return;
		}
		if (seat123 > 20) {
			System.out.println("Error: row is not in plane (overflow).");
			return;
		}
		if (seat123 >= 10) { 
			int seat111213 = (seat123 - 10);
			if (economyClass[seat111213][seatABC].checkSeat() == true) {
				System.out.println("Request failed, seat is already occupied.");
				return;
			}
			else {
				economyClass[seat111213][seatABC].bookSeat(passengerName, "");
			}
		}
		else {
			if (firstClass[seat123][seatABC].checkSeat() == true) {
				System.out.println("Request failed, seat is already occupied.");
				return;
			}
			else {
				firstClass[seat123][seatABC].bookSeat(passengerName, "");
			}
		}
	}
	public static void cancelReservation(String passengerName) {
		//uses getSeatByName() to get a seat, then unBook()s
		Reservation results = getSeatByName(passengerName);
		if (results != null) {
			results.unBook();
		}
	}
	public void cancelGroup(String groupToSeek) { 
		// cancels all reservatins with group = groupToSeek
		// NOTE: This function is never used
		int k = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (groupToSeek.equals(firstClass[i][j].getGroup())) {
					firstClass[i][j].unBook();
					k++;
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				if (groupToSeek.equals(economyClass[i][j].getGroup())) {
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
		// Gets the number of seats where this.occupency = false
		int open = 0;
		int filled = 0; 
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				Boolean truFalse = firstClass[i][j].checkSeat();
				if (truFalse == false) {
					open++;
				}
			}
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				Boolean truFalse = economyClass[i][j].checkSeat();
				if (truFalse == false) {
					open++;
				}
			}
		}
		return open;
	}
	
	public static void bookGroup(String groupName, String passengerNames) {
		// splits passengerNames into an ArrayList<String>, then books available seats with passengerNames(), groupName
		int l = passengerNames.length(); 
		ArrayList<String> passengerGroup = new ArrayList<String>();
		String currentName = ""; 
		for (int n = 0; n < l; n++) {
			if (',' == passengerNames.charAt(n) && currentName != "") {
				passengerGroup.add(currentName);
				currentName = "";
				for (int m = n; passengerNames.charAt(m) != ' ' && l > m ; m++) {
					n++;
				}
			}
			else{ 
				currentName = currentName + passengerNames.charAt(n);
			}
		} 
		if (currentName != "") {
			passengerGroup.add(currentName);
		}
		if (passengerGroup.size() >= seatsAvailable()) {
			System.out.println("Request failed, There are not enough seats available.");
			return;
		}
		int toServe = passengerGroup.size();
		int alreadyServed = 0;
		String passengerName = "";
		for (int i = 0; i < 20 && toServe > alreadyServed; i++) {
			for (int j = 0; j < 6 && toServe > alreadyServed; j++) {
				Boolean truFalse = economyClass[i][j].checkSeat();
				if (truFalse == false) {
					passengerName = passengerGroup.get(alreadyServed);
					System.out.println("Customer '" + passengerName + "' placed in seat " + (i+10) + "," + j);
					economyClass[i][j].bookSeat(passengerName, groupName);
					alreadyServed++;
				}
			}
		}
		for (int i = 0; i < 2 && toServe > alreadyServed; i++) {
			for (int j = 0; j < 4 && toServe > alreadyServed; j++) {
				Boolean truFalse = firstClass[i][j].checkSeat();
				if (truFalse == false) {
					passengerName = passengerGroup.get(alreadyServed);
					System.out.println("Customer '" + passengerName + "' placed in seat " + (i) + "," + j);
					firstClass[i][j].bookSeat(passengerName, groupName);
					alreadyServed++;
				}
			}
		}
		return;
	}
	public void setupFileIO() throws IOException {
		ReservationFileInterface RFI = new ReservationFileInterface();
		RFI.CreateFile();
		LoadFiles();
	}
	public static void LoadFiles() throws IOException {
		//loads files using ReservationFileInterface and Unpacker() (or creates a new file if exisiting isn't found)
		ReservationFileInterface RFI = new ReservationFileInterface();
		ArrayList<String> fileData = RFI.ReadFile();
		if (fileData.size() > 1) {
			ArrayList<String> unpackedFirstClass = new ArrayList<String>();
			ArrayList<String> unpackedEconomyClass = new ArrayList<String>();
			String firstClassData = fileData.get(0);
			String economyClassData = fileData.get(1);
			unpackedFirstClass = Unpacker(firstClassData);
			unpackedEconomyClass = Unpacker(economyClassData);
			int index = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					firstClass[i][j].setName(unpackedFirstClass.get(index));
					index++;
					firstClass[i][j].setGroup(unpackedFirstClass.get(index));
					index++;
					if (firstClass[i][j].getName() != "" | firstClass[i][j].getGroup() != "") {
						firstClass[i][j].isOccupied();
					}
				}
			}
			index = 0;
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 6; j++) {
					economyClass[i][j].setName(unpackedEconomyClass.get(index));
					index++;
					economyClass[i][j].setGroup(unpackedEconomyClass.get(index));
					index++;
					if (economyClass[i][j].getName() != "" | economyClass[i][j].getGroup() != "") {
						economyClass[i][j].isOccupied();
					}
				}
			}
		}
		else {
			RFI.CreateFile();
		}
	}
	
	public static ArrayList<String> Unpacker(String rawData){
		ArrayList<String> Unpacked = new ArrayList<String>();
		int l = rawData.length();
		String current = "";
		for (int n = 0; n < l; n++) {
			if (',' == rawData.charAt(n)) {
				Unpacked.add(current);
				current = "";
			}
			else{ 
				current = current + rawData.charAt(n);
			}
		} 
		return Unpacked;
	}
	
	public static void SaveFiles() throws IOException {
		ReservationFileInterface RFI = new ReservationFileInterface();
		String entry = "";
		ArrayList<String> PackedData = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				entry = entry + firstClass[i][j].getName() + ",";
				entry = entry + firstClass[i][j].getGroup() + ",";
			}
		}
		PackedData.add(entry);
		entry = "";
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 6; j++) {
				entry = entry + economyClass[i][j].getName() + ",";
				entry = entry + economyClass[i][j].getGroup() + ",";
			}
		}
		PackedData.add(entry);
		RFI.RewriteFile(PackedData);
	}
	
		
	
}

