package br.com.augusto.response.dto;

import java.util.List;

import br.com.augusto.models.Custos;

public class DetalhesViajemDto {
	private ViajensDto viajem;
	private List<CustosDto> custos;
	private List<DetalheViajemPassageiroDto> passageiros;

	public DetalhesViajemDto() {
	}

	public DetalhesViajemDto(ViajensDto viajem, List<CustosDto> custos, List<DetalheViajemPassageiroDto> passageiros) {
		super();
		this.viajem = viajem;
		this.custos = custos;
		this.passageiros = passageiros;
	}

	public ViajensDto getViajem() {
		return viajem;
	}

	public void setViajem(ViajensDto viajem) {
		this.viajem = viajem;
	}

	public List<CustosDto> getCustos() {
		return custos;
	}

	public void setCustos(List<CustosDto> custos) {
		this.custos = custos;
	}

	public List<DetalheViajemPassageiroDto> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<DetalheViajemPassageiroDto> passageiros) {
		this.passageiros = passageiros;
	}

}
