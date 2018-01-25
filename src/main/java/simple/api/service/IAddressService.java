package simple.api.service;

import java.util.List;

import simple.api.request.dto.AddAddressRequestDto;
import simple.api.response.dto.AddressResponseDto;

public interface IAddressService {
	
	public List<AddressResponseDto>getAddressList();
	//public GetStudentResponseDto getStudentById(int id);
	public AddressResponseDto saveAddress(AddAddressRequestDto address );
	//public GetStudentResponseDto updateStudent(UpdateStudentRequestDto student );
	//public boolean  deleteStudent(int id);
	public List<AddressResponseDto> getStudentAddressById(int studentId);


}
