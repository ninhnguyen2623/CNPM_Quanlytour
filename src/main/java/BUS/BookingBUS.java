package BUS;

import DAO.BookingDAO;
import DAO.Booking_DetailDAO;
import DAO.CustomerDAO;
import DTO.*;

import java.util.ArrayList;

public class BookingBUS {

    BookingDAO booking ;
    Booking_DetailDAO booking_detail ;

    public BookingBUS() {
        booking = new BookingDAO();
        booking_detail = new Booking_DetailDAO();
    }
    public ArrayList<BookingDTO> getAll() {
        return booking.getAll();
    }

    public String add(BookingDTO bookingDTO, ArrayList<Booking_DetailDTO> bds) {

        if (booking.checkExistById(bookingDTO.getBooking_id())) {
            return "ID hoá đơn booking đã tồn tại";
        }

        if (!booking.add(bookingDTO))
            return "Thêm booking thất bại!";


        for (Booking_DetailDTO bddo : bds) {
            booking_detail.add(bddo);
        }

        return "thêm booking thành công!";

    }
    public String update(BookingDTO bookingDTO, ArrayList<Booking_DetailDTO> bds) {

        if (!booking.checkExistById(bookingDTO.getBooking_id())) {
            return "ID hoá đơn bill Không tồn tại";
        }

        if (!booking.update(bookingDTO))
            return "Cập nhật bill thất bại!";

        if (!booking_detail.delete(bookingDTO.getBooking_id())){
            return "Có lỗi xảy ra trong quá trình xoá booking_id trong booking_detail";
        }

        for (Booking_DetailDTO bddo : bds) {
            booking_detail.add(bddo);
        }

        return "Cập nhật bill thành công!";

    }

    public String delete (int id) {
        if (booking.delete(id)) {
            return "Xoá thành công!";
        }
        else return "Xoá thất bại!";
    }

    public BookingDTO getById(int id) {
        return booking.getById(id);
    }

    public ArrayList<ServiceDTO> getServicesOfBooking(int id) {
        return booking.getServicesOfBooking(id);
    }

    public CustomerDTO getCustomerOfBooking (int customer_id) {
        CustomerDAO cusDAO = new CustomerDAO();
        return cusDAO.getById(customer_id);
    }
    public String addExcel(BookingDTO bookingDTO) {

        if (booking.checkExistById(bookingDTO.getBooking_id())) {
            return "ID hoá đơn booking đã tồn tại";
        }

        if (!booking.add(bookingDTO)) {
        	return "Thêm booking thất bại!";        	
        }
        else {
        	booking.add(bookingDTO);
        	return "thêm booking thành công!";
        }

    }
}
