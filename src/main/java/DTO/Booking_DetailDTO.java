package DTO;

import DAO.Booking_DetailDAO;

import javax.accessibility.Accessible;

public class Booking_DetailDTO  {

    private int bd_id;
    private int booking_id;
    private int service_id;

    public Booking_DetailDTO(){}
    public int getBd_id() {
        return bd_id;
    }

    public void setBd_id(int bd_id) {
        this.bd_id = bd_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
}
