package DAO;

import DTO.HotelDTO;
import java.sql.*;
import java.util.ArrayList;

public class HotelDAO implements DAO<HotelDTO> {
	public static HotelDAO getInstance() {
		return new HotelDAO();
	}
//Comment
    @Override
    public ArrayList<HotelDTO> getAll() {
        ArrayList<HotelDTO> arr = new ArrayList<HotelDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from hotel";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                HotelDTO hotel = new HotelDTO();
                hotel.setHotel_id(rs.getInt("hotel_id"));
                hotel.setHotel_name(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setTel(rs.getString("tel"));
                hotel.setWebsite(rs.getString("website"));
                hotel.setStar(rs.getInt("star"));
                hotel.setRegion_code(rs.getString("region_code"));
                arr.add(hotel);
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
    public HotelDTO getById(int id) {
        HotelDTO hotel = new HotelDTO();
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "Select * from hotel where hotel_id = ?" ;
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                hotel.setHotel_id(rs.getInt("hotel_id"));
                hotel.setHotel_name(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setTel(rs.getString("tel"));
                hotel.setWebsite(rs.getString("website"));
                hotel.setStar(rs.getInt("star"));
                hotel.setRegion_code(rs.getString("region_code"));
            }
            else return null;

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return hotel;
    }

    @Override
    public boolean add(HotelDTO HotelDTO) {
        boolean result = false;
        try {
        	ConnectDatabase conndb = new ConnectDatabase();

        	String query = " INSERT INTO hotel (hotel_id,hotel_name,address,tel,website,star,region_code)"
					+ "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setInt(1,HotelDTO.getHotel_id());
            st.setString(2, HotelDTO.getHotel_name());
            st.setString(3,HotelDTO.getAddress());
            st.setString(4,HotelDTO.getTel());
            st.setString(5,HotelDTO.getWebsite());
            st.setInt(6,HotelDTO.getStar());
            st.setString(7, HotelDTO.getRegion_code());
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println("Them thanh cong  !");
            }
            else {
            	System.out.println("Them khong thanh cong !");
            }
            if (st.executeUpdate()>=1)
                result = true;

            conndb.closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    // comment
    @Override
    public boolean update(HotelDTO HotelDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "update hotel set " +
                    "hotel_name=?," +
                    "address=?," +
                    "tel=?," +
                    "website=?," +
                    "star=?," +
                    "region_code=? where hotel_id = " + HotelDTO.getHotel_id();
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setString(1, HotelDTO.getHotel_name());
            st.setString(2,HotelDTO.getAddress());
            st.setString(3,HotelDTO.getTel());
            st.setString(4,HotelDTO.getWebsite());
            st.setInt(5,HotelDTO.getStar());
            st.setString(6, HotelDTO.getRegion_code());
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println("update thanh cong  !");
            }
            else {
            	System.out.println("update khong thanh cong !");
            }
            if (st.executeUpdate()>=1)
                result = true;

        }
        catch (Exception e) {
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
            String sql = "delete from hotel where hotel_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println("xoa thanh cong  !");
            }
            else {
            	System.out.println("Xoa khong thanh cong !");
            }
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
            String sql = "select * from hotel where hotel_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println(" thanh cong  !");
            }
            else {
            	System.out.println("khong thanh cong !");
            }
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
}
