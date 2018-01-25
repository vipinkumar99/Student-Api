package simple.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simple.api.dao.IAddressDao;
import simple.api.mappers.AddressMapper;
import simple.api.models.Address;
import simple.api.request.dto.AddAddressRequestDto;
import simple.api.response.dto.AddressResponseDto;
import simple.api.service.IAddressService;

@Service
public class AddressService implements IAddressService{

	@Autowired
	private IAddressDao addressDao;

	
	
	@Override
	public List<AddressResponseDto> getAddressList() {
		return AddressMapper.convertEntityListToResponseList(addressDao.getAddressList());
	}

	@Override
	public AddressResponseDto saveAddress(AddAddressRequestDto request) {
		Address address = AddressMapper.convertAddRequestToEntity(request);
		if (address == null) {
			return null;
		}
			addressDao.saveAddress(address);
			return AddressMapper.convertEntityToResponse(address);
	
		
	}

	@Override
	public List<AddressResponseDto> getStudentAddressById(int studentId) {
		List<Address> addresses = addressDao.getAddressByStudentId(studentId);
		return AddressMapper.convertEntityListToResponseList(addresses);
	}

}
