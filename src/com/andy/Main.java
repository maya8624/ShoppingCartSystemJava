package com.andy;

import com.andy.promotions.BulkDiscount;
import com.andy.promotions.Deal;
import com.andy.promotions.FreeTour;
import com.andy.promotions.Promotion;
import com.andy.services.ShoppingCart;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Promotion> promotions = new ArrayList<>();
        promotions.add(new Deal("OH", 3));
        promotions.add(new BulkDiscount("BC", 20, 5));
        promotions.add(new FreeTour("OH", "SK"));

        var cart = new ShoppingCart(promotions);
//        cart.add("OH");
//        cart.add("OH");
//        cart.add("OH");
//        cart.add("BC");
//
//        cart.add("OH");
//        cart.add("SK");

        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("OH");

        var total = cart.total();
        System.out.println("Total: " + total);
    }
}
