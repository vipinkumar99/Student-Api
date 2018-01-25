package simple.api.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import simple.api.pojo.AddressPojo;
@JsonInclude(value=Include.ALWAYS)
public class AddressResponseDto extends AddressPojo{
	
	private int addressId;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	

}
