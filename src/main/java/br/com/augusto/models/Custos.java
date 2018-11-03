package br.com.augusto.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.augusto.request.dto.CustoViajemRequestDto;

@Entity
@Table(name = "custos")
public class Custos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;

	@Column(name = "valor", precision = 8, scale = 4)
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "viajens_id")
	private Viajens viajem;

	public Custos() {
	}

	public Custos(CustoViajemRequestDto custoViajem) {
		this.descricao = custoViajem.getDescricao();
		this.valor = custoViajem.getValor();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Viajens getViajem() {
		return viajem;
	}

	public void setViajem(Viajens viajem) {
		this.viajem = viajem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
