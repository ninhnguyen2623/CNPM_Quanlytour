package DTO;

public class VehicleDTO {
	
	private int vehicle_id;
	private String tenxe;
	private String loaixe;
	private String trangthaixe;
	private String Suachua;
	
	public VehicleDTO() {
	
	}

	public VehicleDTO(int vehicle_id, String tenxe, String loaixe, String trangthaixe, String suachua) {
		this.vehicle_id = vehicle_id;
		this.tenxe = tenxe;
		this.loaixe = loaixe;
		this.trangthaixe = trangthaixe;
		this.Suachua = suachua;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getTenxe() {
		return tenxe;
	}

	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
	}

	public String getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}

	public String getTrangthaixe() {
		return trangthaixe;
	}

	public void setTrangthaixe(String trangthaixe) {
		this.trangthaixe = trangthaixe;
	}

	public String getSuachua() {
		return Suachua;
	}

	public void setSuachua(String suachua) {
		Suachua = suachua;
	}

	@Override
	public String toString() {
		return "VehicleDTO [vehicle_id=" + vehicle_id + ", tenxe=" + tenxe + ", loaixe=" + loaixe + ", trangthaixe="
				+ trangthaixe + ", Suachua=" + Suachua + "]";
	}
	
	
	
	
}
