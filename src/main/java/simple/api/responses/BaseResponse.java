package simple.api.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import simple.api.enums.ResponseCode;
import simple.api.exception.MyException;

@JsonInclude(value=Include.NON_NULL)
public class BaseResponse<T> {

	public boolean error;
	public String message;
	public T data;
	public String statusCode;
	
	public BaseResponse(boolean error, String message, T data, String statusCode) {
		this.error = error;
		this.message = message;
		this.data = data;
		this.statusCode = statusCode;
	}
	
	
	public BaseResponse(boolean error, T data, ResponseCode statusCode) {
		this.error = error;
		this.message = statusCode.getMessage();
		this.data = data;
		this.statusCode = statusCode.getCode();
	}
	
public BaseResponse(MyException ex)
{
	this.error=true;
	this.message=ex.getMessage();
	this.data=null;
	this.statusCode=ex.getCode();
}

}
