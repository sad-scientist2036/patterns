package org.example;

public class DoubleVenisonDecorator extends StewDecorator{
    public DoubleVenisonDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return super.getName() + " с двойной олениной";
    }

    @Override
    public int getCost() {
        return super.getCost() + 20;
    }
}
