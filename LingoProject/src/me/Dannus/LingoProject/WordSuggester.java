package me.Dannus.LingoProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class WordSuggester {

	static String suggestWord(List<String> list) {
		
		Map<Integer, String> wordScore = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			
			
			String input = list.get(i);
			int score = 5000;
			
			Map<Character, Integer> charCounter = new HashMap<>();
			for (char c : input.replaceAll("\\s+", "").toCharArray()) {
			    Integer count = charCounter.get(c);
			    count = count == null ? 0 : count;
			    charCounter.put(c, count + 1);
			}
			
			for (Entry<Character, Integer> set : charCounter.entrySet()) {
				if (set.getValue() == 3) {
					score = score - 2000;
				} else if (set.getValue() == 2) {
					score = score - 1000;
				}
	        }
			
			for (Entry<Character, Integer> set : charCounter.entrySet()) {
				if (set.getKey().equals('e')) {
					score = score + 1891;
				} else if (set.getKey().equals('n')) {
					score = score + 1003;
				} else if (set.getKey().equals('a')) {
					score = score + 748;
				} else if (set.getKey().equals('t')) {
					score = score + 679;
				} else if (set.getKey().equals('i')) {
					score = score + 649;
				} else if (set.getKey().equals('r')) {
					score = score + 611;
				} else if (set.getKey().equals('o')) {
					score = score + 606;
				} else if (set.getKey().equals('d')) {
					score = score + 593;
				} else if (set.getKey().equals('k')) {
					score = score + 406;
				} else if (set.getKey().equals('l')) {
					score = score + 357;
				} else if (set.getKey().equals('s')) {
					score = score + 345;
				} else if (set.getKey().equals('g')) {
					score = score + 340;
				} else if (set.getKey().equals('v')) {
					score = score + 285;
				} else if (set.getKey().equals('h')) {
					score = score + 238;
				} else if (set.getKey().equals('m')) {
					score = score + 221;
				} else if (set.getKey().equals('u')) {
					score = score + 199;
				} else if (set.getKey().equals('b')) {
					score = score + 158;
				} else if (set.getKey().equals('p')) {
					score = score + 157;
				} else if (set.getKey().equals('w')) {
					score = score + 152;
				} else if (set.getKey().equals('j')) {
					score = score + 146;
				} else if (set.getKey().equals('z')) {
					score = score + 139;
				} else if (set.getKey().equals('c')) {
					score = score + 124;
				} else if (set.getKey().equals('f')) {
					score = score + 80;
				} else if (set.getKey().equals('x')) {
					score = score + 4;
				} else if (set.getKey().equals('y')) {
					score = score + 4;
				} else if (set.getKey().equals('q')) {
					score = score + 1;
				}
	        }
			
			wordScore.put(score, input);
		}
		
		

    	List<String> sorted = new ArrayList<String>();
		TreeMap<Integer, String> mapped = new TreeMap<>(wordScore);
        Set<Entry<Integer, String>> mappings = mapped.entrySet();
        for(Entry<Integer, String> mapping : mappings) {
        	sorted.add(mapping.getValue());
        }
		
        String suggesting = "";
        if (sorted.size() > 0) suggesting = suggesting + sorted.get(sorted.size() - 1);
        if (sorted.size() > 1) suggesting = suggesting + "," + sorted.get(sorted.size() - 2);
        if (sorted.size() > 2) suggesting = suggesting + "," + sorted.get(sorted.size() - 3);
        if (sorted.size() > 3) suggesting = suggesting + "," + sorted.get(sorted.size() - 4);
        if (sorted.size() > 4) suggesting = suggesting + "," + sorted.get(sorted.size() - 5);
        if (sorted.size() > 5) suggesting = suggesting + "," + sorted.get(sorted.size() - 6);
        if (sorted.size() > 6) suggesting = suggesting + "," + sorted.get(sorted.size() - 7);
        if (sorted.size() > 7) suggesting = suggesting + "," + sorted.get(sorted.size() - 8);
        if (sorted.size() > 8) suggesting = suggesting + "," + sorted.get(sorted.size() - 9);
        if (sorted.size() > 9) suggesting = suggesting + "," + sorted.get(sorted.size() - 10);
        
		return suggesting;
	}
	
}
