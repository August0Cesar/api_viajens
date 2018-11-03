package br.com.augusto.request.dto;

import java.math.BigDecimal;

public class CustoViajemRequestDto {
	private String descricao;
	private BigDecimal valor;
	private Integer viajemId;

	public CustoViajemRequestDto(String descricao, BigDecimal valor, Integer viajemId) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.viajemId = viajemId;
	}

	public CustoViajemRequestDto() {
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

	public Integer getViajemId() {
		return viajemId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

}
