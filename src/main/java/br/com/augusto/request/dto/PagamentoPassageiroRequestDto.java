package br.com.augusto.request.dto;

public class PagamentoPassageiroRequestDto {
	private Integer passageiroId;
	private Integer viajemId;

	public PagamentoPassageiroRequestDto() {
	}

	public PagamentoPassageiroRequestDto(Integer passageiroId, Integer viajemId) {
		super();
		this.passageiroId = passageiroId;
		this.viajemId = viajemId;
	}

	public Integer getViajemId() {
		return viajemId;
	}

	public Integer getPassageiroId() {
		return passageiroId;
	}

	public void setPassageiroId(Integer passageiroId) {
		this.passageiroId = passageiroId;
	}

	public void setViajemId(Integer viajemId) {
		this.viajemId = viajemId;
	}

}
