package org.example;

public class HotSauceDecorator extends StewDecorator{
    public HotSauceDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return super.getName() + " с огненным соусом";
    }

    @Override
    public int getCost() {
        return super.getCost() + 10;
    }
}
