package br.com.augusto.response.dto;

import java.math.BigDecimal;

import br.com.augusto.models.FormaPagamento;
import br.com.augusto.models.PagamentosPassageiros;
import br.com.augusto.utils.DateUtiuls;

public class PagamentoDto {
	private Integer pagamentoId;
	private Integer parcela;
	private BigDecimal valor;
	private String dataVencimento;
	private String dataPagamento;
	private FormaPagamento formaPagamento;
	private String statusPagamento;

	public PagamentoDto(Integer pagamentoId, Integer parcela, BigDecimal valor, String dataVencimento,
			String dataPagamento, FormaPagamento formaPagamento, String statusPagamento) {
		super();
		this.pagamentoId = pagamentoId;
		this.parcela = parcela;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.formaPagamento = formaPagamento;
		this.statusPagamento = statusPagamento;
	}

	public PagamentoDto() {
	}

	public PagamentoDto(PagamentosPassageiros pagamento) {
		this.pagamentoId = pagamento.getId();
		this.parcela = pagamento.getParcela();
		this.valor = pagamento.getValor();
		if (pagamento.getDataVencimento() != null) {
			this.dataVencimento = DateUtiuls.formatDateBr(pagamento.getDataVencimento());
		} else {
			this.dataPagamento = "";
		}
		if (pagamento.getDataPagamento() != null) {
			this.dataPagamento = DateUtiuls.formatDateBr(pagamento.getDataPagamento());
		} else {
			this.dataPagamento = "";
		}

		this.formaPagamento = pagamento.getFormaPagamento();
		this.statusPagamento = pagamento.getStatus().getDescricao();
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

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

}
