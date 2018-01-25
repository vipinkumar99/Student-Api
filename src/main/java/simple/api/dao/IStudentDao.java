package simple.api.dao;

import java.util.List;

import simple.api.models.Student;
public interface IStudentDao {
	
	
	public List<Student> getStudentList();
	public Student getStudentById(int id);
	public Student getStudentByName(String name);
	public void saveStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int id);

}
