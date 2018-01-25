package simple.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import simple.api.enums.ResponseCode;
import simple.api.exception.MyException;
import simple.api.pathmapping.PathMappingConstant;
import simple.api.request.dto.AddStudentRequestDto;
import simple.api.request.dto.UpdateStudentRequestDto;
import simple.api.response.dto.StudentResponseDto;
import simple.api.responses.BaseResponse;
import simple.api.service.IStudentService;
import simple.api.validator.StudentValidator;

@Controller
@RequestMapping(value = PathMappingConstant.StudentMappings.BASE)
public class StudentController {

	@Autowired
	private IStudentService studentService;

	/* get all student list */
	@RequestMapping(path = PathMappingConstant.ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<StudentResponseDto>> getAllStudent() throws Exception {
		List<StudentResponseDto> response = studentService.getStudentList();
		if (response == null)
			throw new MyException(ResponseCode.NO_STUDENT_PRESERNT);
		return new BaseResponse<List<StudentResponseDto>>(false, response, ResponseCode.OK);
	}

	/* save student */
	@RequestMapping(path = PathMappingConstant.SAVE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<StudentResponseDto> saveStudent(@RequestBody AddStudentRequestDto request) throws Exception {
		StudentValidator.addStudentRequestDtoValidator(request);
		StudentResponseDto response = studentService.saveStudent(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<StudentResponseDto>(false, response, ResponseCode.OK);
	}

	/* get student by id */
	@RequestMapping(path = PathMappingConstant.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<StudentResponseDto> getStudentById(@PathVariable(PathMappingConstant.ID) int id)
			throws Exception {
		StudentResponseDto response = studentService.getStudentById(id);
		if (response == null)
			throw new MyException(ResponseCode.NO_STUDENT_PRESERNT);

		return new BaseResponse<StudentResponseDto>(false, response, ResponseCode.OK);
	}


	
	
	/* get student by id */
	@RequestMapping(path = PathMappingConstant.NAME_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<StudentResponseDto> getStudentByName(@PathVariable(PathMappingConstant.NAME) String studentName)
			throws Exception {
		StudentResponseDto response = studentService.getStudentByName(studentName);
		if (response == null)
			throw new MyException(ResponseCode.NO_STUDENT_PRESERNT);

		return new BaseResponse<StudentResponseDto>(false, response, ResponseCode.OK);
	}

	
	
	
	
	
	
	/* update student */
	@RequestMapping(path = PathMappingConstant.UPDATE, method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<StudentResponseDto> updateStudent(@RequestBody UpdateStudentRequestDto request)
			throws Exception {
		// StudentValidator.updateStudentRequestDtoValidator(request);
		StudentResponseDto response = studentService.updateStudent(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<StudentResponseDto>(false, response, ResponseCode.OK);
	}

	/* delete student */

	@RequestMapping(path = PathMappingConstant.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<StudentResponseDto> deleteStudentById(@PathVariable(PathMappingConstant.ID) int id)
			throws Exception {
		if (!studentService.deleteStudent(id))
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<StudentResponseDto>(false, null, ResponseCode.OK);
	}

}
