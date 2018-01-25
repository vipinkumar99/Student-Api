package simple.api.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import simple.api.dao.IAddressDao;
import simple.api.models.Address;

@Repository
@Transactional
public class AddressDao implements IAddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAddressList() {

		List<Address> addressList = null;
		addressList = getCurrentSession().createQuery("From Address").list();
		return addressList;
	}

	@Override
	public void saveAddress(Address address) {
		getCurrentSession().save(address);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAddressByStudentId(int studentId) {
		String hql = "from Address where studentId="+studentId;
		return getCurrentSession().createQuery(hql).list();
	}

}
