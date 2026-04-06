package org.example;

public class DoubleVenisonDecorator extends StewDecorator{
    public DoubleVenisonDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return stew.getName() + " с двойной олениной";
    }

    @Override
    public int getCost() {
        return stew.getCost() + 20;
    }
}
