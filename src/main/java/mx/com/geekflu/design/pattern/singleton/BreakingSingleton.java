package mx.com.geekflu.design.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BreakingSingleton {
	
	//Breaking private constructor via reflection
	//Serialization
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BasicSingleton s1 = BasicSingleton.getInstance();
		s1.setValue(111);
		String fileName = "singleton.bin";
		saveTofile(s1, fileName);
		
		s1.setValue(222);
		
		BasicSingleton s2 = readFromFile(fileName);
		
		System.out.println(s1 == s2);
		System.out.println(s1.getValue());
		System.out.println(s2.getValue());
	}
	
	public static void saveTofile(BasicSingleton singleton, String fileName) throws IOException {
		try(
			FileOutputStream fileout = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileout)	
		){
			out.writeObject(singleton);
		}
	}
	
	public static BasicSingleton readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(
			FileInputStream fieInm = new FileInputStream(fileName);
			ObjectInputStream inObj = new ObjectInputStream(fieInm)
				){
			return (BasicSingleton) inObj.readObject();
		}
	}
}
