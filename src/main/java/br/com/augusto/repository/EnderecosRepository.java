package br.com.augusto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.Enderecos;

public interface EnderecosRepository extends CrudRepository<Enderecos, Integer> {
	
	@Query("select p from Enderecos p "
            + " where p.id = ?1 ")
	Enderecos fndEnderecoById(Integer id);

}
