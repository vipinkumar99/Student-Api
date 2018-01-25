package simple.api.dao.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import simple.api.dao.IStudentDao;
import simple.api.models.Student;

@Repository
@Transactional
public class StudentDao implements IStudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentList() {
		List<Student> studentList = null;
		studentList = getCurrentSession().createQuery("From Student").list();
		return studentList;
	}

	public Student getStudentById(int id) {
		return (Student) getCurrentSession().get(Student.class, id);
	}

	public void saveStudent(Student student) {
		getCurrentSession().save(student);

	}

	public void updateStudent(Student student) {
		getCurrentSession().update(student);

	}

	public void deleteStudent(int id) {
		Student student = getStudentById(id);
		getCurrentSession().delete(student);

	}

	@Override
	public Student getStudentByName(String studentName) {
		String hql = "from Student where firstName=' " + studentName + " ' ";
		return (Student) getCurrentSession().createQuery(hql).uniqueResult();

	}

}
