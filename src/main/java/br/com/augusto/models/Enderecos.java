package br.com.augusto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.augusto.request.dto.PassageiroRequestDto;

@Entity
public class Enderecos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private String cidade;
	private String estado;
	private String bairro;

	/*
	 * @OneToOne(mappedBy="customerRecord") private Usuario usuario;
	 */
	public Enderecos() {
	}

	public Enderecos(PassageiroRequestDto passageiro) {
		this.rua = passageiro.getRua();
		this.cidade = passageiro.getCidade();
		this.estado = passageiro.getEstado();
		this.bairro = passageiro.getBairro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
