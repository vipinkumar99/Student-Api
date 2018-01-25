package simple.api.request.dto;

public class UpdateStudentRequestDto extends AddStudentRequestDto {
	
	private int studentId;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	

}
