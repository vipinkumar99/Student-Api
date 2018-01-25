package simple.api.mappers;

import java.util.ArrayList;
import java.util.List;

import simple.api.models.Student;
import simple.api.request.dto.AddStudentRequestDto;
import simple.api.request.dto.UpdateStudentRequestDto;
import simple.api.response.dto.StudentResponseDto;

public class StudentMapper {

	public static List<StudentResponseDto> convertEntityListToGetResponseList(List<Student> studentList) {
		if (studentList == null)
			return null;
		List<StudentResponseDto> responseList = new ArrayList<StudentResponseDto>(studentList.size());
		for (Student student : studentList)
			responseList.add(convertEntityToResponse(student));

		return responseList;

	}

	public static StudentResponseDto convertEntityToResponse(Student student) {
		if (student == null)
			return null;
		StudentResponseDto response = new StudentResponseDto();
		response.setStudentId(student.getStudentId());
		response.setFirstName(student.getFirstName());
		response.setLastName(student.getLastName());
		response.setAge(student.getAge());
		response.setMarks(student.getMarks());
		return response;

	}

	public static Student convertAddRequestToEntity(AddStudentRequestDto request) {
		if (request == null)
			return null;

		Student response = new Student();
		response.setFirstName(request.getFirstName());
		response.setLastName(request.getLastName());
		response.setAge(request.getAge());
		response.setMarks(request.getMarks());
		return response;

	}

	public static Student convertUpdateRequestToEntity(UpdateStudentRequestDto student) {
		if (student == null)
			return null;

		Student response = new Student();
		response.setFirstName(student.getFirstName());
		response.setLastName(student.getLastName());
		response.setAge(student.getAge());
		response.setMarks(student.getMarks());
		return response;

	}

}
