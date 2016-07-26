package Find; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFinder {
	private String line;
	ArrayList<String> list = new ArrayList<String>();

	public void processPage(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try {
			while ((line = reader.readLine()) != null) {
				matchPattern();
			} 				
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void matchPattern() {
		String pattern =  "<[\\s]*[Aa][\\s]+[Hh][Rr][Ee][Ff][\\s]*=[\\s+]?[\"]([^\"]*)";
		//String pattern =  "<[\\s]*[Aa]\\s+href=\"(.*)\"";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		boolean matches = m.find();
		if(matches) {
			list.add(m.group(1));
		}                  

	}

	public Iterator<String>  getLinks() {
		Iterator<String> i = list.iterator();
		return i;
	}

	public void removeFromList() {
		list.clear();
	}
}
