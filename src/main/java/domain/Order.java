package domain;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private double orderTotal;
    private String orderStatus;

    public Order() {
        super();
    }

    public Order(String orderStatus, int orderId, double orderTotal) {
        this.orderStatus = orderStatus;
        this.orderId = orderId;
        this.orderTotal = orderTotal;
    }

    public void createOrder(String Type){

    }
    public void delete (int id){

    }

    public void update(int id){

    }
    public void selectOrderById(int id){

    }
    public void selectAll(){

    }
}