package hibernate.demo.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Customer;

public class CustomerDAO {

	// this is the meachanics of getting a record from the database
	public Customer findByCustomerId(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		String hql = "FROM Customer c where c.id = :custId";

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("custId", id);

		try {
			Customer result = query.getSingleResult();
			return result;
		} catch (Exception e) {
			return null;
		} finally {
			t.commit();
			factory.close();
			session.close();
		}

	}

	public boolean validate(String username, String password) {
		// the work to validate the username and password are indeed whats in the
		// database

		// select * from users where username = "xyz" and password = "abc";

		// this is in your studnet DAO

		// create a functin in your DAO that returns true or false
		// take 2 args username password
		// use the 2 incoming args to write a query to get the user from teh database
		// using those 2 args
		// if the query returns a student then they are authenticated
		// if it does not reutn a recrod then they are not authenticated.

		// query student from datbase using username
		// if student == null returh false
		// if student.password = password return ture
		// otherwise retrurn false
		
		return false;

	}

	public Customer findByClassId(String username, Integer classid) {
		// simply return a student if they are in the class
		return null;
	}

	public boolean registerToClass(String username, Integer classId) {
		// first I would check if the user is already in a class
		// if they are return false
		// otherwise try to add to the class and if successful return true
		return false;
	}
	
	
	public void main() {
		boolean registered = dao.isStudentRegisterd( email, cId );
		if ( registered ) {
			// show some error message and continue with menu options
		} else {
			// the student is not registered so do the work to register the student to the class
			// this will always save the student to the class ... do not pass go
			// there are no check on this because the check has already been done.
			dao.registerStudent(email,cId);
		}
	}

}
