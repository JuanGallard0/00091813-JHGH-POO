package com.JHGH.x00091813;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	    System.out.print("Ingrese una frase: ");
	    String frase = in.nextLine();
	    String fraseInvertida = "";
	    for (int i = frase.length(); i > 0; i--)
	        fraseInvertida += frase.charAt(i - 1);
	    if (frase.equalsIgnoreCase(fraseInvertida))
	    	System.out.println("La frase es palindrome.");
	    else
	    	System.out.println("La frase no es palindrome.");
    }
}
