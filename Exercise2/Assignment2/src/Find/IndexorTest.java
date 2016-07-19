package Find;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexorTest {

	@Test
	public void test() {	

		Indexor i = new Indexor("test.bin");
		assertFalse(i.delete("test.bin") == false);
		i.initialize("test.bin", 4, 2);
		assertTrue(i.delete("test.bin") == true);
		i.set(1, 14);
		System.out.println(i.get(1));
		assertEquals(i.get(1), 14);

		
	}
}
