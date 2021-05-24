package com.andy.promotions;

import com.andy.bookings.Booking;

import java.util.List;

public interface Promotion {
    double calculateDiscount(List<Booking> bookings);
}
