package com.JHGH.x00091813;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese n: ");
        int n = in.nextInt(); in.nextLine();
        int[] fibonacciMemory = new int[n];
        System.out.println("Primeros " + n + " terminos de Fibonacci: ");
        fibonacciMemory[0] = 0; fibonacciMemory[1] = 1;
        for (int i = 0; i < n; i++) {
            if (i > 1) {
                fibonacciMemory[i] = fibonacciMemory[i - 1] + fibonacciMemory[i - 2];
            }
            System.out.print(fibonacciMemory[i] + ", ");
        }
    }
}
