package songPackage;

import java.util.ArrayList;

public class Affine {

	
	public ArrayList<Integer> affineDecryptor(ArrayList<Integer> input, int multiplier, int shift){
		if (multiplier == 0) {
			System.out.println("Multiplier cannot be zero. Setting to 1...");
			multiplier++;
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			output.add(multiplier * input.get(i) + shift);
		}
		return output;
	}	
	
	
	
}
