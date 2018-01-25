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
		if(studentToValidate.getFirstName() == null) {
			throw new MyException(ResponseCode.NO_STUDENT_FIRST_NAME);
		}
		if(studentToValidate.getLastName() == null) {
			throw new MyException(ResponseCode.NO_STUDENT_LAST_NAME);
		}
		if(studentToValidate.getAge() <= 0) {
			throw new MyException(ResponseCode.INVALID_AGE);
		}
	}
	
	
	
}
