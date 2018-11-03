package br.com.augusto.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.PagamentosPassageiros;

public interface PagamentosPassageirosRepository extends CrudRepository<PagamentosPassageiros, Integer> {
	@Query("select sum(c.valor) from PagamentosPassageiros c where c.viajem.id = ?1 and c.status.id = ?2"
			+ " and c.passageiro.status.id = ?3")
	BigDecimal findTotalPagamentos(Integer viajemId, Integer statusId,Integer statusPassageiroAtivoId);

	@Query("select c from PagamentosPassageiros c where c.passageiro.id = ?1 ")
	List<PagamentosPassageiros> findPagamentosByPassageiro(Integer passageiroId);

	@Query("select count(c) from PagamentosPassageiros c where c.viajem.id = ?1 and c.status.id = ?2")
	Integer findQtdParcelasPagas(Integer viajemId, Integer statusId);
	
	@Query("select count(c) from PagamentosPassageiros c where c.viajem.id = ?1")
	Integer findQtdParcelas(Integer viajemId);
	
	@Query("select count(c) from PagamentosPassageiros c where c.viajem.id = ?1 and c.status.id = ?2 and c.passageiro.id = ?3")
	Integer findQtdParcelasPagasByPassageiro(Integer viajemId, Integer statusId, Integer passageiroId);

	@Query("select count(c) from PagamentosPassageiros c where c.viajem.id = ?1 and c.passageiro.id = ?2")
	Integer findQtdParcelasByPassageiro(Integer viajemId, Integer passageiroId);
	
	@Query("select sum(c.valor) from PagamentosPassageiros c where c.viajem.id = ?1 and c.status.id = ?2 and c.passageiro.id = ?3")
	BigDecimal findTotalPagamentosByPassageiro(Integer viajemId, Integer statusId, Integer passageiroId);
}
