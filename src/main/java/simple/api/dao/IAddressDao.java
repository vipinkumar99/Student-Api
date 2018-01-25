package simple.api.dao;

import java.util.List;

import simple.api.models.Address;

public interface IAddressDao {
	public List<Address> getAddressList();
//	public Student getStudentById(int id);
	public void saveAddress(Address address);
//	public void updateStudent(Student student);
//	public void deleteStudent(int id);
	public List<Address> getAddressByStudentId(int studentId);


}
