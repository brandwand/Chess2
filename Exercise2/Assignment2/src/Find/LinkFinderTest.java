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
import java.util.ArrayList;
import java.util.Iterator;

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
			ArrayList<String> l = new ArrayList<String>();
			try {
				String a;
				while ((a = reader.readLine()) != null) {
					l.add(a);
				} 				
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<String> results = l.iterator();
			Iterator<String> eduPage = find.getLinks();

			while(results.hasNext()) {	
				assertEquals(results.next(), eduPage.next());
			}					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	} 
}
