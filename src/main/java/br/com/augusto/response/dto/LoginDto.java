package br.com.augusto.response.dto;

public class LoginDto {
	private Integer empresaId;
	private String nomeEempresa;
	private String tonken;
	private String suario;
	private String headerToken;

	public LoginDto(Integer empresaId, String nomeEempresa, String tonken, String headerToken, String suario) {
		super();
		this.empresaId = empresaId;
		this.nomeEempresa = nomeEempresa;
		this.tonken = tonken;
		this.headerToken = headerToken;
		this.suario = suario;
	}

	public String getHeaderToken() {
		return headerToken;
	}

	public void setHeaderToken(String headerToken) {
		this.headerToken = headerToken;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public String getNomeEempresa() {
		return nomeEempresa;
	}

	public void setNomeEempresa(String nomeEempresa) {
		this.nomeEempresa = nomeEempresa;
	}

	public String getTonken() {
		return tonken;
	}

	public void setTonken(String tonken) {
		this.tonken = tonken;
	}

	public String getSuario() {
		return suario;
	}

	public void setSuario(String suario) {
		this.suario = suario;
	}

}
