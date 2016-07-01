package Find;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

import org.junit.Test;

public class LinkFinderTest {

	@Test
	public void test() {
		LinkFinder find = new LinkFinder();
		InputStream in;
		try {
			in = new FileInputStream(new File("neumont.edu"));	
			find.processPage(in);
			InputStream resultsIn = new FileInputStream(new File("results"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(resultsIn));
			String line = reader.readLine();
			assertTrue(line == find.getLine());
			System.out.println(find.getLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
