package com.csi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csi.model.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	Customer customer;
	private static final String selectSQL = "select*from customer";
	private static final String updateSQL = "update customer set customername=? where customerid=?";
	private static final String deleteSQL = "delete from Customer where customerid=?";
	private static final String insertSQL = "insert into customer values(? ,? ,? ,?)";

	@Override
	public List<Customer> getCustomerDetails() {
		List<Customer> customers = new ArrayList<Customer>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectSQL);
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setCustomerId((int) row.get("customerid"));
			customer.setCustomerName((String) row.get("customername"));
			String cn = row.get("customercontactnumber").toString();
			customer.setCustomerContactNo(Long.valueOf(cn));
			customer.setCustomerAddress((String) row.get("customeraddress"));
			customers.add(customer);

		}
		return customers;
	}

	@Override
	public void saveCustomerDetails(Customer customer) {
		jdbcTemplate.update("insert into customer values(?,?,?,?)", customer.getCustomerId(), customer.getCustomerName(),
				customer.getCustomerContactNo(), customer.getCustomerAddress());
		System.out.println("customer.getCustomerId(): " + customer.getCustomerId());
	}

	@Override
	public void updateCustomerDetails(Customer customer, int CustomerId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(updateSQL, customer.getCustomerName(), CustomerId);
	}

	@Override
	public void deleteCustomerDetails(int CustomerId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(deleteSQL, CustomerId);

	}

}
