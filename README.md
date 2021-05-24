# Shopping Cart System
Assume already got a list of tour records. TourId, Price 

# src
- promotions
  - Classes
    1. BulkDiscount: calculate the total discount price by Bulk Discount rules.
    2. Deal: calculate the total discount price by three for two deal rules
    3. FreeTour: calculate the total discount price by free tour rules
  
  - Interfaces
    1. Promotion: has calculateTotal(List bookings) method all promotion classes should implement this method.
      
- services
  - Classes
    1. ShoppingCart
      - add(tourId) method: update "count, total" columns in the tour booking record by tourId and add the "tour total" to "sum" variable to keep the total for all bookings.
      - total() method: calculate the total for all bookings and return the value "sum(all bookings total) - promotion discount"

- bookings
  - Classes
    1. Booking: properties for Booking.
    2. MockBocking: moking data for test

 # test - using JUnit
- promotions: BuldDiscountTests, DealTests, FreeTourTests
- services: ShoppingCartTests
