package com.andy.promotions;

import com.andy.bookings.Booking;

import java.util.List;

public class FreeTour implements Promotion {
    private String tourId;
    private String freeTourId;

    public FreeTour(String tourId, String freeTourId) {
        this.tourId = tourId;
        this.freeTourId = freeTourId;
    }

    @Override
    public double calculateDiscount(List<Booking> bookings) {
        var booking =
                bookings.stream()
                    .filter(b -> b.getTourId().equals(tourId))
                    .findFirst()
                    .orElseThrow();

        var possibleFreeBooking =
                bookings.stream()
                    .filter(b -> b.getTourId().equals(freeTourId))
                    .findFirst()
                    .orElseThrow();

        int bookingCount = booking.getCount();
        int possibleFreeBookingCount = possibleFreeBooking.getCount();

        if (bookingCount <= 0 || possibleFreeBookingCount <= 0)
            return 0;

        int differences = bookingCount - possibleFreeBookingCount;
        return (differences >= 0 ) ?
                possibleFreeBookingCount * possibleFreeBooking.getPrice() :
                bookingCount * possibleFreeBooking.getPrice();
    }
}
