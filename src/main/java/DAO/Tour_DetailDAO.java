package DAO;

import DTO.Tour_DetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tour_DetailDAO implements DAO<Tour_DetailDTO> {
    @Override
    public ArrayList<Tour_DetailDTO> getAll() {
        return null;
    }

    @Override
    public Tour_DetailDTO getById(int id) {
        return null;
    }

    @Override
    public boolean add(Tour_DetailDTO tourDetailDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into tour_detail (tour_id,place_id) value (?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,tourDetailDTO.getTour_id());
            st.setInt(2,tourDetailDTO.getPlace_id());
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
    public boolean update(Tour_DetailDTO tourDetailDTO) {
        return false;
    }

    @Override
    public boolean delete(int tour_id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "delete from tour_detail where tour_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,tour_id);
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
