package BUS;

import DAO.CustomerDAO;
import DTO.Booking_DetailDTO;
import DTO.CustomerDTO;

import java.util.ArrayList;



public class CustomerBUS {
    private CustomerDAO cusdao;
    public  CustomerBUS() {
        cusdao = new CustomerDAO();
    }

    public ArrayList<CustomerDTO> getAll() {
        return cusdao.getInstance().getAll();
    }

    public CustomerDTO getById(int id) {
        return cusdao.getInstance().getById(id);
    }
    public String update(CustomerDTO customerDTO) {
    	  if (!cusdao.getInstance().checkExistById(customerDTO.getCustomer_id())) {
    		  return "id không tồn tại";
          }
          if (!cusdao.getInstance().update(customerDTO)) {
        	  return "update khong thanh cong !";
          }
          else {
        	  cusdao.getInstance().update(customerDTO);
        	  return "update thanh cong !";
          }
    }
    public String delete(int id) {
    	  if (!cusdao.getInstance().delete(id)) {
        	  return "delete khong thanh cong !";        	  
          }
    	  else {
    		  cusdao.getInstance().delete(id);
    		  return "delete thanh cong !";
    	  }
    }
    public String add(CustomerDTO customerDTO) {
    	 if (cusdao.getInstance().checkExistById(customerDTO.getCustomer_id())) {
             return "id da ton tai !";
         }
    	 if(!cusdao.getInstance().add(customerDTO)) {
    		 return"them không thành công !";
    	 }
    	 else {
    		 cusdao.getInstance().add(customerDTO);
    		 return "thêm thành công !";
    	 }
    }
}
