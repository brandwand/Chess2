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
	String line;
	ArrayList<String> list = new ArrayList<String>();
	StringBuilder results;
	
	public LinkFinder() {
	}


	public static void main(String[] args) {
		try {
			LinkFinder l = new LinkFinder();
			InputStream in = new FileInputStream(new File("neumont.edu"));
			//l.getLinks();
			l.processPage(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processPage(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();

		try {
			while ((line = reader.readLine()) != null) {
				if(matchPattern() == true) {
					results = out.append(line + "\n");
				}
			} 				
			System.out.println(results);
			reader.close();
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean matchPattern() {
		String pattern = "<[Aa][\\s+][Hh][Rr][Ee][Ff][\\s]?=";
		//String pattern = "<a";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		boolean matches = m.find();
		return matches;
	}
//	public Iterator<String>  getLinks() {
//		Iterator<String>Namesit = list.iterator();
//		while(Namesit.hasNext())
//		{
//			String Name = Namesit.next();
//		}
//		//		if(((Iterator<String> ) list).hasNext()) {
//		//			String result = ((Iterator<String>) list).next();
//		//		}
//		return Namesit;
//	}
}
