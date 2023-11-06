package BUS;

import DAO.ServiceDAO;
import DTO.ServiceDTO;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;

import java.util.ArrayList;

public class ServiceBUS {
    private ServiceDAO ServiceDAO;

    public ServiceBUS() {
        ServiceDAO = new ServiceDAO();
    }

    public ArrayList<ServiceDTO> getAll() {
        return ServiceDAO.getInstance().getAll();
    }

    public ServiceDTO getById(int id) {
        return ServiceDAO.getInstance().getById(id);
    }

    public String add(ServiceDTO ServiceDTO) {
        if (ServiceDAO.getInstance().checkExistById(ServiceDTO.getService_id())) {
            return "ID đã tồn tại";
        }
        if (!ServiceDAO.getInstance().add(ServiceDTO)) {
            return "Add thất bại";
        }
        else {
        	ServiceDAO.getInstance().add(ServiceDTO);
        	return "Add thành công";
        }
    }
    
    public String update(ServiceDTO ServiceDTO) {
       if(!ServiceDAO.getInstance().update(ServiceDTO)) {
    	   return "update khong thanh cong";
       }
        else {
        	ServiceDAO.getInstance().update(ServiceDTO);
        	return "update thành công";
        }
    }
    public String delete(int id) {
    	if(!ServiceDAO.getInstance().delete(id)) {
    		return "xóa không thành công !";
    	}
    	else {
    		ServiceDAO.getInstance().delete(id);
    		return "xoa thanh cong !";
    	}
    }
}
