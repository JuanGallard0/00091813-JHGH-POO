package com.JHGH.x00091813;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    System.out.print("Ingrese frase: ");
	    String frase = in.nextLine();
	    ArrayList<Character> vocalesFrase = new ArrayList<>();
	    frase = frase.toLowerCase();
	    for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' ||
					frase.charAt(i) == 'o' || frase.charAt(i) == 'u')
				vocalesFrase.add(frase.charAt(i));
		}
	    for (int i = 0; i < vocalesFrase.size(); i++)
			System.out.print(vocalesFrase.get(i) + " ,");
    }
}
