package songPackage;

import java.util.ArrayList;

public class Cesear {

	
	public ArrayList<Integer> cesearDecryptor(ArrayList<Integer> input, int shift){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			output.add(input.get(i) + shift);
		}
		return output;
	}	
}
