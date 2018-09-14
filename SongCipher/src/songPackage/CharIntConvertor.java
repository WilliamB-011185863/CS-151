package songPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class CharIntConvertor {

	
	public ArrayList<Integer> CharToInt(String raw){
		ArrayList<Integer> charArray = new ArrayList<Integer>();
		char[] unpacked = raw.toCharArray();
		//Character[] altpacked = new Character[unpacked.length];
		for (int i = 0, j = unpacked.length; i < j; i++) {
			if (unpacked[i] != ' ') { //This step filters out spaces, which would cause errors later on
				int convertedInt = Character.getNumericValue(Character.valueOf(unpacked[i]));
				convertedInt = convertedInt - 10; //Neccesary, for some reason.
				charArray.add(convertedInt);
				//System.out.println(convertedInt);
			}
		}
		
		return charArray;
	}
	
	public String IntToChar(ArrayList<Integer> intArray) {
		StringBuilder builder = new StringBuilder();
		int max = 0;
		ArrayList<Character> fullLetterIndex = new ArrayList<Character>();
		Character[] letterIndex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
	            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
	            'W', 'X', 'Y', 'Z'};
		for (int i = 0, j = intArray.size(); i < j; i++) {
			if (intArray.get(i) > max) {
				max = intArray.get(i);
			} //This gets the maximum value from the intArray
		}
		while (fullLetterIndex.size() < max) {
			fullLetterIndex.addAll(Arrays.asList(letterIndex));
		}
		fullLetterIndex.addAll(Arrays.asList(letterIndex)); //A extra addition can prevent outofbounds exceptions
		for (int i = 0, j = intArray.size(); i < j; i++) {
			//System.out.println(fullLetterIndex.get(intArray.get(i)));
			try{
				builder.append(fullLetterIndex.get(intArray.get(i)));
			}
			catch (IndexOutOfBoundsException e){
				System.out.println("i = " +  i + "," + "get(i) = "+ intArray.get(i) + ", fullLetterIndex is size " + fullLetterIndex.size());
			}
		}
		return builder.toString();
	}
	
	
}
