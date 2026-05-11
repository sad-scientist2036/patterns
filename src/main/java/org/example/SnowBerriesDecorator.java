package org.example;

public class SnowBerriesDecorator extends StewDecorator{
    public SnowBerriesDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return super.getName() + " со снежными ягодами";
    }

    @Override
    public int getCost() {
        return super.getCost() + 6;
    }
}
