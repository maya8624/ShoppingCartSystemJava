package com.andy.bookings;

import java.util.List;

public class MockBooking {
    private final List<Booking> bookings;

    public MockBooking() {
        bookings = List.of(
            new Booking("OH", 300.00, 0, 0),
            new Booking("BC", 110.00, 0, 0),
            new Booking("SK", 30.00, 0, 0)
        );
    }

    public List<Booking> getBookings() {
        System.out.println(bookings);
        return bookings;
    }
}
