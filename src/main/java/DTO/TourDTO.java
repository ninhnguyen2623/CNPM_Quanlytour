/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class TourDTO {
    private int tour_id;
    private String tour_name;

    private int hotel_id;

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    private String region_code;
    private double price;
    private String start_day;
    private String end_day;
    private int vehicle_id;
    private String departure_place;
    private String schedule_describe;
    private String create_at;
    public TourDTO(int tour_id, String tour_name,  int hotel_id,int vehicle_id, double price, String start_day, String end_day, String departure_place, String schedule_describe, String create_at) {
        this.tour_id = tour_id;
        this.tour_name = tour_name;

        this.hotel_id = hotel_id;
        this.vehicle_id = vehicle_id;
        this.price = price;
        this.start_day = start_day;
        this.end_day = end_day;
        this.departure_place = departure_place;
        this.schedule_describe = schedule_describe;
        this.create_at = create_at;
    }

    public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public TourDTO() {

    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public String getSchedule_describe() {
        return schedule_describe;
    }

    public void setSchedule_describe(String schedule_describe) {
        this.schedule_describe = schedule_describe;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

//	@Override
//	public String toString() {
//		return "TourDTO [tour_id=" + tour_id + ", tour_name=" + tour_name + ", tourguide_id=" + tourguide_id
//				+ ", hotel_id=" + hotel_id + ", price=" + price + ", start_day=" + start_day + ", end_day=" + end_day
//				+ ", departure_place=" + departure_place + ", schedule_describe=" + schedule_describe + ", create_at="
//				+ create_at + "]";
//	}
    
}
