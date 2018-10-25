package br.com.augusto.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamentos_passageiros")
public class PagamentosPassageiros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "passageiro_id")
	private Passageiros passageiro;
	
	@OneToOne
	@JoinColumn(name = "viajem_id")
	private Viajens viajem;
	
	@Column(name = "data_pagamento")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	@Column(name = "data_vencimento")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(name = "valor", unique = true, nullable = false, precision = 8, scale = 4)
	private BigDecimal valor;
	
	private Integer parcela;
	
	@OneToOne
	@JoinColumn(name = "forma_pagamento_id")
	private FormaPagamento formaPagamento;
	
	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;

	public PagamentosPassageiros() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Passageiros getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiros passageiro) {
		this.passageiro = passageiro;
	}

	public Viajens getViajem() {
		return viajem;
	}

	public void setViajem(Viajens viajem) {
		this.viajem = viajem;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
