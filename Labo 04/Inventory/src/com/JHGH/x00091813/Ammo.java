package com.JHGH.x00091813;

public class Ammo extends ReusableItem {
    //atributos
    private boolean equipped;

    //constructores
    public Ammo(int id, String name, int weight, String description, int remainingUses, boolean equipped) {
        super(id, name, weight, description, remainingUses);
        this.equipped = equipped;
    }

    public Ammo(int remainingUses, boolean equipped) {
        super(remainingUses);
        this.equipped = equipped;
    }

    public Ammo(boolean equipped) {
        this.equipped = equipped;
    }

    public Ammo() {
    }

    //metodos
    public void equip() {
        if (equipped == false)
            equipped = true;
        else
            equipped = false;
    }

    @Override
    public String toString() {
        return "Ammo{" +
                "equipped=" + equipped +
                ", remainingUses=" + remainingUses +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
