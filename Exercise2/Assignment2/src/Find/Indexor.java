package Find;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Indexor {
	private static RandomAccessFile raf;
	private static File file;
	private int indexMult = 8;
	
	public Indexor(String arrayFileName) {
		file = new File(arrayFileName);
	}
	
	public static void initialize(String arrayFileName, int arraySize, long initialValue) {
		try {
			raf = new RandomAccessFile(arrayFileName, "rw");
			raf.setLength(arraySize);
			raf.writeLong(initialValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void set(int index, long value) {
		try {
			raf.seek(index * indexMult);
			raf.writeLong(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long get(int index) {
		long l = 0;
		try {
			raf.seek(index * indexMult);
			l = raf.readLong();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public long getLength() {
		long length = 0;
		try {
			length = raf.length();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return length;
	}
	
	public void close() {
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean delete(String arrayFileName) {
		if(file.exists()) { 
			file.delete();
			return true;
		
		} else {
			return false;
		}
		
	}
}