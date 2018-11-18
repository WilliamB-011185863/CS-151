package fivePointTwelve;
import java.io.IOException;
import java.io.Writer;

public class EncryptingWriter extends Writer {
	
	private static String alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
	private Writer writer;
	
	public EncryptingWriter(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void write(char[] charbuff, int offset, int length) throws IOException {
		char[] anotherBuff = new char[length];
		String testString = "";
		for(int i = offset; i < offset + length; i++){
			char ch = charbuff[i];
			if (Character.isLetter(ch)){
				ch = alphabet.charAt(alphabet.indexOf(ch) + 6);
				
			}
			if (!Character.isLetter(ch)){
				ch = alphabet.charAt(alphabet.indexOf(ch) - 52);
			}
			testString += ch;
			
			anotherBuff[i - offset] = ch;
		}
		System.out.println(testString);
		writer.write(anotherBuff, 0, length);
		
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

}
