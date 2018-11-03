package br.com.augusto.request.dto;

public class DetalhesViajemRequestDto {
	private Integer empresaId;
	private Integer viajemId;

	public DetalhesViajemRequestDto() {
	}

	public DetalhesViajemRequestDto(Integer empresaId, Integer viajemId) {
		super();
		this.empresaId = empresaId;
		this.viajemId = viajemId;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public Integer getViajemId() {
		return viajemId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

}
