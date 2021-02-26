package br.com.gama.contacorrente.forms;

import com.horodenko.entities.Customer;

public class CustomerForm {

	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Customer Convert() {
		return new Customer(firstname, lastname, phone, email);
	}
	
	
}
