package com.JHGH.x00091813;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Ticket> listaTickets = new ArrayList<>();
        int choice, indice = -1;
	    do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(null, menuPrincipal()));
            switch (choice) {
                case 1:
                    listaTickets.add(ingresarAutomovil());
                    break;
                case 2:
                    if (!listaTickets.isEmpty()) {
                        indice = buscarTicket(listaTickets);
                        if (indice > -1) {
                            listaTickets.get(indice).salirParqueo();
                            listaTickets.remove(indice);
                            indice = -1;
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Fallo en la busqueda.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay tickets.");
                    };
                    break;
                case 3:
                    if (!listaTickets.isEmpty()) {
                        indice = buscarTicket(listaTickets);
                        if (indice > -1) {
                            JOptionPane.showMessageDialog(null, listaTickets.get(indice).toString());
                            indice = -1;
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Fallo en la busqueda.");

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No hay tickets.");
                    };
                    break;
                case 4:
                    choice = 0;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (choice != 0);
    }

    public static String menuPrincipal() {
        return "MENU:\n1)Ingresar automovil\n2)Salir del parqueo\n3)Consultar ticket\n4)Salir\nIngrese su eleccion: ";
    }

    public static Ticket ingresarAutomovil() {
        String placa = JOptionPane.showInputDialog(null, "Digite la placa:");
        int h, min;
        do {
            h = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese hora primero seguido de minutos de entrada.\nHora :"));
        } while (0 > h || 24 < h);
        do {
            min = Integer.parseInt(JOptionPane.showInputDialog(null, "Minutos :"));
        } while (0 > min || 59 < min);
        return new Ticket(placa, h, min);
    }

    public static int buscarTicket(ArrayList<Ticket> lista) {
        String placa = JOptionPane.showInputDialog(null, "Qué placa desea buscar?: ");
        for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getPlaca().equalsIgnoreCase(placa))
                    return i;
            }
        return -1;
    }
}
