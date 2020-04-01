package com.JHGH.x00091813;

abstract class ReusableItem extends Item {
    //atributos
    protected int remainingUses;

    //contructores
    public ReusableItem(int id, String name, int weight, String description, int remainingUses) {
        super(id, name, weight, description);
        this.remainingUses = remainingUses;
    }

    public ReusableItem(int remainingUses) {
        this.remainingUses = remainingUses;
    }

    public ReusableItem() {
    }

    //metodos
    public void reduceUse() {

    }

    public boolean use() {
        return true;
    }
}
