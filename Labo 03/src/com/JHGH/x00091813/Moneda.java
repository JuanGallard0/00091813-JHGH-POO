package com.JHGH.x00091813;

import javax.swing.*;

public final class Moneda {
    //atributos static
    private static float cincoC = 0.05f, diezC = 0.1f, cora = 0.25f, dolar = 1;
    private static float montoTotal = 0;

    //constructor static
    private Moneda() {
    }

    //metodos static
    public static void pago(float costoEstadia) {
        float montoAcumulado;
        int choice, cantidad;
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(null, "\n1)0.05USD\n2)0.10USD" +
                    "\n3)0.25USD\n4)1USD\nSeleccione el tipo de moneda a insertar:"));
            cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad a insertar: "));
            switch (choice) {
                case 1:
                    montoAcumulado = cincoC * cantidad;
                    break;
                case 2:
                    montoAcumulado = diezC * cantidad;
                    break;
                case 3:
                    montoAcumulado = cora * cantidad;
                    break;
                case 4:
                    montoAcumulado = dolar * cantidad;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (montoAcumulado < costoEstadia);
        float vuelto = montoAcumulado - costoEstadia;
        JOptionPane.showMessageDialog(null, "Pago realizado con exito!\nSu vuelto es: " +
                vuelto + "USD");
        montoTotal += costoEstadia;
        JOptionPane.showMessageDialog(null, "Ventas actuales: " + montoTotal + "USD");
    }
}


