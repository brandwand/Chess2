package Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTextFile {

	private BufferedReader read;
	
	public ReadTextFile(InputStream fileName) {
		try {
			read = new BufferedReader(new InputStreamReader(fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getMoves() {
		String pattern = "[K|Q|B|R|N|O-O|O-O-O][a-f][0-9]-[a-f][0-9][+|#|++]";
		Pattern p = Pattern.compile(pattern);
		Matcher m;
		try {
			while(read != null) {
				String line = read.readLine();
				m = p.matcher(line);		
				boolean matches = m.find();	
				if(matches) {
					System.out.println(line);
					System.out.println("Moving from " + line.substring(0, 2) + " to " + line.substring(3, 5));
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void putPosition() {
		String pattern = "[Q|K|B|R|N|C|O-O|O-O-O][l|d][a-f][0-9]";
		pattern.toLowerCase();
		Pattern p = Pattern.compile(pattern);
		Matcher m;
		try {
			while(read != null) {

				String line = read.readLine();
				line.toLowerCase();
				m = p.matcher(line);		
				boolean matches = m.find();	
				if(matches) {
					System.out.println(line);
					System.out.println("Put the queen at position " + line.substring(2, 4));
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
