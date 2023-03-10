package com.genspark.HibernateDemoApplication;

import com.genspark.HibernateDemoApplication.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// database transactions begin here
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();


		// INSERT query. Create objects here
		Employee e1 = new Employee();
		e1.setDepartment("Front End");
		e1.setName("Ali Hasan2");
		// doesn't save to database yet. Need to commit t.
		session.save(e1);

		// Objects get saved to database
		t.commit();
		System.out.println("Successfully saved");


//		// SELECT query
//		Query query = session.createQuery("from Employee where name=:person");
//		query.setParameter("person", "Ali Hasan");
//		List<Employee> employeeList=query.list();
//
//		for (Employee employee : employeeList) {
//			System.out.println(employee.toString());
//		}
//
//		System.out.println("Retrieved Successfully");


//		// UPDATE query
//		Query query = session.createQuery("update Employee set department=:d where name=:n");
//		query.setParameter("d", "Back End");
//		query.setParameter("n", "Ali Hasan");
//		int status = query.executeUpdate();
//		System.out.println(status);
//
//		t.commit();
//		System.out.println("Updated Successfully");


//		// DELETE query
//		Query query = session.createQuery("delete Employee where name=:n");
//		query.setParameter("n", "Ali Hasan2");
//		int status = query.executeUpdate();
//		System.out.println(status);
//
//		t.commit();
//		System.out.println("Deleted Successfully");


		session.close();
		factory.close();
	}

}
