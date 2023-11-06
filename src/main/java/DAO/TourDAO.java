package DAO;

import DTO.PlaceDTO;
import DTO.TourDTO;

import java.sql.*;
import java.util.ArrayList;

public class TourDAO implements DAO<TourDTO> {
	public static TourDAO getInstance() {
		return new TourDAO();
	}
    @Override
    public ArrayList<TourDTO> getAll() {
        ArrayList<TourDTO> arr = new ArrayList<TourDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from tour";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                TourDTO tour = new TourDTO();
                tour.setTour_id(rs.getInt("tour_id"));
                tour.setTour_name(rs.getString("tour_name"));
                tour.setHotel_id(rs.getInt("hotel_id"));
                tour.setRegion_code(rs.getString("region_code"));
                tour.setPrice(rs.getDouble("price"));
                tour.setStart_day(rs.getDate("start_day").toString());
                tour.setEnd_day(rs.getDate("end_day").toString());
                tour.setDeparture_place(rs.getString("departure_place"));
                tour.setSchedule_describe(rs.getString("schedule_describe"));
                tour.setCreate_at(rs.getString("create_at"));

                arr.add(tour);
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
    public TourDTO getById(int id) {
        TourDTO tour = new TourDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from tour where tour_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                tour.setTour_id(rs.getInt("tour_id"));
                tour.setTour_name(rs.getString("tour_name"));

                tour.setHotel_id(rs.getInt("hotel_id"));
                tour.setRegion_code(rs.getString("region_code"));
                tour.setPrice(rs.getDouble("price"));
                tour.setStart_day(rs.getDate("start_day").toString());
                tour.setEnd_day(rs.getDate("end_day").toString());
                tour.setDeparture_place(rs.getString("departure_place"));
                tour.setSchedule_describe(rs.getString("schedule_describe"));
                tour.setCreate_at(rs.getString("create_at"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return tour;

    }

    @Override
    public boolean add(TourDTO tourDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into tour(tour_id,tour_name,hotel_id,region_code,price,start_day,end_day,departure_place,schedule_describe) " +
                    "value (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,tourDTO.getTour_id());
            st.setString(2,tourDTO.getTour_name());
            st.setInt(3,tourDTO.getHotel_id());
            st.setString(4,tourDTO.getRegion_code());
            st.setDouble(5,tourDTO.getPrice());
            st.setString(6,tourDTO.getStart_day());
            st.setString(7,tourDTO.getEnd_day());
            st.setString(8,tourDTO.getDeparture_place());
            st.setString(9,tourDTO.getSchedule_describe());
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
    public boolean update(TourDTO tourDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "update tour set " +
                    "tour_name=?," +
                    "hotel_id=?," +
                    "region_code=?,"+
                    "price=?," +
                    "start_day=?," +
                    "end_day=?," +
                    "departure_place=?," +
                    "schedule_describe=? " +
                    "where tour_id = " + tourDTO.getTour_id();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,tourDTO.getTour_name());
            st.setInt(2,tourDTO.getHotel_id());
            st.setString(3,tourDTO.getRegion_code());
            st.setDouble(4,tourDTO.getPrice());
            st.setString(5,tourDTO.getStart_day());
            st.setString(6,tourDTO.getEnd_day());
            st.setString(7,tourDTO.getDeparture_place());
            st.setString(8,tourDTO.getSchedule_describe());
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
            String sql = "delete from tour where tour_id = ?";
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
            String sql = "select * from tour where tour_id = ?";
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

    public ArrayList<PlaceDTO> getPlacesOfTour (int id) {
        ArrayList<PlaceDTO> places = new ArrayList<PlaceDTO>();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "\n" +
                    "SELECT * from place p\n" +
                    "WHERE p.place_id IN (\n" +
                    "  SELECT td.place_id FROM tour_detail td\n" +
                    "  where ? = td.tour_id\n" +
                    ")";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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
            System.out.println(e.getMessage());

        }
        finally {
            conndb.closeConnection();
        }
        return places;
    }

}
