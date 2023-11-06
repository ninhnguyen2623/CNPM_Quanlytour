package DAO;

import DTO.PlaceDTO;
import GUI.Manager;
import DTO.ServiceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class PlaceDAO implements DAO<PlaceDTO> {
		public static PlaceDAO getInstance() {
			return new PlaceDAO();
		}

    @Override
    public ArrayList<PlaceDTO> getAll() {
        ArrayList<PlaceDTO> arr = new ArrayList<PlaceDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from place";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                PlaceDTO place = new PlaceDTO();
                place.setPlace_id(rs.getInt("place_id"));
                place.setPlace_name(rs.getString("place_name"));
                place.setPlace_describe(rs.getString("place_describe"));
                place.setPlace_address(rs.getString("place_address"));
                place.setRegion_code(rs.getString("region_code"));
                arr.add(place);
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
    public PlaceDTO getById(int id) {
        PlaceDTO place = new PlaceDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from place where place_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                place.setPlace_id(rs.getInt("place_id"));
                place.setPlace_name(rs.getString("place_name"));
                place.setPlace_describe(rs.getString("place_describe"));
                place.setPlace_address(rs.getString("place_address"));
                place.setRegion_code(rs.getString("region_code"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return place;
    }

    @Override
    public boolean add(PlaceDTO placeDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into place value (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,placeDTO.getPlace_id());
            st.setString(2,placeDTO.getPlace_name());
            st.setString(3,placeDTO.getPlace_describe());
            st.setString(4,placeDTO.getRegion_code());
            st.setString(5,placeDTO.getPlace_address());
            
            int checkRS = st.executeUpdate();
            if(checkRS > 0 ) {
            	System.out.println("Them thanh cong  !");
            }
            else {
            	System.out.println("Them khong thanh cong !");
            }

            if (st.executeUpdate()>=1)
                result = true;
            conndb.closeConnection();

        }  catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return result;
    }

    @Override
    public boolean update(PlaceDTO placeDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "update place set " +
                    "place_name=?," +
                    "place_describe=?," +
                    "region_code=?, " +
                    "place_address=?" +
                    "where place_id = " + placeDTO.getPlace_id();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,placeDTO.getPlace_name());
            st.setString(2,placeDTO.getPlace_describe());
            st.setString(3,placeDTO.getRegion_code());
            st.setString(4,placeDTO.getPlace_address());
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
            String sql = "delete from place where place_id = ?";
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
            String sql = "select * from place where place_id = ?";
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


    public ArrayList<PlaceDTO> getPlacesByRegionCode(String rc) {
        ArrayList<PlaceDTO> places = new ArrayList<>();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from place where region_code = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,rc);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                PlaceDTO place = new PlaceDTO();
                place.setPlace_id(rs.getInt("place_id"));
                place.setPlace_name(rs.getString("place_name"));
                place.setPlace_describe(rs.getString("place_describe"));
                place.setPlace_address(rs.getString("place_address"));
                place.setRegion_code(rs.getString("region_code"));
                places.add(place);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return places;
    }

}
