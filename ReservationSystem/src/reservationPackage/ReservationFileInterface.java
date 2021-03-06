package reservationPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReservationFileInterface {
	public void CreateFile(){
		//Creates a blank file, if one does not already exist
		try {
			Path path = Paths.get("events.txt");
			if (Files.notExists(path)) {
				File f = new File("events.txt"); 
				f.createNewFile();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean CheckFile(){
		//checks if file exists
		Path path = Paths.get("events.txt");
		if (Files.exists(path)) {
			return true;
			}
		else return false;
	}
	public ArrayList<String> ReadFile() throws IOException{
		//read all events out to memory for listing
		ArrayList<String> words = new ArrayList<String>();
		CreateFile();
		BufferedReader reader = new BufferedReader(new FileReader("events.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			words.add(line);
		}
		reader.close();
		return words;
	}
	public void Write2File(String text) throws FileNotFoundException{
			//write current event to file and save
		try(  PrintWriter out = new PrintWriter( "events.txt" )  ){
			out.println( text );
		}
	}
	public void RewriteFile(ArrayList<String> arrData) throws IOException{
		//list and save -- rewrite file with all events in chron order and save
		FileWriter writer = new FileWriter("events.txt");
			int size = arrData.size();
			for (int i=0;i<size;i++) {
				String str = arrData.get(i).toString();
				writer.write(str);
				if(i < size-1)//This prevent creating a blank line at the end of the file
						writer.write("\n");
			}
			writer.close();
	}
	
	
	
}
