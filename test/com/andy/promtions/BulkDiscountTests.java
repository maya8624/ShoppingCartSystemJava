package com.andy.promtions;

import com.andy.bookings.Booking;
import com.andy.bookings.MockBooking;
import com.andy.promotions.BulkDiscount;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulkDiscountTests {
    String tourId = "BC";
    double discountPrice = 20;
    int minTicketsForDiscount = 5;
    BulkDiscount bulkDiscount = new BulkDiscount(tourId, discountPrice, minTicketsForDiscount);

    MockBooking mock = new MockBooking();
    List<Booking> bookings = mock.getBookings();
    Booking booking =
            bookings.stream()
                    .filter(b -> b.getTourId().equals(tourId))
                    .findFirst()
                    .orElseThrow();

    @Test
    public void calculateTotalDiscountWithOneTicket() {
        // Arrange
        int tickets = 1;
        booking.setCount(tickets);
        booking.setTotal(booking.getPrice() * tickets);

        // Action
        var result = bulkDiscount.calculateDiscount(bookings);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void calculateTotalDiscountWithFiveTickets() {
        // Arrange
        int tickets = 5;
        booking.setCount(tickets);
        booking.setTotal(booking.getPrice() * tickets);

        // Action
        var result = bulkDiscount.calculateDiscount(bookings);

        // Assert
        assertEquals(100, result);
    }

    @Test
    public void calculateTotalDiscountWithSevenTickets() {
        // Arrange
        int tickets = 7;
        booking.setCount(tickets);
        booking.setTotal(booking.getPrice() * tickets);

        // Action
        var result = bulkDiscount.calculateDiscount(bookings);

        // Assert
        assertEquals(140, result);
    }
}
