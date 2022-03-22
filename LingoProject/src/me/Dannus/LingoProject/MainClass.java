package me.Dannus.LingoProject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		//importing words
		System.out.println("Starting importing words..");
		
		InputStream in = MainClass.class.getClass().getResourceAsStream("/me/Dannus/LingoProject/words.txt");
		Reader fr = new InputStreamReader(in);
		List<String> words = new ArrayList<String>();
		Scanner Reader = new Scanner(fr);
		while (Reader.hasNextLine()) {
			String data = Reader.nextLine();
			words.add(data);
		}
		Reader.close();
		
		System.out.println(words.size() + " words found.");
		
		
		
		//Ask for begin letter
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter begin letter: ");
		String n = reader.nextLine();
		
		
		
		//Filter new words
		List<String> possible = new ArrayList<String>();
		if (n.length() == 1) {
			for (int i = 0; i < words.size(); i++) {
				
				//check for containing letters
				if (words.get(i).startsWith(n.trim())) {
					possible.add(words.get(i));
				} else {
					System.out.println(words.get(i) + " - DECLINED - CAUSE: 'Not matching given letters.'");
				}
			}
		}
		
		System.out.println("Total words left: " + possible.size());
		System.out.println("Words left: " + possible);
		
				
				
		//Ask for containing letter 1
		System.out.println("Enter letter(s): ");
		String n1 = reader.nextLine();
		
		
		
		//Filter new words 1
		List<String> possible1 = new ArrayList<String>();
		if (n1.length() == 1) {
			for (int i = 0; i < possible.size(); i++) {
				
				//check for containing letters
				if (possible.get(i).contains(n1.trim())) {
					possible1.add(possible.get(i));
				} else {
					System.out.println(possible.get(i) + " - DECLINED - CAUSE: 'Not matching given letters.'");
				}
			}
		}
		
		System.out.println("Total words left: " + possible1.size());
		System.out.println("Words left: " + possible1);
		
		reader.close();
	}
	
}
