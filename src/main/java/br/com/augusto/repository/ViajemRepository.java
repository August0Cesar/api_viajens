package br.com.augusto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.Viajens;

public interface ViajemRepository extends CrudRepository<Viajens, Integer> {
	@Query("select v from Viajens v "
            + " where v.empresas.id = ?1 "
            + " and v.tipoViajem.descricao = ?2 ")
	List<Viajens> findByEMpresaAndTipoViajem(Integer integer, String tipoViajen);

	@Query("select v from Viajens v "
            + " where v.id = ?1 ")
	Viajens findViajemById(Integer viajemId);


}
