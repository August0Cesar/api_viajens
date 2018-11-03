package br.com.augusto.response.dto;

import java.math.BigDecimal;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.augusto.models.Viajens;
import br.com.augusto.utils.DateUtiuls;

public class ViajensDto {
	private Integer viajemId;
	private String nomeViajem;
	private String dataInicio;
	private String dataFinal;
	private String descricao;
	private Integer qtdPassageiros;
	private Integer totalPassageiro;
	private BigDecimal valorPago;
	private BigDecimal totalCusto;
	private BigDecimal valorPassagem;

	public ViajensDto() {
	}

	public ViajensDto(Viajens viajens) {
		this.viajemId = viajens.getId();
		this.nomeViajem = viajens.getNomeViajem();
		this.qtdPassageiros = viajens.getQtdPassageiros();
		this.valorPassagem = viajens.getValorViajem();
		this.descricao = viajens.getDescricao();
		if (viajens.getPassageiros() == null || viajens.getPassageiros().isEmpty()) {
			this.totalPassageiro = 0;
		} else {
			this.totalPassageiro = viajens.getPassageiros().stream()
					.filter(p -> "ATIVO".equals(p.getStatus().getDescricao())).collect(Collectors.toList()).size();
		}
		this.dataInicio = DateUtiuls.formatDateBr(viajens.getDataInicio());
		this.dataFinal = DateUtiuls.formatDateBr(viajens.getDataFinal());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorPassagem() {
		return valorPassagem;
	}

	public void setValorPassagem(BigDecimal valorPassagem) {
		this.valorPassagem = valorPassagem;
	}

	public Integer getViajemId() {
		return viajemId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

	public Integer getTotalPassageiro() {
		return totalPassageiro;
	}

	public void setTotalPassageiro(Integer totalPassageiro) {
		this.totalPassageiro = totalPassageiro;
	}

	public String getNomeViajem() {
		return nomeViajem;
	}

	public void setNomeViajem(String nomeViajem) {
		this.nomeViajem = nomeViajem;
	}

	public Integer getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(Integer qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getTotalCusto() {
		return totalCusto;
	}

	public void setTotalCusto(BigDecimal totalCusto) {
		this.totalCusto = totalCusto;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

}
