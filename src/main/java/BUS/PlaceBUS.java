package BUS;

import DAO.PlaceDAO;
import DAO.PlaceDAO;
import DTO.PlaceDTO;
import DTO.PlaceDTO;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;

import java.util.ArrayList;

public class PlaceBUS {
    private PlaceDAO placedao;

    public PlaceBUS() {
        placedao = new PlaceDAO();
    }

    public ArrayList<PlaceDTO> getAll() {
        return PlaceDAO.getInstance().getAll();
    }

    public PlaceDTO getById(int id) {
        return PlaceDAO.getInstance().getById(id);
    }

    public String add(PlaceDTO PlaceDTO) {
        if (PlaceDAO.getInstance().checkExistById(PlaceDTO.getPlace_id())) {
            return "ID đã tồn tại";
        }
        if (!PlaceDAO.getInstance().add(PlaceDTO)) {
            return "Add thất bại";
        }
        else {
        	PlaceDAO.getInstance().add(PlaceDTO);
        	return "Add thành công";
        }
    }
    
    public String update(PlaceDTO PlaceDTO) {
       if(!PlaceDAO.getInstance().update(PlaceDTO)) {
    	   return "update khong thanh cong";
       }
        else {
        	PlaceDAO.getInstance().update(PlaceDTO);
        	return "update thành công";
        }
    }
    public String delete(int id) {
    	if(!PlaceDAO.getInstance().delete(id)) {
    		return "xóa không thành công !";
    	}
    	else {
    		PlaceDAO.getInstance().delete(id);
    		return "xoa thanh cong !";
    	}
    }
    public  ArrayList<PlaceDTO> getPlacesByRegionCode(String rc) {
        return placedao.getPlacesByRegionCode(rc);
    }
}
