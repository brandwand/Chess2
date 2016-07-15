package Find;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
	private URL url;
	private int maxPages = 50;
	VisitAction i;
	ArrayList<String> toVisit = new ArrayList<String>();
	ArrayList<URL> beenVisited = new ArrayList<URL>();


	public Crawler(URL url, int maxPages, VisitAction i) {
		this.url = url;
		this.maxPages = maxPages;
		this.i = i;		
		toVisit.add(url.toString());

	}
	public void Crawl() {	
		LinkFinder find = new LinkFinder();
		try {
			while (!toVisit.get(0).isEmpty()) {
				String removed = toVisit.remove(0);	
				URL visitingURL = addProtocol(removed);	

				try {	
					find.processPage(visitingURL.openStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	


				Iterator<String> urlList = find.getLinks();
				while(urlList.hasNext()) {	
					String listOfURLs = urlList.next();
					URL addedProtocol = addProtocol(listOfURLs);
					if(!toVisit.contains(listOfURLs) && !beenVisited.contains(addedProtocol)) {
						toVisit.add(listOfURLs);
					}				
				}	
				beenVisited.add(visitingURL);
				i.visit(visitingURL);	
				find.removeFromList();

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Reached end of list.");
		}
	}

		public URL addProtocol(String string) {
			String pattern =  "https?";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(string);
			boolean matches = m.find();
			URL wholeURL = null;
			if(!matches) {		
				try {	

					String u = url.getProtocol() + "://" + url.getHost() + string;
					wholeURL = new URL(u);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					wholeURL = new URL(string);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return wholeURL;

		}
	}