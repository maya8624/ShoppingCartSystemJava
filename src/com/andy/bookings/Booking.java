package com.andy.bookings;

public class Booking {
    private String tourId;
    private double price;
    private int count;
    private double total;

    public Booking(String tourId, double price, int count, double total) {
        this.tourId = tourId;
        this.price = price;
        this.count = count;
        this.total = total;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

