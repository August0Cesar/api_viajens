package br.com.augusto.response.dto;

import java.math.BigDecimal;

public class DetalheViajemPassageiroDto {
	private Integer passageiroId;
	private String nomePassageiro;
	private Integer parcelasPagas;
	private Integer qtdParcelas;
	private BigDecimal valorPago;

	public DetalheViajemPassageiroDto() {
	}

	public DetalheViajemPassageiroDto(Integer passageiroId, String nomePassageiro, Integer parcelasPagas,
			Integer qtdParcelas, BigDecimal valorPago) {
		super();
		this.passageiroId = passageiroId;
		this.nomePassageiro = nomePassageiro;
		this.parcelasPagas = parcelasPagas;
		this.qtdParcelas = qtdParcelas;
		this.valorPago = valorPago;
	}

	public Integer getPassageiroId() {
		return passageiroId;
	}

	public void setPassageiroId(Integer passageiroId) {
		this.passageiroId = passageiroId;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public Integer getParcelasPagas() {
		return parcelasPagas;
	}

	public void setParcelasPagas(Integer parcelasPagas) {
		this.parcelasPagas = parcelasPagas;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
}
