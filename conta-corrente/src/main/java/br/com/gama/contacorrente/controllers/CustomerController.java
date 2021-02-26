package br.com.gama.contacorrente.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.horodenko.entities.Customer;

import br.com.gama.contacorrente.dtos.CustomerDto;
import br.com.gama.contacorrente.forms.CustomerForm;
import br.com.gama.contacorrente.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	
	@GetMapping
	public List<CustomerDto> find(String firstname) {
		
		List<Customer> result = null;
		
		if(firstname != null) {
			result = repository.findByFirstName(firstname);
		} else {
			result = repository.findAll();
		}
			
		return CustomerDto.Convert(result);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> add(@RequestBody CustomerForm form, UriComponentsBuilder uriBuilder) {
		
		Customer customer = form.Convert(); 
		
		repository.save(customer);
		
		URI uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
		
		System.out.print(uri.toString());
		
		return ResponseEntity.created(uri).body(new CustomerDto(customer));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
		
		Optional<Customer> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(new CustomerDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
		
	
}
