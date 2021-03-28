package com.avvillas.challenge.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterUtil {	
	
	public static List<Character> convertStringToList(String word){
		
		List<Character> response = new ArrayList<>();
		for(int i=0; i<word.length();i++) {
			response.add(word.charAt(i));
		}	
		
		return response;		
	}
	
	public static List<String> convertSentenceToList(String sentence){		
		String[] words = sentence.split(" ");				
		return Arrays.asList(words);		
	}
	
}
