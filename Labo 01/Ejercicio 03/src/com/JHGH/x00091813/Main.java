package com.JHGH.x00091813;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese n: ");
        int n = in.nextInt(); in.nextLine();
        System.out.println("Secuencia: ");
        secuencia(n, 1);
    }

    static void secuencia(int n, int i) {
        if (i < n) {
            System.out.print(i + ", ");
            secuencia(n, i + 1);
        }
        System.out.print(i + ", ");
    }
}
