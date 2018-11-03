package br.com.augusto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.Empresas;

public interface EmpresaRepository extends CrudRepository<Empresas, Integer> {
	@Query("select v from Empresas v "
            + " where v.id = ?1 ")
	Empresas findEmpresaById(Integer empresaId);


}
