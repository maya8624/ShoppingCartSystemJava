package com.andy.promotions;

import com.andy.bookings.Booking;

import java.util.List;

public class Deal implements Promotion {
    private String tourId;
    private int minTicketsForOneFree;

    public Deal(String tourId, int minToursForOneFree) {
        this.tourId = tourId;
        this.minTicketsForOneFree = minToursForOneFree;
    }

    public double calculateDiscount(List<Booking> bookings) {
        var booking =
                bookings.stream()
                        .filter(b -> b.getTourId().equals(tourId))
                        .findFirst()
                        .orElseThrow();

        int freebies = booking.getCount() / minTicketsForOneFree;
        return freebies * booking.getPrice();
    }
}
