package org.example;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Order> orders;
    public History(){
        this.orders = new ArrayList<>();
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public List<Order> getOrders(){
        return new ArrayList<>(orders);
    }


}
