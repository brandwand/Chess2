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

	public static boolean delete(String listFileName) {
		boolean exists = false;
		file.delete();
		if(file.exists()) {
			exists = true;	

		}
		return exists;
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
			raf.seek(file.length());
			offset = raf.getFilePointer();
			writeEntry(entry);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return offset;
	}

	public Entry getEntry(long offset) {
		try {
			raf.seek(offset);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readEntry();
	}

	public void putEntry(long offset, Entry entry) {
		try {
			raf.seek(offset);
			writeEntry(entry);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeEntry(Entry entry) {
		try {
			raf.writeInt(entry.getString().length());
			raf.writeBytes(entry.getString());
			raf.writeLong(entry.getValue());
			raf.writeLong(entry.getLink());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Entry readEntry() {
		Entry entry = null;
		try {
			int lengthOfString = raf.readInt();
			byte[] byteArray = new byte[lengthOfString];
			raf.read(byteArray);
			long value = raf.readLong();
			long link = raf.readLong();
			String converted = new String(byteArray, "UTF-8");
			entry = new Entry(converted, value, link);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entry;
	}
}
