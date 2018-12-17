package br.com.augusto.request.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PagamentoRequestDto {
	private Integer pagamentoId;
	private Integer parcela;
	private BigDecimal valor;
	private Integer passageiroId;
	private Integer viajemId;
	private Integer formaPagamentoId;
	private Date dataPagamento;
	private Date dataVencimento;
	private Boolean condicaoEspecial;
	private String condicoesEspeciais;
	private BigDecimal valorViajem;

	public PagamentoRequestDto(Integer parcela, BigDecimal valor, Integer passageiroId, Integer viajemId,
			Integer formaPagamentoId, Date dataPagamento, Date dataVencimento,Integer pagamentoId,BigDecimal valorViajem,String condicoesEspeciais
			,Boolean condicaoEspecial) {
		super();
		this.pagamentoId = pagamentoId;
		this.parcela = parcela;
		this.valor = valor;
		this.passageiroId = passageiroId;
		this.viajemId = viajemId;
		this.formaPagamentoId = formaPagamentoId;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		this.condicaoEspecial = condicaoEspecial;
		this.condicoesEspeciais = condicoesEspeciais;
		this.valorViajem = valorViajem;
		
	}

	public PagamentoRequestDto() {
		super();
	}

	public Boolean getCondicaoEspecial() {
		return condicaoEspecial;
	}

	public void setCondicaoEspecial(Boolean condicaoEspecial) {
		this.condicaoEspecial = condicaoEspecial;
	}

	public String getCondicoesEspeciais() {
		return condicoesEspeciais;
	}

	public void setCondicoesEspeciais(String condicoesEspeciais) {
		this.condicoesEspeciais = condicoesEspeciais;
	}

	public BigDecimal getValorViajem() {
		return valorViajem;
	}

	public void setValorViajem(BigDecimal valorViajem) {
		this.valorViajem = valorViajem;
	}

	public Integer getPagamentoId() {
		return pagamentoId;
	}

	public void setPagamentoId(Integer pagamentoId) {
		this.pagamentoId = pagamentoId;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getPassageiroId() {
		return passageiroId;
	}

	public void setPassageiroId(Integer passageiroId) {
		this.passageiroId = passageiroId;
	}

	public Integer getViajemId() {
		return viajemId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

	public Integer getFormaPagamentoId() {
		return formaPagamentoId;
	}

	public void setFormaPagamentoId(Integer formaPagamentoId) {
		this.formaPagamentoId = formaPagamentoId;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
