package com.andy.services;

import com.andy.promotions.BulkDiscount;
import com.andy.promotions.Deal;
import com.andy.promotions.FreeTour;
import com.andy.promotions.Promotion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTests {
    ArrayList<Promotion> promotions = new ArrayList<>();
    ShoppingCart cart = new ShoppingCart(promotions);

    @Test
    void total_CalculateTotalDiscountByThreeForTwoDeal() {
        promotions.add(new Deal("OH", 3));

        cart.add("OH");
        cart.add("OH");
        cart.add("OH");
        cart.add("BC");

        var result = cart.total();
        assertEquals(710.00, result);
    }

    @Test
    void total_CalculateTotalDiscountByBulkDiscount() {
        promotions.add(new BulkDiscount("BC", 20, 5));

        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("BC");
        cart.add("OH");

        var result = cart.total();
        assertEquals(750, result);
    }

    @Test
    void total_CalculateTotalDiscountByFreeTour() {
        promotions.add(new FreeTour("OH", "SK"));

        cart.add("OH");
        cart.add("SK");

        var result = cart.total();
        assertEquals(300, result);
    }
}
