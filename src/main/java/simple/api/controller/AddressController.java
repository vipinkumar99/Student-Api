package simple.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import simple.api.enums.ResponseCode;
import simple.api.exception.MyException;
import simple.api.pathmapping.PathMappingConstant;
import simple.api.request.dto.AddAddressRequestDto;
import simple.api.response.dto.AddressResponseDto;
import simple.api.responses.BaseResponse;
import simple.api.service.IAddressService;

@Controller
@RequestMapping(value = PathMappingConstant.AddressMappings.BASE)
public class AddressController {

	@Autowired
	private IAddressService  addressService;
	 
	/* get all address list */
	@RequestMapping(path = PathMappingConstant.ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<AddressResponseDto>> getAllAddress() throws Exception {
		List<AddressResponseDto> response = addressService.getAddressList();
		if (response == null)
			throw new MyException(ResponseCode.NO_ADDRESS_PRESENT);
		return new BaseResponse<List<AddressResponseDto>>(false, response, ResponseCode.OK);
	}

	/* save student */
	@RequestMapping(path = PathMappingConstant.SAVE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<AddressResponseDto> saveAddress(@RequestBody AddAddressRequestDto request) throws Exception {
		//StudentValidator.addStudentRequestDtoValidator(request);
		AddressResponseDto response = addressService.saveAddress(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<AddressResponseDto>(false, response, ResponseCode.OK);
	}

	
	
}
