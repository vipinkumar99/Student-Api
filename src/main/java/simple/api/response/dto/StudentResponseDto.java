package simple.api.response.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import simple.api.pojo.StudentPojo;

@JsonInclude(value=Include.ALWAYS)
public class StudentResponseDto extends StudentPojo {
	
	private int studentId;
	private List< AddressResponseDto> addresses;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public List<AddressResponseDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressResponseDto> addresses) {
		this.addresses = addresses;
	}
	
	

}
