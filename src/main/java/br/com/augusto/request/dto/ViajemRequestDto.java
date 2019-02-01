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
	private Integer cafeManha;
	private Integer almoco;
	private Integer jantar;
	private Integer dias;
	private Boolean hospedagem;
	private String localHospedagem;
	private String urlHospedagem;

	public ViajemRequestDto() {
	}

	public ViajemRequestDto(Date dataFinal, Date dataInicio, String descricao, Integer empresaId, String nomeViajem,
			Integer qtdPassageiros, Integer tipoViajem, BigDecimal valorViajem,Integer cafeManha,Integer almoco,
			Integer jantar,Integer dias,Boolean hospedagem,String localHospedagem,String urlHospedagem) {
		super();
		this.dataFinal = dataFinal;
		this.dataInicio = dataInicio;
		this.descricao = descricao;
		this.empresaId = empresaId;
		this.nomeViajem = nomeViajem;
		this.qtdPassageiros = qtdPassageiros;
		this.tipoViajem = tipoViajem;
		this.valorViajem = valorViajem;
		this.cafeManha = cafeManha;
		this.almoco = almoco;
		this.jantar = jantar;
		this.dias = dias;
		this.hospedagem = hospedagem;
		this.localHospedagem = localHospedagem;
		this.urlHospedagem = urlHospedagem;
	}

	public Integer getCafeManha() {
		return cafeManha;
	}

	public void setCafeManha(Integer cafeManha) {
		this.cafeManha = cafeManha;
	}

	public Integer getAlmoco() {
		return almoco;
	}

	public void setAlmoco(Integer almoco) {
		this.almoco = almoco;
	}

	public Integer getJantar() {
		return jantar;
	}

	public void setJantar(Integer jantar) {
		this.jantar = jantar;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Boolean getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Boolean hospedagem) {
		this.hospedagem = hospedagem;
	}

	public String getLocalHospedagem() {
		return localHospedagem;
	}

	public void setLocalHospedagem(String localHospedagem) {
		this.localHospedagem = localHospedagem;
	}

	public String getUrlHospedagem() {
		return urlHospedagem;
	}

	public void setUrlHospedagem(String urlHospedagem) {
		this.urlHospedagem = urlHospedagem;
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
