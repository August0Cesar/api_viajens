package br.com.augusto.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.Custos;

public interface CustosRepository extends CrudRepository<Custos, Integer> {
	@Query("select sum(c.valor) from Custos c "
            + " where c.viajem.id = ?1 ")
	BigDecimal findTotalCustoByViajem(Integer viajemId);

	@Query("select c from Custos c "
            + " where c.viajem.id = ?1 ")
	List<Custos> findCustosByViajem(Integer viaemId);
	
	@Query("select c from Custos c "
            + " where c.id = ?1 ")
	Custos findCustoBycustoId(Integer custoId);
}
