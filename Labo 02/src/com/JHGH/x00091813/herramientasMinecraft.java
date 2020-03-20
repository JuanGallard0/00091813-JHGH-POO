package com.JHGH.x00091813;

import java.util.ArrayList;

public class herramientasMinecraft {
    //atributos
    private String tipo;
    private String material;
    private int daño;
    private int durabilidad;
    private Boolean encantamiento;

    //constructores
    public herramientasMinecraft(String tipo, String material, int daño, int durabilidad, Boolean encantamiento) {
        this.tipo = tipo;
        this.material = material;
        this.daño = daño;
        this.durabilidad = durabilidad;
        this.encantamiento = encantamiento;
    }

    //getters
    public String getTipo() {
        return tipo;
    }

    //metodos
    @Override
    public String toString() {
        return "herramientasMinecraft{" +
                "tipo='" + tipo + '\'' +
                ", material='" + material + '\'' +
                ", daño=" + daño +
                ", durabilidad=" + durabilidad +
                ", encantamiento=" + encantamiento +
                '}';
    }

    public void IncrementarDurabilidad() {
        durabilidad += 100;
    }

    public void AplicarEncantamiento() {
        encantamiento = true;
    }
}
