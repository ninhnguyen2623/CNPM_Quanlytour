package DTO;

public class HotelDTO {


    private int hotel_id;
    private String hotel_name;
    private String address;
    private String tel;
    private String website;
    private int star;
    
    public HotelDTO(int hotel_id, String hotel_name, String address, String tel, String website, int star) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.address = address;
		this.tel = tel;
		this.website = website;
		this.star = star;
	}
	public HotelDTO() {

    }
    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
	@Override
	public String toString() {
		return "HotelDTO [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", address=" + address + ", tel=" + tel
				+ ", website=" + website + ", star=" + star + "]";
	}

    

}
