package br.com.gama.contacorrente.dtos;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.horodenko.entities.Customer;

public class CustomerDto {

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	//private String username;
	
	public CustomerDto(Customer customer) {
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.phone = customer.getPhone();
		this.email= customer.getEmail();
		//this.username = customer.getLogin().getUsername();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	//public String getUsername() {
	//	return username;
	//}
	
	
	public static List<CustomerDto> Convert(List<Customer> customerList){
		return customerList.stream().map(CustomerDto::new).collect(Collectors.toList());
	}
	

}
