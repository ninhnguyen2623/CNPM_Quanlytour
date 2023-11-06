package DAO;

import DTO.CustomerDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO implements DAO<CustomerDTO> {
	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}

    @Override
    public ArrayList<CustomerDTO> getAll() {
        ArrayList<CustomerDTO> arr = new ArrayList<CustomerDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from customer";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomer_id(rs.getInt("customer_id"));
                customerDTO.setCustomer_name(rs.getString("customer_name"));
                customerDTO.setTel(rs.getString("tel"));
                customerDTO.setBirthday(rs.getString("birthday"));
                customerDTO.setEmail(rs.getString("email"));
                customerDTO.setCreate_at(rs.getString("create_at"));
                arr.add(customerDTO);
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
    public CustomerDTO getById(int id) {
        CustomerDTO customer = new CustomerDTO();
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String query = "select * from customer where customer_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setTel(rs.getString("tel"));
                customer.setBirthday(rs.getString("birthday"));
                customer.setEmail(rs.getString("email"));
                customer.setCreate_at(rs.getString("create_at"));
            }
            else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conndb.closeConnection();
        }
        return customer;
    }

    @Override
    public boolean add(CustomerDTO customerDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "insert into customer (customer_id,customer_name,tel,birthday,email)"
            		+ " value (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,customerDTO.getCustomer_id());
            st.setString(2,customerDTO.getCustomer_name());
            st.setString(3,customerDTO.getTel());
            st.setString(4,customerDTO.getBirthday());
            st.setString(5,customerDTO.getEmail());
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println("Them thanh cong  !");
            }
            else {
            	System.out.println("Them khong thanh cong !");
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
    public boolean update(CustomerDTO customerDTO) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "update customer set " +
                    "customer_name=?," +
                    "tel=?," +
                    "birthday=?," +
                    "email=? " +
                    "where customer_id = " + customerDTO.getCustomer_id();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,customerDTO.getCustomer_name());
            st.setString(2,customerDTO.getTel());
            st.setString(3,customerDTO.getBirthday());
            st.setString(4,customerDTO.getEmail());
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println("update thanh cong  !");
            }
            else {
            	System.out.println("update khong thanh cong !");
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
    public boolean delete(int id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "delete from customer where customer_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            int checkRS = st.executeUpdate();
            if(checkRS> 0 ) {
            	System.out.println("xoa thanh cong  !");
            }
            else {
            	System.out.println("xoa khong thanh cong !");
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
            String sql = "select * from customer where customer_id = ?";
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
