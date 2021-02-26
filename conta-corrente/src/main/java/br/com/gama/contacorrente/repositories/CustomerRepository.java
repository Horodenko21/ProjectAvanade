package br.com.gama.contacorrente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horodenko.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	// Quando queremos fazer um filtro customizado pode-se utilizar o padrão do Spring JPA para consultas
	
	//padrão 1 - usar o nome do método começando com 'findBy' e terminado com o nome de propriedade
	//EX: findByNomeDaPropriedade
	List<Customer> findByFirstName(String firstname);
	
	//padrão 2 - podemos utilizar a mesma lógica para propriedades de subclasses
	//EX: findByNomeDaPropriedadeDaClasseNomeDaPropriedadeDaSubclasse
	List<Customer> findByLoginUsername(String username);
	
	//PS: em casaos de ambiguidade pode utilizar o '_' para especificar propriedades dentro de subclasses
	//EX: findByNomeDaPropriedadeDaClasse_NomeDaPropriedadeDaSubclasse
}
