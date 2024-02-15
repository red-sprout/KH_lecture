package review;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
	public void fileSave(String fileName) {
		File file = new File(fileName);
		Food apple = new Food("사과", 20);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(apple);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen(String fileName) {
		File file = new File(fileName);
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			try {
				System.out.println((Food)ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void output() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt", true);
			fw.write(97);
			fw.write(65);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
