package com.JHGH.x00091813;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<herramientasMinecraft> listaHerramientas = new ArrayList<>();
        ArrayList<herramientasMinecraft> listaHerramientasClone = new ArrayList<>();
        Boolean menuExit = false;
        byte menuChoice = 0;
        String tipo;
        do {
            mainMenu();
            menuChoice = in.nextByte(); in.nextLine();
            switch (menuChoice) {
                case 1:
                    agregarHerramienta(listaHerramientas);
                    break;
                case 2:
                    listaHerramientas.forEach(s -> System.out.println("\t" + s.toString()));
                    break;
                case 3:
                    System.out.print("\tTipo: ");
                    tipo = in.nextLine();
                    for (int i = 0; i < listaHerramientas.size(); i++) {
                        if (listaHerramientas.get(i).getTipo().equals(tipo))
                            System.out.println("\t" + listaHerramientas.get(i).toString());
                    }
                    break;
                case 4:
                    listaHerramientas.forEach(herramientasMinecraft::IncrementarDurabilidad);
                    System.out.println("\tdurabilidad +100 en todas la herramientas");
                    break;
                case 5:
                    listaHerramientas.forEach(herramientasMinecraft::AplicarEncantamiento);
                    System.out.println("\tSe aplico un encantamiento a las herramientas");
                    break;
                case 6:
                    menuExit = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menuChoice);
            }
        } while (!menuExit);
    }

    public static void mainMenu() {
        System.out.print("ADMINISTRADOR DE HERRAMIENTAS:\n" +
                "\t1-Agregar herramienta\n" +
                "\t2-Consultar herramientas\n" +
                "\t3-Consultar herramientas de un tipo\n" +
                "\t4-Incrementar la durabilidad de las herramientas\n" +
                "\t5-Aplicar un encantamiento las herramientas\n" +
                "\t6-SALIR\n" +
                "Escoja una opcion:");
    }

    public static void agregarHerramienta(ArrayList lista) {
        String tipo, material; int daño, durabilidad; String encantamiento;
        System.out.print("\tIngrese tipo: ");
        tipo = in.nextLine();
        System.out.print("\tIngrese material: ");
        material = in.nextLine();
        System.out.print("\tIngrese daño: ");
        daño = in.nextInt(); in.nextLine();
        System.out.print("\tIngrese durabilidad: ");
        durabilidad = in.nextInt(); in.nextLine();
        System.out.print("\tPosee algun encantamiento (si/no)?: ");
        encantamiento = in.nextLine();
        if (encantamiento == "si")
            lista.add(new herramientasMinecraft(tipo, material, daño, durabilidad, true));
        else
            lista.add(new herramientasMinecraft(tipo, material, daño, durabilidad, false));
    }
}