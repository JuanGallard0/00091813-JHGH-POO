package com.JHGH.x00091813;

public class Potion extends HealthItem {
    //atributos
    private int amount;

    //constructores
    public Potion(int id, String name, int weight, String description, int reuseTime, String level, String type, int amount) {
        super(id, name, weight, description, reuseTime, level, type);
        this.amount = amount;
    }

    public Potion(int reuseTime, String level, String type, int amount) {
        super(reuseTime, level, type);
        this.amount = amount;
    }

    public Potion(int amount) {
        this.amount = amount;
    }

    public Potion() {
    }

    //metodos
    @Override
    public void drink() {
        if (amount > 0)
            amount--;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "amount=" + amount +
                ", reuseTime=" + reuseTime +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
