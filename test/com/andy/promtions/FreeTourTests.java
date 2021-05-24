package com.andy.promtions;

import com.andy.bookings.Booking;
import com.andy.bookings.MockBooking;
import com.andy.promotions.FreeTour;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeTourTests {
    String tourId = "OH";
    String freeTourId = "SK";
    FreeTour freeTour = new FreeTour(tourId, freeTourId);

    MockBooking mock = new MockBooking();
    List<Booking> bookings = mock.getBookings();

    Booking ohBooking =
            bookings.stream()
                    .filter(b -> b.getTourId().equals(tourId))
                    .findFirst()
                    .orElseThrow();

    Booking skBooking =
            bookings.stream()
                    .filter(b -> b.getTourId().equals(freeTourId))
                    .findFirst()
                    .orElseThrow();

    @Test
    public void calculateTotalDiscountWithOnlyOneSkyTower() {
        // Arrange
        int ohTickets = 0;
        int skTickets = 1;

        ohBooking.setCount(ohTickets);
        ohBooking.setTotal(ohTickets * ohBooking.getPrice());

        skBooking.setCount(skTickets);
        skBooking.setTotal(skTickets * skBooking.getPrice());

        // Action
        var result = freeTour.calculateDiscount(bookings);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void calculateTotalDiscountWithOneOperaAndTwoSkyTower() {
        // Arrange
        int ohTickets = 1;
        int skTickets = 2;

        ohBooking.setCount(ohTickets);
        ohBooking.setTotal(ohTickets * ohBooking.getPrice());

        skBooking.setCount(skTickets);
        skBooking.setTotal(skTickets * skBooking.getPrice());

        // Action
        var result = freeTour.calculateDiscount(bookings);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void calculateTotalDiscountWithOneOperaHouseAndOneSkyTower() {
        // Arrange
        int ohTickets = 1;
        int skTickets = 1;

        ohBooking.setCount(ohTickets);
        ohBooking.setTotal(ohTickets * ohBooking.getPrice());

        skBooking.setCount(skTickets);
        skBooking.setTotal(skTickets * skBooking.getPrice());

        // Action
        var result = freeTour.calculateDiscount(bookings);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void calculateTotalDiscountWithThreeOperaHouseAndOneSkyTower() {
        // Arrange
        int ohTickets = 3;
        int skTickets = 2;

        ohBooking.setCount(ohTickets);
        ohBooking.setTotal(ohTickets * ohBooking.getPrice());

        skBooking.setCount(skTickets);
        skBooking.setTotal(skTickets * skBooking.getPrice());

        // Action
        var result = freeTour.calculateDiscount(bookings);

        // Assert
        assertEquals(60, result);
    }
}
