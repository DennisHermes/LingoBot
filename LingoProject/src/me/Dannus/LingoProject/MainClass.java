package me.Dannus.LingoProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		
		AppLauncher.lauch();
		
		//importing words
		AppLauncher.loadingText.setText("Woorden aan het importeren...");
		WordsManager.importWords();
		AppLauncher.loadingText.setText(WordsManager.defaultWords.size() + " woorden gevonden. (" + WordsManager.removed + " woorden geblokkeerd)");
		WordsManager.possibleWords = WordsManager.defaultWords;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		AppLauncher.fadeOut(AppLauncher.loadingText);
		
		AppLauncher.beginLetterScreen();
		
		for (int i = 0; i < 100; i++) {
			lingo(WordsManager.defaultWords);
		}
	}
	
	static void lingo(List<String> words) {
		
		//Ask for begin letter
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Vul de eerste letter in: ");
		String n = reader.nextLine();
		
		List<String> possible = new ArrayList<String>();
		if (n.length() == 1) {
			for (int i = 0; i < words.size(); i++) {
				if (words.get(i).startsWith(n.trim())) {
					possible.add(words.get(i));
				}
			}
		}
		
		System.out.println("Totale mogelijke woorden over: " + possible.size());
		System.out.println("Voorgesteld woord: " + WordSuggester.suggestWord(possible));
		
		
		
		for (int i = 0; i < 100; i++) {
			//Ask for containing letter 1
			System.out.println("Vul je ingevulde woord in: ");
			String word = reader.nextLine().replace("ij", "@").trim();
			System.out.println("Geef het resultaat: ");
			String stats = reader.nextLine().trim();
			
			if (word.equals("reset") || stats.equals("reset")) {
				System.out.println("Aan het resetten...");
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
			
			System.out.println("Totale mogelijke woorden over: " + possible.size());
			System.out.println("Voorgesteld woord: " + WordSuggester.suggestWord(possible));
		}
		
		
		
		reader.close();
	}
	
}
