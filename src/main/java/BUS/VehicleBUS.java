package BUS;

import java.util.ArrayList;

import DAO.VehicleDAO;
import DTO.VehicleDTO;

public class VehicleBUS {
	private VehicleDAO vehicledao;
	
	public VehicleBUS() {
		vehicledao = new VehicleDAO();
	}
	public ArrayList<VehicleDTO> getAll() {
        return vehicledao.getInstance().getAll();
    }

    public VehicleDTO getById(int id) {
        return vehicledao.getInstance().getById(id);
    }

    public String add(VehicleDTO vehicledto) {
        if (vehicledao.getInstance().checkExistById(vehicledto.getVehicle_id())) {
            return "ID đã tồn tại";
        }
        if (!vehicledao.getInstance().add(vehicledto)) {
            return "Add thất bại";
        }
        else {
        	vehicledao.getInstance().add(vehicledto);
        	return "Add thành công";
        }
    }
    
    public String update(VehicleDTO vehicledto) {
       if(!vehicledao.getInstance().update(vehicledto)) {
    	   return "update khong thanh cong";
       }
        else {
        	vehicledao.getInstance().update(vehicledto);
        	return "update thành công";
        }
    }
    public String delete(int id) {
    	if(!vehicledao.getInstance().delete(id)) {
    		return "xóa không thành công !";
    	}
    	else {
    		vehicledao.getInstance().delete(id);
    		return "xoa thanh cong !";
    	}
    }
}
