package DAO;

import DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAO<UserDTO> {
    @Override
    public ArrayList<UserDTO> getAll() {
        ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from user";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setTel(rs.getString("tel"));
                user.setBirthday(rs.getString("birthday"));
                user.setGender(rs.getString("gender"));
                user.setCreate_at(rs.getDate("create_at"));
                user.setRole_id(rs.getInt("role_id"));
                arr.add(user);
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
    public UserDTO getById(int id) {
        UserDTO user = new UserDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from user where user_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setTel(rs.getString("tel"));
                user.setBirthday(rs.getString("birthday"));
                user.setGender(rs.getString("gender"));
                user.setCreate_at(rs.getDate("create_at"));
                user.setRole_id(rs.getInt("role_id"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return user;
    }

    public UserDTO getByName(String name) {
        UserDTO user = new UserDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from user where user_name = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setTel(rs.getString("tel"));
                user.setBirthday(rs.getString("birthday"));
                user.setGender(rs.getString("gender"));
                user.setCreate_at(rs.getDate("create_at"));
                user.setRole_id(rs.getInt("role_id"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return user;
    }

    @Override
    public boolean add(UserDTO userDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into user (user_id,user_name,password,fullname,tel,birthday,gender,role_id) value (?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,userDTO.getUser_id());
            st.setString(2,userDTO.getUser_name());
            st.setString(3,userDTO.getPassword());
            st.setString(4,userDTO.getFullname());
            st.setString(5,userDTO.getTel());
            st.setString(6,userDTO.getBirthday());
            st.setString(7,userDTO.getGender());
            st.setInt(8,userDTO.getRole_id());
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
    public boolean update(UserDTO userDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "update user set " +
                    "user_name=?," +
                    "password=?," +
                    "fullname=?," +
                    "tel=?," +
                    "birthday=?," +
                    "gender=?," +
                    "role_id=? " +
                    "where user_id = " + userDTO.getUser_id();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,userDTO.getUser_name());
            st.setString(2,userDTO.getPassword());
            st.setString(3,userDTO.getFullname());
            st.setString(4,userDTO.getTel());
            st.setString(5,userDTO.getBirthday());
            st.setString(6,userDTO.getGender());
            st.setInt(7,userDTO.getRole_id());
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
            String sql = "delete from user where user_id = ?";
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
            String sql = "select * from user where user_id = ?";
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

    public boolean checkExistByName(String name) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "select * from user where user_name = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
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
