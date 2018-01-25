package simple.api.service;

import java.util.List;

import simple.api.request.dto.AddStudentRequestDto;
import simple.api.request.dto.UpdateStudentRequestDto;
import simple.api.response.dto.StudentResponseDto;

public interface IStudentService {
	
	public List<StudentResponseDto>getStudentList();
	public StudentResponseDto getStudentById(int id);
	public StudentResponseDto getStudentByName(String name);
	public StudentResponseDto saveStudent(AddStudentRequestDto student );
	public StudentResponseDto updateStudent(UpdateStudentRequestDto student );
	public boolean  deleteStudent(int id);

}
