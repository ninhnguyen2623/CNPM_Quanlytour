package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HotelDTO;
import DTO.VehicleDTO;

public class VehicleDAO implements DAO<VehicleDTO> {
	public static VehicleDAO getInstance() {
		return new VehicleDAO();
	}
	@Override
	public ArrayList<VehicleDTO> getAll() {
		// TODO Auto-generated method 
		ArrayList<VehicleDTO> arr = new ArrayList<VehicleDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from vehicle";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
            	VehicleDTO vehicle = new VehicleDTO();
            	vehicle.setVehicle_id(rs.getInt("vehicle_id"));
            	vehicle.setTenxe(rs.getString("vehicle_name"));
            	vehicle.setLoaixe(rs.getString("vehicle_type"));
            	vehicle.setTrangthaixe(rs.getString("vehicle_status"));
            	vehicle.setSuachua(rs.getString("vehicle_fix"));
                arr.add(vehicle);
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
	public VehicleDTO getById(int id) {
		
		VehicleDTO vehicle = new VehicleDTO();
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "Select * from vehicle where vehicle_id = ?" ;
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            	vehicle.setVehicle_id(rs.getInt("vehicle_id"));
            	vehicle.setTenxe(rs.getString("vehicle_name"));
            	vehicle.setLoaixe(rs.getString("vehicle_type"));
            	vehicle.setTrangthaixe(rs.getString("vehicle_status"));
            	vehicle.setSuachua(rs.getString("vehicle_fix"));
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
        return vehicle;
	}

	@Override
	public boolean add(VehicleDTO t) {
		 boolean result = false;
	        try {
	        	ConnectDatabase conndb = new ConnectDatabase();

	        	String query = " INSERT INTO vehicle (vehicle_id,vehicle_name,vehicle_type,vehicle_status,vehicle_fix)"
						+ "VALUES (?,?,?,?,?)";
	            PreparedStatement st = conndb.getConnection().prepareStatement(query);
	            st.setInt(1,t.getVehicle_id());
	            st.setString(2, t.getTenxe());
	            st.setString(3,t.getLoaixe());
	            st.setString(4,t.getTrangthaixe());
	            st.setString(5,t.getSuachua());
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

	@Override
	public boolean update(VehicleDTO t) {
		boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "update vehicle set " +
                    "vehicle_name=?," +
                    "vehicle_type=?," +
                    "vehicle_status=?," +
                    "vehicle_fix=? where vehicle_id = " + t.getVehicle_id();
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setString(1, t.getTenxe());
            st.setString(2,t.getLoaixe());
            st.setString(3,t.getTrangthaixe());
            st.setString(4,t.getSuachua());
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
	            String sql = "delete from vehicle where vehicle_id = ?";
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
            String sql = "select * from vehicle where vehicle_id = ?";
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
