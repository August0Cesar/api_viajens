package br.com.augusto.request.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PagamentoRequestDto {
	private Integer parcela;
	private BigDecimal valor;
	private Integer passageiroId;
	private Integer viajemId;
	private Integer formaPagamentoId;
	private Date dataPagamento;
	private Date dataVencimento;

	public PagamentoRequestDto(Integer parcela, BigDecimal valor, Integer passageiroId, Integer viajemId,
			Integer formaPagamentoId, Date dataPagamento, Date dataVencimento) {
		super();
		this.parcela = parcela;
		this.valor = valor;
		this.passageiroId = passageiroId;
		this.viajemId = viajemId;
		this.formaPagamentoId = formaPagamentoId;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public PagamentoRequestDto() {
		super();
		// TODO Auto-generated constructor stub
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
