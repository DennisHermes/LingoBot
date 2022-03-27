package me.Dannus.LingoProject;

import java.util.ArrayList;
import java.util.List;

public class LetterProcessor {

	static List<String> beginLetter(String letter, List<String> list) {
		
		return list;
	}
	
	
	
	static List<String> containingLetters = new ArrayList<String>();
	
	static List<String> redLetter(String letter, int pos, List<String> list) {
		
		if (!containingLetters.contains(letter)) {
			containingLetters.add(letter);
		}
		
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			
			//check for containing letters
			Character c = list.get(i).charAt(pos);
			if (c.equals(letter.charAt(0))) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}
	
	
	
	static List<String> yellowLetter(String letter, int pos, List<String> list) {
		
		if (!containingLetters.contains(letter)) {
			containingLetters.add(letter);
			
			List<String> newList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				
				//check for containing letters
				if (list.get(i).contains(letter.trim())) {
					Character c = list.get(i).charAt(pos);
					if (!c.equals(letter.charAt(0))) {
						newList.add(list.get(i));
					}
				}
			}
			return newList;
		} else {
			return list;
		}
	}
	
	
	
	static List<String> blankLetter(String letter, List<String> list) {
		
		if (!containingLetters.contains(letter)) {
			
			List<String> newList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				
				//check for containing letters
				if (!list.get(i).contains(letter.trim())) {
					newList.add(list.get(i));
				}
			}
			return newList;
		} else {
			return list;
		}
	}
	
}
