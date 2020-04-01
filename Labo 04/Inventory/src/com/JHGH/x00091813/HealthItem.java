package com.JHGH.x00091813;

abstract class HealthItem extends Item {
    //atributos
    protected int reuseTime;
    protected String level;
    protected String type;

    //constructores
    public HealthItem(int id, String name, int weight, String description, int reuseTime, String level, String type) {
        super(id, name, weight, description);
        this.reuseTime = reuseTime;
        this.level = level;
        this.type = type;
    }

    public HealthItem(int reuseTime, String level, String type) {
        this.reuseTime = reuseTime;
        this.level = level;
        this.type = type;
    }

    public HealthItem() {
    }

    //metodos
    abstract void drink();
}
