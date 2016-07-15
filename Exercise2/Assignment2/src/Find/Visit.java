package Find;

import java.net.URL;

public class Visit implements VisitAction {

	@Override
	public void visit(URL url) {
		System.out.println(url);
	}
}
