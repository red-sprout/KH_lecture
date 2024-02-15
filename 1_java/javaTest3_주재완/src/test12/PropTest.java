package test12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

public class PropTest {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("1", "apple,1200,3");
		prop.setProperty("2", "banana,2500,2");
		prop.setProperty("3", "grape,4500,5");
		prop.setProperty("4", "orange,800,10");
		prop.setProperty("5", "melon,5000,2");
		
		fileSave(prop);
		
		fileOpen(prop);
	}
	
	public static void fileSave(Properties p) {
		try(OutputStream stream = new FileOutputStream("data.xml")) {
			p.storeToXML(stream, "fruits");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileOpen(Properties p) {
		Fruit[] fruits = new Fruit[p.size()];
		try(InputStream stream = new FileInputStream("data.xml")) {
			p.loadFromXML(stream);
			
			Enumeration<?> enumeration = p.propertyNames();
			while (enumeration.hasMoreElements()) {
				String element = (String) enumeration.nextElement();
				StringTokenizer st = new StringTokenizer(p.getProperty(element), ",");
				
				String name = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int quantity = Integer.parseInt(st.nextToken());
				
				fruits[Integer.parseInt(element) - 1] = new Fruit(name, price, quantity);
			}
			
			for(int i = 0; i < fruits.length; i++) {
				System.out.println((i + 1) + " = " + fruits[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
