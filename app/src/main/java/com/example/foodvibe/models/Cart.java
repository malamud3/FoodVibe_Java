package com.example.foodvibe.models;

public class Cart {
    private Food_Order food_order;
    private String userName;
    public Cart(){}

    public Food_Order getFood_order() {
        return food_order;
    }

//    public void setFood_order(String food_order) {
//        this.food_order = food_order;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
