package songPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class SongTester {
	
	public static void main(String argsp[]) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string to decrpyt");
		String encrypted = in.nextLine();
		
		CharIntConvertor c = new CharIntConvertor();
		
		ArrayList<Integer> stepOne = c.CharToInt(encrypted);
		
		Cesear ces = new Cesear();
		
		Affine aff = new Affine();
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < 26; j++) {
				ArrayList<Integer> stepThree = aff.affineDecryptor(stepOne, i, j);
				String stepTwo = c.IntToChar(stepThree);
				System.out.println(stepTwo);
			}
		}
		
		
		//StringBuilder builder = new StringBuilder();
		
	}
	
	
	
}



