package org.example;

public class HotSauceDecorator extends StewDecorator{
    public HotSauceDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return stew.getName() + " с огненным соусом";
    }

    @Override
    public int getCost() {
        return stew.getCost() + 10;
    }
}
