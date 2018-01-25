package simple.api.validator;

import simple.api.enums.ResponseCode;
import simple.api.exception.MyException;
import simple.api.request.dto.AddStudentRequestDto;

public class StudentValidator {

	public static void addStudentRequestDtoValidator(AddStudentRequestDto studentToValidate) throws Exception
	{
		if(studentToValidate==null)
		{
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}
	}
}
