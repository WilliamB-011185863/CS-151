package songPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class CharIntConvertor {

	
	public ArrayList<Integer> CharToInt(String raw){
		ArrayList<Integer> charArray = new ArrayList<Integer>();
		char[] unpacked = raw.toCharArray();
		
		
		
		
		
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
			}
		}
		while (fullLetterIndex.size() < max) {
			fullLetterIndex.addAll(Arrays.asList(letterIndex));
		}
		for (int i = 0, j = intArray.size(); i < j; i++) {
			builder.append(fullLetterIndex.get(intArray.get(i)));
		}
		return builder.toString();
	}
	
	
}
