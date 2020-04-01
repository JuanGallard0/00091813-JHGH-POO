package com.JHGH.x00091813;

abstract class Item {
    //atributos
    protected int id;
    protected String name;
    protected int weight;
    protected String description;

    //constructores
    public Item(int id, String name, int weight, String description) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.description = description;
    }

    public Item() {
    }

    //getters
    public int getId() {
        return id;
    }
}
