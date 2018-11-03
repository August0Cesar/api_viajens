package br.com.augusto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.Passageiros;

public interface PassageirosRepository extends CrudRepository<Passageiros, Integer> {
	
	@Query("select p from Passageiros p "
            + " where p.empresas.id = ?1 ")
	List<Passageiros> findAllByEmpresa(Integer empresaId);
	
	@Query("select p from Passageiros p "
            + " where p.id = ?1 ")
	Passageiros findPassageiroById(Integer passageiroId);
}
