package DAO;

import DTO.Booking_DetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Booking_DetailDAO implements DAO<Booking_DetailDTO> {
    @Override
    public ArrayList<Booking_DetailDTO> getAll() {
        return null;
    }

    @Override
    public Booking_DetailDTO getById(int id) {
        return null;
    }

    @Override
    public boolean add(Booking_DetailDTO bookingDetailDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into booking_detail (booking_id,service_id) value (?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,bookingDetailDTO.getBooking_id());
            st.setInt(2,bookingDetailDTO.getService_id());
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
    public boolean update(Booking_DetailDTO bookingDetailDTO) {
        return false;
    }

    @Override
    public boolean delete(int booking_id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "delete from booking_detail where booking_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,booking_id);
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
        return false;
    }
}
