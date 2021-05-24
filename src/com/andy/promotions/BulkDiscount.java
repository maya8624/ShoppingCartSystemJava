package com.andy.promotions;

import com.andy.bookings.Booking;

import java.util.List;

public class BulkDiscount implements Promotion {
    private String tourId;
    private double discountPrice;
    private double minTicketsForDiscount;

    public BulkDiscount(String tourId, double discountPrice, double minToursForDiscount) {
        this.tourId = tourId;
        this.discountPrice = discountPrice;
        this.minTicketsForDiscount = minToursForDiscount;
    }

    @Override
    public double calculateDiscount(List<Booking> bookings) {
        var booking =
                bookings.stream()
                        .filter(b -> b.getTourId().equals(tourId))
                        .findFirst()
                        .orElseThrow();

        return booking.getCount() < minTicketsForDiscount ?
                0 : booking.getCount() * discountPrice;
    }
}
