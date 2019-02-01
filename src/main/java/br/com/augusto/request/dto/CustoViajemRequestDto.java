package br.com.augusto.request.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CustoViajemRequestDto {
	@NotEmpty(message = "{descricao.not.blank}")
	private String descricao;
	
	//@NotNull(message = "{valor.not.blank}")
	@NotNull(message = "{valor.not.null}")
	private BigDecimal valor;
	
	//@NotNull(message = "{viajemId.not.blank}")
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
