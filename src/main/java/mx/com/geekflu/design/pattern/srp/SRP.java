package mx.com.geekflu.design.pattern.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SRP {
	public static void main(String[] args) throws IOException {
		Journal j = new Journal();
		j.addEntry("I cried");
		j.addEntry("I ate a bug");
		System.out.println(j);
		
		Persistence p = new Persistence();
		String filename = "c:\\temp\\journal.txt";
		p.saveToFile(j, filename, true);
		
		Runtime.getRuntime().exec("notepad.exe " + filename);
	}
}

class Journal{
	private final List<String> entries = new ArrayList<>();
	private static int count = 0;
	
	public void addEntry(String text) {
		entries.add("" + ++count + ": " + text);
	}
	
	public void remove(int index) {
		entries.remove(index);
	}
	
	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
}

class Persistence{
	public void saveToFile(Journal journal, 
						   String fileName,
						   boolean overwrite) throws FileNotFoundException {
		if(overwrite || new File(fileName).exists()) {
			try(PrintStream ps = new PrintStream(fileName)){
				ps.println(journal.toString());
			}
		}
	}
}