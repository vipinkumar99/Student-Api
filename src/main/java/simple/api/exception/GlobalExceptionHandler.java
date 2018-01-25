package simple.api.exception;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import simple.api.enums.ResponseCode;
import simple.api.responses.BaseResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

		private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

		@ExceptionHandler(value=MyException.class)
		@ResponseBody
		public<T> BaseResponse<T> handleMyException(MyException me, HttpServletResponse response){
			logger.debug("Error with Response " + me.getCode(), me);
			return new BaseResponse<T>(me);
		}
		
		@ExceptionHandler(value=Exception.class)
		@ResponseBody
		public<T> BaseResponse<T> handleAllException(Exception e, HttpServletResponse response){
			logger.debug("Error : ", e);
			return new BaseResponse<T>(true, null, ResponseCode.ERROR);
		}
}

