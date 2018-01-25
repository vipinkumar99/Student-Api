package simple.api.request.dto;

public class UpdateAddressRequestDto extends AddAddressRequestDto {
	
	private int addressId;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	

}
