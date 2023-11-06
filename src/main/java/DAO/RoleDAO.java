package DAO;

import DTO.RoleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDAO implements DAO<RoleDTO> {

    @Override
    public ArrayList<RoleDTO> getAll() {
        ArrayList<RoleDTO> arr = new ArrayList<RoleDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from role";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                RoleDTO role = new RoleDTO();
                role.setRole_id(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
                arr.add(role);
            }
// hhhhh
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
    public RoleDTO getById(int id) {
        RoleDTO role = new RoleDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from role where role_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                role.setRole_id(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return role;
    }

    @Override
    public boolean add(RoleDTO roleDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into role value (?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,roleDTO.getRole_id());
            st.setString(2,roleDTO.getRole_name());

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
    public boolean update(RoleDTO roleDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "update role set " +
                    "tour_id=? " +
                    "where role_id = " + roleDTO.getRole_id();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,roleDTO.getRole_name());
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
            String sql = "delete from role where role_id = ?";
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
            String sql = "select * from role where role_id=?";
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


}
