package me.Dannus.LingoProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	static int removed = 0;
	static String remove = "jalon,xeres";
	
	static List<String> wordSorter() {
		List<String> words = new ArrayList<String>();
		
		try {
			URL url = new URL("https://raw.githubusercontent.com/OpenTaal/opentaal-wordlist/master/wordlist.txt");
	        BufferedReader read = new BufferedReader(
	        new InputStreamReader(url.openStream()));
	        
	        String i;
	        while ((i = read.readLine()) != null) {
	        	
	        	i = i.trim();
	        	
	            if (i.contains("ij")) {
	            	if (i.length() == 6) {
	            		if (isAlpha(i)) {
	            			if (Character.isLowerCase(i.charAt(0))) {
	            				words.add(i.replaceAll("ij", "@"));
	            			}
	            		}
	            	}
	            } else {
	            	if (i.length() == 5) {
	            		if (isAlpha(i)) {
	            			if (Character.isLowerCase(i.charAt(0))) {
	            				words.add(i);
	            			}
	            		}
	            	}
	            }
	        }
	        
	        read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < remove.split(",").length; i++) {
			words.remove(remove.split(",")[i]);
			removed++;
		}
		
		return words;
	}
	
	public static boolean isAlpha(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }
	
}
