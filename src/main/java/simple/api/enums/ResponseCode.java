package simple.api.enums;



public enum ResponseCode {

	OK("Success","0"),
	ERROR("Internal Server Error!","100"),
	INVALID_ARGUMENT("Argument provided is not valid", "10"),
	
	INVALID_PASSWORD("Please provide valid password!","INV_PWD"),
	
	INV_NAME("Invalid %s name","INV_NAME"),
	COMMON_CODE("",""), 
	

	NO_STUDENT_PRESERNT("No student present!","NOT_FOUND"),
	NO_STUDENT_FIRST_NAME("Student First Name not present", "INV_NAME"),
	NO_STUDENT_LAST_NAME("Student Last Name not present", "INV_NAME"), 
	INVALID_STUDENT_ID("Student Id not Valid", "INV_STUDENT_ID" ), 
	
	NO_ADDRESS_PRESENT("Address Not Present", "NOT_FOUND"), 
	INVALID_AGE("Age is not valid", "INVALID");
	
	;
	
	
	private String message;
	private String code;
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	private ResponseCode(String message, String code) {
		this.message = message;
		this.code = code;
	}
	
	public static ResponseCode formatResponseCode(final ResponseCode responseCode, String message) {
		ResponseCode commonCode = COMMON_CODE;
		commonCode.message = String.format(responseCode.message	, message);
		return commonCode;
	}

}
