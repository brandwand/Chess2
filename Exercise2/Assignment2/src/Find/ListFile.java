package Find;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ListFile {
	private static File file;
	private static RandomAccessFile raf;

	public ListFile(String listFileName) {
		file = new File(listFileName);
	}

	public static void initialize(String listFileName) {
		try {
			raf = new RandomAccessFile(listFileName, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String listFileName) {
		file.delete();
		}

	public void close() {
		try {
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long newEntry(Entry entry) {
		long offset = 0;
		try {
			raf.seek(offset);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entry = new Entry("Fred", (long)0, (long)8);
		return offset;
	}

	public Entry getEntry(long offset) {
		try {
			raf.seek(offset);
			offset = raf.readLong();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void putEntry(long offset, Entry entry) {
		try {
			raf.seek(offset);
			raf.writeLong(entry.getValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
