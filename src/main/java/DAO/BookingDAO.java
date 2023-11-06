package DAO;

import DTO.BookingDTO;
import DTO.PlaceDTO;
import DTO.ServiceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAO implements DAO<BookingDTO> {
	public static BookingDAO getInstance() {
		return new BookingDAO();
	}
    @Override
    public ArrayList<BookingDTO> getAll() {
        ArrayList<BookingDTO> arr = new ArrayList<BookingDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from booking";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                BookingDTO booking = new BookingDTO();
                booking.setBooking_id(rs.getInt("booking_id"));
                booking.setTour_id(rs.getInt("tour_id"));
                booking.setCustomer_id(rs.getInt("customer_id"));
                booking.setCustomer_number(rs.getInt("customer_number"));
                booking.setTotal_cost(rs.getDouble("total_cost"));
                booking.setCreate_at(rs.getString("create_at"));
                arr.add(booking);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return arr;
    }

    @Override
    public BookingDTO getById(int id) {
        BookingDTO booking = new BookingDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from booking where booking_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                booking.setBooking_id(rs.getInt("booking_id"));
                booking.setTour_id(rs.getInt("tour_id"));
                booking.setCustomer_id(rs.getInt("customer_id"));
                booking.setCustomer_number(rs.getInt("customer_number"));
                booking.setTotal_cost(rs.getDouble("total_cost"));
                booking.setCreate_at(rs.getString("create_at"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return booking;
    }

    @Override
    public boolean add(BookingDTO bookingDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into booking (booking_id,tour_id,customer_id,customer_number,total_cost) value (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,bookingDTO.getBooking_id());
            st.setInt(2,bookingDTO.getTour_id());
            st.setInt(3,bookingDTO.getCustomer_id());
            st.setInt(4,bookingDTO.getCustomer_number());
            st.setDouble(5,bookingDTO.getTotal_cost());

            if (st.executeUpdate()>=1)
                result = true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    @Override
    public boolean update(BookingDTO bookingDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "update booking set " +
                    "tour_id=?, " +
                    "customer_id=?," +
                    "customer_number=? ," +
                    "total_cost=? "+
                    "where booking_id = " + bookingDTO.getBooking_id();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,bookingDTO.getTour_id());
            st.setInt(2,bookingDTO.getCustomer_id());
            st.setInt(3,bookingDTO.getCustomer_number());
            st.setDouble(4,bookingDTO.getTotal_cost());

            if (st.executeUpdate()>=1)
                result = true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "delete from booking where booking_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            if (st.executeUpdate()>=1)
                result = true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    @Override
    public boolean checkExistById(int id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "select * from booking where booking_id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    public ArrayList<ServiceDTO> getServicesOfBooking (int id) {
        ArrayList<ServiceDTO> services = new ArrayList<ServiceDTO>();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "\n" +
                    "SELECT * from service p\n" +
                    "WHERE p.service_id IN (\n" +
                    "  SELECT td.service_id FROM booking_detail td\n" +
                    "  where ? = td.booking_id\n" +
                    ")";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ServiceDTO service = new ServiceDTO();
                service.setService_id(rs.getInt("service_id"));
                service.setService_name(rs.getString("service_name"));
                service.setService_price(rs.getDouble("service_price"));

                services.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        finally {
            conndb.closeConnection();
        }
        return services;
    }
}
