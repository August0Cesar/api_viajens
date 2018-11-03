package br.com.augusto.response.dto;

import java.util.List;

import br.com.augusto.models.TipoViajem;

public class EmpresaDto {
	private String nomeEmpresa;
	private Integer empresaId;
	private List<ViajensDto> viajens;
	private List<TipoViajem> tipoViajens;

	public EmpresaDto() {
	}

	public EmpresaDto(String nomeEmpresa, Integer empresaId, List<ViajensDto> viajens,List<TipoViajem> tipoViajens) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.empresaId = empresaId;
		this.viajens = viajens;
		this.tipoViajens = tipoViajens;
	}

	public List<TipoViajem> getTipoViajens() {
		return tipoViajens;
	}

	public void setTipoViajens(List<TipoViajem> tipoViajens) {
		this.tipoViajens = tipoViajens;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public List<ViajensDto> getViajens() {
		return viajens;
	}

	public void setViajens(List<ViajensDto> viajens) {
		this.viajens = viajens;
	}

	@Override
	public String toString() {
		return "EmpresaDto [nomeEmpresa=" + nomeEmpresa + ", empresaId=" + empresaId + ", viajens=" + viajens + "]";
	}
}
