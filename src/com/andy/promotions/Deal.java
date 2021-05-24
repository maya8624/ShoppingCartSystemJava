package com.andy.promotions;

import com.andy.bookings.Booking;

import java.util.List;

public class Deal implements Promotion {
    private String tourId;
    private int minToursForOneFree;

    public Deal(String tourId, int minToursForOneFree) {
        this.tourId = tourId;
        this.minToursForOneFree = minToursForOneFree;
    }

    public double calculateDiscount(List<Booking> bookings) {
        var booking =
                bookings.stream()
                        .filter(b -> b.getTourId().equals(tourId))
                        .findFirst()
                        .orElseThrow();

        int freebies = booking.getCount() / minToursForOneFree;
        return freebies * booking.getPrice();
    }
}
