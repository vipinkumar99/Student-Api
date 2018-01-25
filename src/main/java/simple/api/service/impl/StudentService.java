package simple.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simple.api.dao.IStudentDao;
import simple.api.mappers.StudentMapper;
import simple.api.models.Student;
import simple.api.request.dto.AddStudentRequestDto;
import simple.api.request.dto.UpdateStudentRequestDto;
import simple.api.response.dto.AddressResponseDto;
import simple.api.response.dto.StudentResponseDto;
import simple.api.service.IAddressService;
import simple.api.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	@Autowired
	private IAddressService addressService;

	public List<StudentResponseDto> getStudentList() {

		return StudentMapper.convertEntityListToGetResponseList(studentDao.getStudentList());
	}

	
	/* get student by id */
	public StudentResponseDto getStudentById(int studentId)
	{
		Student studentById = studentDao.getStudentById(studentId);
		StudentResponseDto response = StudentMapper.convertEntityToResponse(studentById);
		List<AddressResponseDto> studentAddresses = addressService.getStudentAddressById(studentId);
		response.setAddresses(studentAddresses);
		return response;
	}
	
	
	/* get student by id /
	public StudentResponseDto getStudentById(int id) {

//	return StudentMapper.convertEntityToGetResponse(studentDao.getStudentById(id));
		
		Student studentById = studentDao.getStudentById(id);
		StudentResponseDto response = StudentMapper.convertEntityToResponse(studentById);
		List<AddressResponseDto> studentAddresses = addressService.getStudentById(id);
		response.setAddresses(studentAddresses);
		return response;
	}
*/
	public StudentResponseDto saveStudent(AddStudentRequestDto request) {
		Student student = StudentMapper.convertAddRequestToEntity(request);
		if (student == null) {
			return null;
		}
			studentDao.saveStudent(student);
			return StudentMapper.convertEntityToResponse(student);
	
	}

	public StudentResponseDto updateStudent(UpdateStudentRequestDto request) {
		Student student = StudentMapper.convertUpdateRequestToEntity(request);
		if (student == null) {
			return null;
		}
			studentDao.saveStudent(student);
			return StudentMapper.convertEntityToResponse(student);
		}

	public boolean deleteStudent(int id) {
		studentDao.deleteStudent(id);
		return true;
	}


	@Override
	public StudentResponseDto getStudentByName(String studentName) {
		Student studentByName = studentDao.getStudentByName(studentName);
		StudentResponseDto response = StudentMapper.convertEntityToResponse(studentByName);
		
		return response;
	}

}
