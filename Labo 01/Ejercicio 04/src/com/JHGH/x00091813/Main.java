package com.JHGH.x00091813;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese frase: ");
        String frase = in.nextLine();
        System.out.println("Frase modificada: " + frase.replace('a', 'b'));
    }
}
