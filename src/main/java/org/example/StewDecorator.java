package org.example;

public abstract class StewDecorator implements Stew {
    public  Stew stew;
    public StewDecorator(Stew stew){
        this.stew = stew;
    }
    @Override
    public String getName() {
        return stew.getName();
    }

    @Override
    public int getCost() {
        return stew.getCost();
    }
}
