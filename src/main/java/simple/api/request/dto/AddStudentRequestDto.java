package simple.api.request.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import simple.api.pojo.StudentPojo;

@JsonInclude(value=Include.ALWAYS)
public class AddStudentRequestDto extends StudentPojo {

}
