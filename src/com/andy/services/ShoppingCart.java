package com.andy.services;

import com.andy.bookings.Booking;
import com.andy.bookings.MockBooking;
import com.andy.promotions.Deal;
import com.andy.promotions.Promotion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private double sum;
    private final List<Booking> bookings;
    private MockBooking mockBooking;

    private ArrayList<Promotion> promotions;

    public ShoppingCart(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
        this.mockBooking = new MockBooking();
        bookings = mockBooking.getBookings();
    }

    public void add(String tourId) {
        var booking =
                bookings.stream()
                        .filter(b -> b.getTourId().equals(tourId))
                        .findFirst()
                        .orElseThrow();

        booking.setCount(booking.getCount() + 1);
        booking.setTotal(booking.getTotal() + booking.getPrice());
        sum += booking.getPrice();
    }

    public double total() {
        double discount = 0;
        for(var promotion: promotions)
            discount += promotion.calculateDiscount(bookings);

        return sum - discount;
    }
}
