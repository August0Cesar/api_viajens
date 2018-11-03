package br.com.augusto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
	@Query("select s from Status s "
			+ " where s.entidade.descricao = ?1 " 
			+ " and s.descricao = ?2")
	Status findStatusByEntidade(String enidade, String descricaoStatus);
}
