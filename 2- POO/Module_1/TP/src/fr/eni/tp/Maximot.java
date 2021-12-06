package fr.eni.tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Maximot {
	public static final String DICT_FILE = "./dictionnaire.txt";
	public static final int NB_WORDS = 22506;
	public static final char EMPTY = ' ';
	public static Random r = new Random();
	
	private static char[] randomWord() throws IOException {
		int wordNum = r.nextInt(NB_WORDS);
		try (FileInputStream file = new FileInputStream(DICT_FILE); Scanner s = new Scanner(file)) {
			for(int i = 1; i <= wordNum; i++) {
				s.nextLine();
			}
			return s.nextLine().toUpperCase().toCharArray();
		} 
	}
	
	private static char[] shuffleWord(char[] word) {
		char[] shuffled = new char[word.length];
		for(int i = 0; i < word.length; i++) {
			shuffled[i] = word[i];
		}
		
		for(int i = 0; i < shuffled.length * 5; i++) {
			int x = r.nextInt(shuffled.length);
			int y = r.nextInt(shuffled.length);
			char temp = shuffled[x];
			shuffled[x] = shuffled[y];
			shuffled[y] = temp;
		}
		
		return shuffled;
	}
	
	private static void display(char[] word) {
		for(char letter: word) {
			System.out.print(letter);
		}
		System.out.println();
	}
	
	private static boolean checkLetters(char[] input, char[] word) {
		Arrays.sort(input);
		Arrays.sort(word);
		return Arrays.equals(input, word);
	}
	
	private static boolean isInDict(char[] word) throws IOException{
		boolean found = false;
		try (FileInputStream file = new FileInputStream(DICT_FILE); Scanner s = new Scanner(file)) {
			char[] dictWord;
			while(s.hasNext() && !found) {
				dictWord = s.nextLine().toUpperCase().toCharArray();
				found = Maximot.areIdentical(word, dictWord);
			}
		}
		return found;
	}
	
	private static boolean areIdentical(char[] word1, char[] word2) {
		boolean ok = word1.length == word2.length;
		if(ok) {
			int i = 0;
			while(ok && i < word1.length) {
				ok = word1[i] == word2[i];
				i++;
			}
		}
		return ok;
	}

	public static void main(String[] args) throws IOException {
		char[] wordToGuess = randomWord();
		char[] shuffledWord = shuffleWord(wordToGuess);
		System.out.println("Voici le tirage: ");
		display(shuffledWord);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisissez votre proposition: ");
		char[] input = scan.nextLine().toUpperCase().toCharArray();
		
		if(!checkLetters(input, shuffledWord)) {
			System.out.println("Lettre incorrecte");
		} else {
			if(!isInDict(input)) {
				System.out.println("Mot non présent dans le dictionnaire");
			} else {
				System.out.printf("Bravo, vous marquez %d points!", input.length);
			}
		}
		
		display(wordToGuess);
		scan.close();
	}

}
