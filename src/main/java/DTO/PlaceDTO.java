package DTO;

public class PlaceDTO {
    private int place_id;
    private String place_name;
    private String place_describe;
    private String place_address;
    private String region_code;
    
    

    public PlaceDTO(int place_id, String place_name, String place_describe, String place_address, String region_code) {
		super();
		this.place_id = place_id;
		this.place_name = place_name;
		this.place_describe = place_describe;
		this.place_address = place_address;
		this.region_code = region_code;
	}


	public String getPlace_address() {
        return place_address;
    }
    

    public void setPlace_address(String place_address) {
        this.place_address = place_address;
    }

    public PlaceDTO() {

    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_describe() {
        return place_describe;
    }

    public void setPlace_describe(String place_describe) {
        this.place_describe = place_describe;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }
}
