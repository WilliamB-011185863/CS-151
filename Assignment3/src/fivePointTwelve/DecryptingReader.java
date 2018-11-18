package fivePointTwelve;
import java.io.IOException;
import java.io.Reader;

public class DecryptingReader extends Reader {
	private Reader reader;
	private static String alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
	
	public DecryptingReader(Reader reader) {
		this.reader = reader;
	}
	
	public int read(char[] charbuff, int offset, int length) throws IOException {
		int result = reader.read(charbuff, offset, length);
		char[] anotherBuff = new char[length];
		String testString = "";
		for (int i = offset; i < offset + length; i++){
			char ch = charbuff[i];
			if (Character.isLetter(ch)){
				ch = alphabet.charAt(alphabet.indexOf(ch) - 6);
			}
			if (!Character.isLetter(ch)){
				ch = alphabet.charAt(alphabet.indexOf(ch) + 52);
			}
			testString += ch;
			anotherBuff[i] = ch;
		}
		System.out.println(testString);
		return result;
	}
	
	@Override
	public void close() throws IOException {
		reader.close();
	}

}
