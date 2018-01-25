package simple.api.mappers;

import java.util.ArrayList;
import java.util.List;

import simple.api.models.Address;
import simple.api.request.dto.AddAddressRequestDto;
import simple.api.request.dto.UpdateAddressRequestDto;
import simple.api.response.dto.AddressResponseDto;

public class AddressMapper {
	
	public static List<AddressResponseDto> convertEntityListToResponseList(List<Address> addressList) {
		if (addressList == null)
			return null;
		List<AddressResponseDto> responseList = new ArrayList<AddressResponseDto>(addressList.size());
		for (Address address : addressList)
			responseList.add(convertEntityToResponse(address));

		return responseList;

	}

	public static AddressResponseDto convertEntityToResponse(Address address) {
		if (address == null)
			return null;
		AddressResponseDto response = new AddressResponseDto();
		response.setAddressId(address.getAddressId());
		response.setCity(address.getCity());
		response.setState(address.getState());
		response.setStudentId(address.getStudentId());
		return response;

	}

	public static Address convertAddRequestToEntity(AddAddressRequestDto request) {
		if (request == null)
			return null;

		Address response = new Address();
		response.setCity(request.getCity());
		response.setState(request.getState());
		response.setZipCode(request.getZipCode());
		response.setStudentId(request.getStudentId());
		return response;
	}


	public static Address convertUpdateRequestToEntity(UpdateAddressRequestDto address) {
		if (address == null)
			return null;

		Address response = new Address();
		response.setAddressId(address.getAddressId());
		response.setCity(address.getCity());
		response.setState(address.getState());
		response.setZipCode(address.getZipCode());
		response.setStudentId(address.getStudentId());
		return response;

	}

	
	
}
