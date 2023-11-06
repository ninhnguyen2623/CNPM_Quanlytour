package DTO;

import java.sql.Date;

public class CustomerDTO {
    private int customer_id;
    private String customer_name;
    private String tel;
    private String birthday;
    private String email;
    private String create_at;

    public CustomerDTO() {

    }
    
    public CustomerDTO(int customer_id, String customer_name, String tel, String birthday, String email, String create_at) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.tel = tel;
		this.birthday = birthday;
		this.email = email;
		this.create_at = create_at;
	}

	public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

	@Override
	public String toString() {
		return "CustomerDTO [customer_id=" + customer_id + ", customer_name=" + customer_name + ", tel=" + tel
				+ ", birthday=" + birthday + ", email=" + email + ", create_at=" + create_at + "]";
	}
    
}
