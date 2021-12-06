package fr.eni.demo;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// declaring
		String s1 = "une chaine";
		System.out.println(s1);
		
		String s2 = new String("une autre chaine");
		System.out.println(s2);
		
		char[] s3 = new char[5];
		System.out.println(s3);
		
		char[] s4 = {'M', 'a', 'r', 'd', 'i'};
		System.out.println(Arrays.toString(s4));
		String s5 = new String(s4); // [M, a, r, d, i]
		System.out.println(s5); // Mardi
		
		char[] s6 = s2.toCharArray();
		System.out.println(Arrays.toString(s6)); // [u, n, e, , , a, u, t, r, e (...)]
		
		String s7 = "azerty";
		String s8 = "AZERTY";
		
		// comparing
		System.out.println(s7.equals(s8)); // false
		System.out.println(s7.equalsIgnoreCase(s8)); // true
		System.out.println(s7.toUpperCase().equals(s8)); // true
		
		String[] subStrings = s2.split("[n]");
		System.out.println(Arrays.toString(subStrings));
		
		// StringBuffer
		StringBuffer sb;
		sb = new StringBuffer("une chaine a taille variable");
		System.out.println(sb);
		sb.append("...");
		System.out.println(sb);
		
		System.out.println(sb.indexOf("taille")); // 13

	}

}
