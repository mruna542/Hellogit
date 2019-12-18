/**
 * 
 */
package com.csi.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vaibhav
 *
 */
public class Service {

	/**
	 * @param args
	 */
	private static SessionFactory factory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee e1 = new Employee("mrunu", "pune", 24000);
		Employee e2 = new Employee("riya", "nashik", 25000);
		Employee e3 = new Employee("piya", "mumbai", 26000);
		Employee e4 = new Employee("siya", "bhusawal", 26000);
		// session.save(e1);
		// session.save(e2);
		// session.save(e3);
		// session.save(e4);
		// transaction.commit();

		List<Employee> employees = session.createQuery("from Employee").list();
		employees.forEach(emp -> System.out.println(emp));
// Aggritation for max
		// List<Employee>empmaxsalary=session.createQuery("SELECT
		// MAX(empSalary))from Employee").list();
		// System.out.println("\n max salary:"+empmaxsalary);
// for min
		// List<Employee>empminsalary=session.createQuery("SELECT
		// MIN(empSalary)from Employee").list();
		// System.out.println("\n min salary"+empminsalary);
// for count
		// List<Employee>empcountsalary=session.createQuery("SELECT count(*)from
		// Employee").list();//*use to count rows
		// System.out.println("\n count salary"+empcountsalary);

		// List<Employee>empcountsalary2=session.createQuery("SELECT
		// COUNT(empSalary)from Employee").list();//*use to count salary
		// System.out.println("\n count2 salary"+empcountsalary2);

// for Avg
		// List<Employee>empAvgsalary=session.createQuery("SELECT
		// Avg(empSalary)from Employee").list();
		// System.out.println("\n Avg salary"+empAvgsalary);
// for sum
		// List<Employee>empsumsalary=session.createQuery("SELECT
		// sum(empSalary)from Employee").list();
		// System.out.println("\n count salary"+empsumsalary);
// ristrictions to fetch row data
		Criteria ct = session.createCriteria(Employee.class);
		Criterion cton = Restrictions.eq("empId", 2);
		ct.add(cton);
		List<Employee> empcriteria = ct.list();
		// System.out.println("\n Ristriction on Id 2:"+empcriteria);//print whole data
		empcriteria.forEach(emp -> System.out.println("\n ristrictions on id2:" + emp.getEmpName()));// only
																										// print
																										// name
// projections use to fetech selected column data
		Criteria criteria = session.createCriteria(Employee.class);
		Projection projection = Projections.property("empName");
		criteria.setProjection(projection);
		List list = criteria.list();
		list.forEach(emp -> System.out.println("Employee name:" + emp));
																		

	}

}
