package reservationPackage;
import java.io.IOException;
import java.util.*;


public class ReservationTester extends ReservationEvent{

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String command = "start";
		airlineConstructor();
		LoadFiles();
		while (command.equalsIgnoreCase("Q") != true) { //main loop
			System.out.println("Add [P]assenger, Add [G]roup, [C]ancel Reservations, Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");
			command = in.nextLine();
			if (command.equalsIgnoreCase("P")) {//[P]assenger 
				String passenger = "";
				String prefferedSeat = "";
				System.out.println("Enter the name of the passenger");
				passenger = in.nextLine();
				System.out.println("Enter the preffered seat");
				prefferedSeat = in.nextLine();
				bookPassenger(passenger, prefferedSeat);
			}
			else if (command.equalsIgnoreCase("G")) {//[G]roup
				String groupName = "";
				String passengerNames = "";
				System.out.println("Enter the name of your group");
				groupName = in.nextLine();
				System.out.println("Enter the name of the group members, seperated by commas");
				passengerNames = in.nextLine();
				bookGroup(groupName, passengerNames);
			}
			else if (command.equalsIgnoreCase("C")) {//[C]ancel Reservations
				String passengerName = "";
				System.out.println("Enter the name of the passenger whose reservation you wish to cancel");
				passengerName = in.nextLine();
				cancelReservation(passengerName);
			}
			else if (command.equalsIgnoreCase("A")) {//Print Seating [A]vailability Chart
				printEconomyClassSeating();
			}
			else if (command .equalsIgnoreCase("M")) {//[M]anifest
				checkFirstClassManifest();
				checkEconomyClassManifest();
			}
			else if (command.equalsIgnoreCase("Q")){
			}
			else {
				System.out.println("Command not recognized.");
			}
		}
		SaveFiles();
	}
}

