package com.thirdware.guptabookstore.dao;


import com.thirdware.guptabookstore.models.Customer;


public interface CustomerDao {
	public Customer  customerRegister(CustomerDao customer);
	public Customer customerLogin(String email);
	
}
