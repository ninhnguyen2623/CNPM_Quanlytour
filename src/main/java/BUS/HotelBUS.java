package BUS;

import DAO.HotelDAO;
import DTO.HotelDTO;

import java.util.ArrayList;

public class HotelBUS {
    private HotelDAO hoteldao;

    public HotelBUS() {
        hoteldao = new HotelDAO();
    }

    public ArrayList<HotelDTO> getAll() {
        return hoteldao.getInstance().getAll();
    }

    public HotelDTO getById(int id) {
        return hoteldao.getInstance().getById(id);
    }

    public String add(HotelDTO hoteldto) {
        if (hoteldao.getInstance().checkExistById(hoteldto.getHotel_id())) {
            return "ID đã tồn tại";
        }
        if (!hoteldao.getInstance().add(hoteldto)) {
            return "Add thất bại";
        }
        else {
        	hoteldao.getInstance().add(hoteldto);
        	return "Add thành công";
        }
    }
    
    public String update(HotelDTO hoteldto) {
       if(!hoteldao.getInstance().update(hoteldto)) {
    	   return "update khong thanh cong";
       }
        else {
        	hoteldao.getInstance().update(hoteldto);
        	return "update thành công";
        }
    }
    public String delete(int id) {
    	if(!hoteldao.getInstance().delete(id)) {
    		return "xóa không thành công !";
    	}
    	else {
    		hoteldao.getInstance().delete(id);
    		return "xoa thanh cong !";
    	}
    }
}
