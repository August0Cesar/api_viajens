package br.com.augusto.request.dto;

import java.util.Date;

public class PassageiroRequestDto {
	private String bairro;
	private String cidade;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private String nomePassageiro;
	private String rg;
	private String rua;
	private String estado;
	private String telefone;
	private String whatsApp;
	private Integer viajemId;
	private Integer empresaId;

	public PassageiroRequestDto() {
	}

	public PassageiroRequestDto(String bairro, String cidade, String cpf, Date dataNascimento, String email,
			String nomePassageiro, String rg, String rua, String telefone, String whatsApp, Integer viajemId,
			String estado, Integer empresaId) {
		super();
		this.bairro = bairro;
		this.cidade = cidade;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.nomePassageiro = nomePassageiro;
		this.rg = rg;
		this.rua = rua;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.viajemId = viajemId;
		this.estado = estado;
		this.empresaId = empresaId;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public Integer getViajemId() {
		return viajemId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

	@Override
	public String toString() {
		return "PassageiroRequestDto [bairro=" + bairro + ", cidade=" + cidade + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", nomePassageiro=" + nomePassageiro + ", rg=" + rg + ", rua="
				+ rua + ", telefone=" + telefone + ", whatsApp=" + whatsApp + ", viajemId=" + viajemId + "]";
	}

}
