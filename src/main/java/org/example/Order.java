package org.example;

import java.util.Date;
import java.util.List;

public class Order {
    private Date timestamp;
    private String stewName;
    private int price;
    public Order(String stewName, int price){
        this.price = price;
        this.stewName = stewName;
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getPrice() {
        return price;
    }

    public String getStewName() {
        return stewName;
    }
}
