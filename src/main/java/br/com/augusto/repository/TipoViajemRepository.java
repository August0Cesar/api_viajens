package br.com.augusto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.TipoViajem;

public interface TipoViajemRepository extends CrudRepository<TipoViajem, Integer> {
	@Query("select s from TipoViajem s "
			+ " where s.id = ?1 ")
	TipoViajem findTipoViajemById(Integer tipoViajemId);


}
