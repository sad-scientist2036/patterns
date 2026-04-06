package org.example;

public class SnowBerriesDecorator extends StewDecorator{
    public SnowBerriesDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return stew.getName() + " со снежными ягодами";
    }

    @Override
    public int getCost() {
        return stew.getCost() + 6;
    }
}
