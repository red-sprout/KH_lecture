package review;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO {
	public static void main(String[] args) {
		File file = new File("example.txt");
		Person[] people = new Person[3];
		people[0] = new Person("홍길동", 30, 'M');
		people[1] = new Person("심청", 18, 'F');
		people[2] = new Person("성춘향", 20, 'F');
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			for (Person person : people) {
				oos.writeObject(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("example.txt"))) {
			while(true) {
				System.out.println((Person) ois.readObject());
			}
		} catch (EOFException e) {
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
