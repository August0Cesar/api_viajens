package br.com.augusto.response.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.augusto.models.PagamentosPassageiros;

public class PagamentoPassageiroDto {
	private String nomePassageiro;
	private Integer passageiroId;
	private String nomeViajem;
	private Integer viajemId;
	private BigDecimal valorViajem;
	private String status;
	private List<PagamentoDto> listaPagamentos;

	public PagamentoPassageiroDto(String nomePassageiro, Integer passageiroId, String nomeViajem, Integer viajemId,
			BigDecimal valorViajem, String status, List<PagamentoDto> listaPagamentos) {
		super();
		this.nomePassageiro = nomePassageiro;
		this.passageiroId = passageiroId;
		this.nomeViajem = nomeViajem;
		this.viajemId = viajemId;
		this.valorViajem = valorViajem;
		this.status = status;
		this.listaPagamentos = listaPagamentos;
	}

	public PagamentoPassageiroDto() {
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public Integer getPassageiroId() {
		return passageiroId;
	}

	public void setPassageiroId(Integer passageiroId) {
		this.passageiroId = passageiroId;
	}

	public String getNomeViajem() {
		return nomeViajem;
	}

	public void setNomeViajem(String nomeViajem) {
		this.nomeViajem = nomeViajem;
	}

	public Integer getViajemId() {
		return viajemId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

	public BigDecimal getValorViajem() {
		return valorViajem;
	}

	public void setValorViajem(BigDecimal valorViajem) {
		this.valorViajem = valorViajem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PagamentoDto> getListaPagamentos() {
		return listaPagamentos;
	}

	public void setListaPagamentos(List<PagamentoDto> listaPagamentos) {
		this.listaPagamentos = listaPagamentos;
	}

}
