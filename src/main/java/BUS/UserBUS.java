package BUS;

import DAO.UserDAO;
import DTO.UserDTO;

import java.util.ArrayList;
import java.util.Objects;

public class UserBUS {
    private UserDAO userdao;

    public UserBUS() {
        userdao = new UserDAO();
    }

    public ArrayList<UserDTO> getAll() {
        return userdao.getAll();
    }

    public String add(UserDTO udo) {
        if (userdao.add(udo)){
            return "Thêm thành công!!";
        }
        else return "Thêm thất bại!!";
    }

    public String update(UserDTO udo) {
        if (!userdao.checkExistById(udo.getUser_id())) {
            return "Account Không tồn tại!!";
        }

        if (userdao.update(udo)){
            return "Cập nhật thành công!!";
        }
        else return "Cập nhật thất bại!!";
    }

    public String delete(int id) {
        if (!userdao.checkExistById(id)) {
            return "Account Không tồn tại!!";
        }

        if (userdao.delete(id)){
            return "Xoá thành công!!";
        }
        else return "Xoá thất bại!!";
    }

    public UserDTO getById(int id) {
        return userdao.getById(id);
    }

    public boolean CheckUser(String username, String password) {
        UserDTO udo = userdao.getByName(username);
        return Objects.equals(udo.getPassword(), password);
    }
    
    public UserDTO getByName(String username){
		return userdao.getByName(username);
	}
}















