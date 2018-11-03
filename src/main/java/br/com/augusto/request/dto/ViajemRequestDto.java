package br.com.augusto.request.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ViajemRequestDto {
	private Date dataFinal;
	private Date dataInicio;
	private String descricao;
	private Integer empresaId;
	private String nomeViajem;
	private Integer qtdPassageiros;
	private Integer tipoViajem;
	private BigDecimal valorViajem;

	public ViajemRequestDto() {
	}

	public ViajemRequestDto(Date dataFinal, Date dataInicio, String descricao, Integer empresaId, String nomeViajem,
			Integer qtdPassageiros, Integer tipoViajem, BigDecimal valorViajem) {
		super();
		this.dataFinal = dataFinal;
		this.dataInicio = dataInicio;
		this.descricao = descricao;
		this.empresaId = empresaId;
		this.nomeViajem = nomeViajem;
		this.qtdPassageiros = qtdPassageiros;
		this.tipoViajem = tipoViajem;
		this.valorViajem = valorViajem;
	}

	public BigDecimal getValorViajem() {
		return valorViajem;
	}

	public void setValorViajem(BigDecimal valorViajem) {
		this.valorViajem = valorViajem;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
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

	public Integer getTipoViajem() {
		return tipoViajem;
	}

	public void setTipoViajem(Integer tipoViajem) {
		this.tipoViajem = tipoViajem;
	}


	@Override
	public String toString() {
		return "ViajemRequestDto [dataFinal=" + dataFinal + ", dataInicio=" + dataInicio + ", descricao=" + descricao
				+ ", empresaId=" + empresaId + ", nomeViajem=" + nomeViajem + ", qtdPassageiros=" + qtdPassageiros
				+ ", tipoViajem=" + tipoViajem + ", valorViajem=" + valorViajem + "]";
	}

}
