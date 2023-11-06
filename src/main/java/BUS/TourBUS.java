package BUS;

import DAO.PlaceDAO;
import DAO.TourDAO;
import DAO.Tour_DetailDAO;
import DAO.UserDAO;
import DTO.*;

import java.util.ArrayList;
import java.util.EventListener;

public class TourBUS {
    TourDAO tour ;
    Tour_DetailDAO tour_detail ;

    public TourBUS() {
        tour = new TourDAO();
        tour_detail= new Tour_DetailDAO();

    }

    public ArrayList<TourDTO> getAll() {
        return tour.getAll();
    }

    public String add(TourDTO tourDTO, ArrayList<Tour_DetailDTO> tdls) {

        if (tour.checkExistById(tourDTO.getTour_id())) {
            return "ID tour đã tồn tại";
        }

        if (!tour.add(tourDTO))
            return "Thêm tour thất bại!";

        for(Tour_DetailDTO tdl : tdls) {
            tour_detail.add(tdl);
        }

        return "thêm tour thành công!";
    }

    public TourDTO getById(int id) {
        return tour.getById(id);
    }
    public String update (TourDTO TourDTO, ArrayList<Tour_DetailDTO> tdls) {
        if (!tour.checkExistById(TourDTO.getTour_id())) {
            return "ID tour không tồn tại";
        }

        if (!tour.update(TourDTO)) {
            return "UPDATE thất bại!";
        }

        if (!tour_detail.delete(TourDTO.getTour_id())){
            return "Có lỗi xảy ra trong quá trình xoá tour_id trong tour_detail";
        }

        for(Tour_DetailDTO tdl : tdls) {
            tour_detail.add(tdl);
        }

         return "UPDATE thành công!";
    }

    public String delete (int id) {
        if (tour.delete(id)) {
            return "Xoá thành công!";
        }
        else return "Xoá thất bại!";
    }

    
    public boolean checkExistById(int id) {
        return tour.checkExistById(id);
    }

    public ArrayList<PlaceDTO> getPlacesOfTour(int id)  {
        return tour.getPlacesOfTour(id);
    }
    public String addExcel(TourDTO tourDTO) {

        if (tour.checkExistById(tourDTO.getTour_id())) {
            return "ID tour đã tồn tại";
        }

        if (!tour.add(tourDTO)) {
        	return "Thêm tour thất bại!";        	
        }
        else {
        	tour.add(tourDTO);
        	return "thêm tour thành công!";
        }
    }


}
