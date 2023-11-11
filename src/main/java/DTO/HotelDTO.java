package DTO;

public class HotelDTO {


    private int hotel_id;
    private String hotel_name;
    private String address;
    private String tel;
    private String website;
    private int star;
    private String region_code;
	public HotelDTO(int hotel_id, String hotel_name, String address, String tel, String website, int star,
			String region_code) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.address = address;
		this.tel = tel;
		this.website = website;
		this.star = star;
		this.region_code = region_code;
	}
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	@Override
	public String toString() {
		return "HotelDTO [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", address=" + address + ", tel=" + tel
				+ ", website=" + website + ", star=" + star + ", region_code=" + region_code + "]";
	}
    
    

}
