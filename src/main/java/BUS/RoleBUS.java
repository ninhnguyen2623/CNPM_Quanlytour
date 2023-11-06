package BUS;

import DAO.RoleDAO;
import DTO.RoleDTO;

import java.util.ArrayList;

public class RoleBUS {
    private RoleDAO roledao;

    public RoleBUS() {
        roledao = new RoleDAO();
    }

    public ArrayList<RoleDTO> getAll() {
        return roledao.getAll();
    }

    public RoleDTO getById(int id) {
        return roledao.getById(id);
    }
}
