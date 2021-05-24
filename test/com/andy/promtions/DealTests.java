package com.andy.promtions;

import com.andy.bookings.Booking;
import com.andy.bookings.MockBooking;
import com.andy.promotions.Deal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealTests {
    String tourId = "OH";
    int minTicketsForOneFree = 3;
    Deal deal = new Deal(tourId, minTicketsForOneFree);

    MockBooking mock = new MockBooking();
    List<Booking> bookings = mock.getBookings();
    Booking booking =
            bookings.stream()
                    .filter(b -> b.getTourId().equals(tourId))
                    .findFirst()
                    .orElseThrow();

    @Test
    public void calculateTotalDiscountWithOneBooking() {
        // Arrange
        int tickets = 1;
        booking.setCount(tickets);
        booking.setTotal(tickets * booking.getPrice());

        // Action
        var result = deal.calculateDiscount(bookings);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void calculateTotalDiscountWithThreeTickets() {
        // Arrange
        int tickets = 3;
        booking.setCount(tickets);
        booking.setTotal(tickets * booking.getPrice());

        // Action
        var result = deal.calculateDiscount(bookings);

        // Assert
        assertEquals(300, result);
    }

    @Test
    public void calculateTotalDiscountWithSevenTickets() {
        // Arrange
        int tickets = 7;
        booking.setCount(tickets);
        booking.setTotal(tickets * booking.getPrice());

        // Action
        var result = deal.calculateDiscount(bookings);

        // Assert
        assertEquals(600, result);
    }
}
