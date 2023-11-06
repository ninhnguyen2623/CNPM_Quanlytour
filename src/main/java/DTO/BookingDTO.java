package DTO;

import java.sql.Date;

public class BookingDTO {
    private int booking_id;
    private int tour_id;
    private int customer_id;
    private int customer_number;
    private double total_cost;

    private String create_at;

    public BookingDTO() {
        total_cost = 0;

    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(int customer_number) {
        this.customer_number = customer_number;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

	@Override
	public String toString() {
		return "BookingDTO [booking_id=" + booking_id + ", tour_id=" + tour_id + ", customer_id=" + customer_id
				+ ", customer_number=" + customer_number + ", total_cost=" + total_cost + ", create_at=" + create_at
				+ "]";
	}
    
}
