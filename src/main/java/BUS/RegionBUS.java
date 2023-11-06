package BUS;

import DAO.RegionDAO;
import DTO.RegionDTO;

import java.util.ArrayList;

public class RegionBUS {
    private RegionDAO regiondao;

    public RegionBUS() {
        regiondao = new RegionDAO();
    }

    public ArrayList<RegionDTO> getAll() {
        return regiondao.getAll();
    }
}
