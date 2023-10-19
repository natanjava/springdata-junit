package spring.data.maven.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.data.maven.model.Telefone;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {
	
	
}
