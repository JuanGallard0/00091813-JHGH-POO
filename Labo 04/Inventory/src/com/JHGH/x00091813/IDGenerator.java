package com.JHGH.x00091813;

public final class IDGenerator {
    //atributos
    private static int count = 0;

    //constructores
    private IDGenerator() {

    }

    //metodos
    public static int generateID() {
        count++;
        return count;
    }
}
