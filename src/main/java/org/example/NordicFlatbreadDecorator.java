package org.example;

public class NordicFlatbreadDecorator extends StewDecorator{
    public NordicFlatbreadDecorator(Stew stew){
        super(stew);
    }
    @Override
    public String getName() {
        return stew.getName() + " с нордской лепешкой";
    }

    @Override
    public int getCost() {
        return stew.getCost() + 7;
    }
}
