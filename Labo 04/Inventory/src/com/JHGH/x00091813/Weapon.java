package com.JHGH.x00091813;

public class Weapon extends ReusableItem {
    private String type;
    private double speed;
    private double damage;
    private String wieldType;
    private int level;

    //constructores
    public Weapon(int id, String name, int weight, String description, int remainingUses, String type, double speed, double damage, String wieldType, int level) {
        super(id, name, weight, description, remainingUses);
        this.type = type;
        this.speed = speed;
        this.damage = damage;
        this.wieldType = wieldType;
        this.level = level;
    }

    public Weapon(int remainingUses, String type, double speed, double damage, String wieldType, int level) {
        super(remainingUses);
        this.type = type;
        this.speed = speed;
        this.damage = damage;
        this.wieldType = wieldType;
        this.level = level;
    }

    public Weapon(String type, double speed, double damage, String wieldType, int level) {
        this.type = type;
        this.speed = speed;
        this.damage = damage;
        this.wieldType = wieldType;
        this.level = level;
    }

    public Weapon() {
    }

    //metodos
    public void upgrade() {
        level++;
        speed++;
        damage++;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type='" + type + '\'' +
                ", speed=" + speed +
                ", damage=" + damage +
                ", wieldType='" + wieldType + '\'' +
                ", level=" + level +
                ", remainingUses=" + remainingUses +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
