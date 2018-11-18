package fivePointTwelve;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

public class DecoratorTester {
	public static void main(String[] args) throws IOException{
		// test method for files
		EncryptingWriter encryptor = new EncryptingWriter(new FileWriter("test.out"));
		DecryptingReader decryptor = new DecryptingReader(new FileReader("test.out"));
		encryptor.write("THISISATEST", 0, 11);
		decryptor.read();
		int testInt = decryptor.read();
	}

}
