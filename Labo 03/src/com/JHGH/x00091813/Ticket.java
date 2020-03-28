package com.JHGH.x00091813;

import javax.swing.*;

public class Ticket {
    //atributos
    private Automovil automovil;
    private RegistroTiempo registroTiempo;

    //contructor de entrada
    public Ticket(String placa, int h, int min) {
        automovil = new Automovil(placa);
        registroTiempo = new RegistroTiempo(h, min);
    };

    //getters
    public String getPlaca() {
        return automovil.getPlaca();
    }

    //metodos
    public void salirParqueo() {
        int h, min;
        do {
            h = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese hora primero seguido de minutos de salida.\nHora :"));
        } while (0 > h || 24 < h || h < registroTiempo.getHoraEntrada());
        if (h == registroTiempo.getHoraEntrada()) {
            do {
                min = Integer.parseInt(JOptionPane.showInputDialog(null, "Minutos :"));
            } while (0 > min || 59 < min || min <= registroTiempo.getMinutoEntrada());
        }
        else {
            do {
                min = Integer.parseInt(JOptionPane.showInputDialog(null, "Minutos :"));
            } while (0 > min || 59 < min);
        }
        registroTiempo.setHoraSalida(h);
        registroTiempo.setMinutoSalida(min);
        JOptionPane.showMessageDialog(null, "Monto a pagar: " + registroTiempo.costoEstadia());
        if (registroTiempo.costoEstadia() > 0)
            Moneda.pago(registroTiempo.costoEstadia());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "placa automovil: " + automovil.getPlaca() +
                ", hora de entrada: " + registroTiempo.getHoraEntrada() + ":" +
                registroTiempo.getMinutoEntrada() +
                '}';
    }
}
