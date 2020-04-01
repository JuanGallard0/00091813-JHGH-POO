package com.JHGH.x00091813;

public class Elixir extends HealthItem {
    //atributos
    private int amount;
    private int time;

    //constructores
    public Elixir(int id, String name, int weight, String description, int reuseTime, String level, String type, int amount, int time) {
        super(id, name, weight, description, reuseTime, level, type);
        this.amount = amount;
        this.time = time;
    }

    public Elixir(int reuseTime, String level, String type, int amount, int time) {
        super(reuseTime, level, type);
        this.amount = amount;
        this.time = time;
    }

    public Elixir(int amount, int time) {
        this.amount = amount;
        this.time = time;
    }

    public Elixir() {
    }

    //metodos
    @Override
    public void drink() {
        if (amount > 0)
            amount--;
    }

    @Override
    public String toString() {
        return "Elixir{" +
                "amount=" + amount +
                ", time=" + time +
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
