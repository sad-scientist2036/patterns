package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stew stew = new BasicStew();
        Stew dopstew = new NordicFlatbreadDecorator(stew);
        Stew dopdopstew = new HotSauceDecorator(dopstew);
        System.out.println(dopdopstew.getName());
    }
}