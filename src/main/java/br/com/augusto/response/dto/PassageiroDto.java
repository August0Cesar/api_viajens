package br.com.augusto.response.dto;

import java.util.Date;

import br.com.augusto.models.Enderecos;
import br.com.augusto.models.Passageiros;
import br.com.augusto.utils.DateUtiuls;

public class PassageiroDto {
	private Integer id;
	private String nomePassageiro;
	private String email;
	private String telefone;
	private String whatsapp;
	private String rg;
	private String cpf;
	private ViajensDto viajem;// viajem mais proxima
	private String dataNascimento;
	private Date dataCadastro;
	private String status;
	private String statusPagamento;
	private Enderecos endereco;
	private Integer qtdViajens;

	public PassageiroDto() {
	}

	public PassageiroDto(Passageiros passageiros) {
		this.id = passageiros.getId();
		this.nomePassageiro = passageiros.getNomePassageiro();
		this.email = passageiros.getEmail();
		this.telefone = passageiros.getTelefone();
		this.whatsapp = passageiros.getWhatsapp();
		this.rg = passageiros.getRg();
		this.cpf = passageiros.getCpf();
		if (passageiros.getDataNascimento() != null)
			this.dataNascimento = DateUtiuls.formatDateBr(passageiros.getDataNascimento());

		if (passageiros.getDataCadastro() != null)
			this.dataCadastro = passageiros.getDataCadastro();

		if (passageiros.getStatus() != null)
			this.status = passageiros.getStatus().getDescricao();

		this.endereco = passageiros.getEndereco();
	}

	public ViajensDto getViajem() {
		return viajem;
	}

	public void setViajem(ViajensDto viajem) {
		this.viajem = viajem;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public Integer getQtdViajens() {
		return qtdViajens;
	}

	public void setQtdViajens(Integer qtdViajens) {
		this.qtdViajens = qtdViajens;
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

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

}
