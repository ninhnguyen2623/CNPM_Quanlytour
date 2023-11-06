package DTO;

public class ServiceDTO {
    private int service_id;
    private String service_name;
    private double service_price;

    public ServiceDTO() {}
    
    

    public ServiceDTO(int service_id, String service_name, double service_price) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		this.service_price = service_price;
	}




	public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getService_price() {
        return service_price;
    }

    public void setService_price(double service_price) {
        this.service_price = service_price;
    }

	@Override
	public String toString() {
		return "ServiceDTO [service_id=" + service_id + ", service_name=" + service_name + ", service_price="
				+ service_price + "]";
	}
    
}
