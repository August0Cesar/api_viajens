package br.com.augusto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.augusto.request.dto.PassageiroRequestDto;

@Entity
@Table(name = "passageiros")
public class Passageiros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_passageiro")
	private String nomePassageiro;
	private String email;
	private String telefone;
	private String whatsapp;
	private String rg;
	private String cpf;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Enderecos endereco;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresas empresas;
	
	@ManyToMany(mappedBy = "passageiros")
	private List<Viajens> viajens;

	public Passageiros() {
	}

	public Passageiros(PassageiroRequestDto passageiro) {
		this.email = passageiro.getEmail();
		this.cpf = passageiro.getCpf();
		this.dataCadastro = new Date();
		this.dataNascimento = passageiro.getDataNascimento();
		this.nomePassageiro = passageiro.getNomePassageiro();
		this.rg = passageiro.getRg();
		this.telefone = passageiro.getTelefone();
		this.whatsapp = passageiro.getWhatsApp();
	}

	public List<Viajens> getViajens() {
		return viajens;
	}

	public void setViajens(List<Viajens> viajens) {
		this.viajens = viajens;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	public Empresas getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
	}

}
