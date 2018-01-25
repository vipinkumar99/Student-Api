package simple.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentAddress")
public class Address {

	@Id
	@Column(name="AddressId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	
	
	private String city;
	private String state;
	private long zipCode;
	private int  studentId;

	public Address(String city, String state, long zipCode, int studentId) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.studentId = studentId;
	}

	
	public Address() {
		// TODO Auto-generated constructor stub
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

}
