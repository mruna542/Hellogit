package com.csi.service;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerDao {
	public List<Customer> getCustomerDetails();
	public void saveCustomerDetails(Customer customer);
	public void updateCustomerDetails(Customer customer,int customerId);
	public void deleteCustomerDetails(int customerId);


}
