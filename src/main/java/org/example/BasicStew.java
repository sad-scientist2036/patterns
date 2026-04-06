package org.example;

public class BasicStew implements Stew{
    @Override
    public String getName() {
        return "Похлебка";
    }

    @Override
    public int getCost() {
        return 50;
    }
}
