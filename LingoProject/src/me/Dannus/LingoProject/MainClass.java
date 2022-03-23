package me.Dannus.LingoProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		//importing words
		System.out.println("Starting importing words..");
		List<String> words = FileManager.wordSorter();
		System.out.println(words.size() + " words found.");
		
		for (int i = 0; i < 100; i++) {
			lingo(words);
		}
	}
	
	static void lingo(List<String> words) {
		
		//Ask for begin letter
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter begin letter: ");
		String n = reader.nextLine();
		
		
		
		//Filter new words
		List<String> possible = new ArrayList<String>();
		if (n.length() == 1) {
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).startsWith(n.trim())) {
					possible.add(words.get(i));
				} else {
					System.out.println(words.get(i) + " - DECLINED - CAUSE: 'Not matching given letters.'");
				}
			}
		}
		
		System.out.println("Total words left: " + possible.size());
		System.out.println("Suggested words: " + possible);
		
		for (int i = 0; i < 10; i++) {
			//Ask for containing letter 1
			System.out.println("Enter word: ");
			String word = reader.nextLine().replace("ij", "@").trim();
			System.out.println("Enter stats: ");
			String stats = reader.nextLine().trim();
			
			if (word.equals("reset") || stats.equals("reset")) {
				System.out.println("resetting");
				return;
			} else if (word.equals("stop") || stats.equals("stop")) {
				System.exit(0);
				return;
			}
			
			String[] wordSplitted = word.split("");
			String[] statsSplitted = stats.split("");
			
			HashMap<String, Integer> redLetterList = new HashMap<String, Integer>();
			HashMap<String, Integer> yellowLetterList = new HashMap<String, Integer>();
			List<String> blankLetterList = new ArrayList<String>();
			
			for (int i0 = 0; i0 < wordSplitted.length; i0++) {
				if (statsSplitted[i0].equals("r")) redLetterList.put(wordSplitted[i0], i0);
				if (statsSplitted[i0].equals("y")) yellowLetterList.put(wordSplitted[i0], i0);
				if (statsSplitted[i0].equals("b")) blankLetterList.add(wordSplitted[i0]);
			}
			
			for (Map.Entry<String, Integer> set : redLetterList.entrySet()) {
				possible = LetterProcessor.redLetter(set.getKey(), set.getValue(), possible);
	        }
			
			for (Map.Entry<String, Integer> set : redLetterList.entrySet()) {
				possible = LetterProcessor.yellowLetter(set.getKey(), set.getValue(), possible);
	        }
			
			for (int i0 = 0; i0 < blankLetterList.size(); i0++) {
				possible = LetterProcessor.blankLetter(blankLetterList.get(i0), possible);
			}
			
			System.out.println("Total words left: " + possible.size());
			System.out.println("Suggested words: " + possible);
		}
		
		
		
		reader.close();
	}
	
}
