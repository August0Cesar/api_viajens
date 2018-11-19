package br.com.augusto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.augusto.models.FormaPagamento;

public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, Integer> {
	@Query("select s from FormaPagamento s "
			+ " where s.id = ?1 ")
	FormaPagamento findFormaPagamentoById(Integer formaPagamentoId);


}
