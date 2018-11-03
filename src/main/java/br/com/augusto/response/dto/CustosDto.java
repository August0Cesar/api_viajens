package br.com.augusto.response.dto;

import java.math.BigDecimal;

import br.com.augusto.models.Custos;

public class CustosDto {
	private Integer id;
	private String descricao;
	private BigDecimal valor;

	public CustosDto(Custos custo) {
		this.id =custo.getId();
		this.descricao = custo.getDescricao();
		this.valor = custo.getValor();
	}
	public CustosDto() {
	}
	public CustosDto(Integer id, String descricao, BigDecimal valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
