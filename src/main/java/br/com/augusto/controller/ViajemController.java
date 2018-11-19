package br.com.augusto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.augusto.models.Custos;
import br.com.augusto.models.Empresas;
import br.com.augusto.models.Passageiros;
import br.com.augusto.models.Status;
import br.com.augusto.models.TipoViajem;
import br.com.augusto.models.Viajens;
import br.com.augusto.repository.CustosRepository;
import br.com.augusto.repository.EmpresaRepository;
import br.com.augusto.repository.PagamentosPassageirosRepository;
import br.com.augusto.repository.PassageirosRepository;
import br.com.augusto.repository.StatusRepository;
import br.com.augusto.repository.TipoViajemRepository;
import br.com.augusto.repository.UsuarioRepository;
import br.com.augusto.repository.ViajemRepository;
import br.com.augusto.request.dto.CustoViajemRequestDto;
import br.com.augusto.request.dto.DetalhesViajemRequestDto;
import br.com.augusto.request.dto.ViajemRequestDto;
import br.com.augusto.response.dto.CustosDto;
import br.com.augusto.response.dto.DetalheViajemPassageiroDto;
import br.com.augusto.response.dto.DetalhesViajemDto;
import br.com.augusto.response.dto.ViajensDto;

@RestController
public class ViajemController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ViajemRepository viajemRepository;

	@Autowired
	CustosRepository custosRepository;

	@Autowired
	PagamentosPassageirosRepository pagamentosPassageiroscustosRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	TipoViajemRepository tipoViajemRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	PassageirosRepository passageirosRepository;

	final String PAGAMENTO_PASSAGEIROS = "PAGAMENTO_PASSAGEIROS";
	final String VIAJEM = "VIAJEM";
	final String PASSAGEIRO = "PASSAGEIRO";

	@PostMapping("/viajens")
	@ResponseBody
	public List<ViajensDto> saveViajens(@RequestBody ViajemRequestDto viajemRequestDto) {
		if (viajemRequestDto == null)
			return null;

		Status status = statusRepository.findStatusByEntidade(VIAJEM, "ATIVO");
		Empresas empresa = empresaRepository.findEmpresaById(viajemRequestDto.getEmpresaId());
		TipoViajem tipoViajem = tipoViajemRepository.findTipoViajemById(viajemRequestDto.getTipoViajem());
		if (status == null || empresa == null || tipoViajem == null)
			return null;

		Viajens viajem = new Viajens(viajemRequestDto);
		viajem.setEmpresas(empresa);
		viajem.setStatus(status);
		viajem.setTipoViajem(tipoViajem);

		viajemRepository.save(viajem);
		return buscaViajens(empresa.getId(), tipoViajem.getDescricao());
	}

	private List<ViajensDto> buscaViajens(Integer empresaId, String tipoViajem) {
		List<ViajensDto> lista = new ArrayList<>();
		List<Viajens> listaViajens = new ArrayList<>();
		listaViajens = viajemRepository.findByEMpresaAndTipoViajem(empresaId, tipoViajem);
		Status statusPagamento = statusRepository.findStatusByEntidade(PAGAMENTO_PASSAGEIROS, "PAGO");
		Status statusAtivo = statusRepository.findStatusByEntidade(PASSAGEIRO, "ATIVO");
		if (!listaViajens.isEmpty()) {
			for (Viajens viajens : listaViajens) {
				BigDecimal totalCusto = custosRepository.findTotalCustoByViajem(viajens.getId());
				BigDecimal valorPago = pagamentosPassageiroscustosRepository.findTotalPagamentos(viajens.getId(),
						statusPagamento.getId(), statusAtivo.getId());
				ViajensDto viajensDto = new ViajensDto(viajens);
				viajensDto.setTotalCusto(totalCusto != null ? totalCusto : BigDecimal.ZERO);
				viajensDto.setValorPago(valorPago != null ? valorPago : BigDecimal.ZERO);
				lista.add(viajensDto);
			}
		}
		return lista;
	}

	@PostMapping("/detalhesViajem")
	@ResponseBody
	public DetalhesViajemDto buscaDetalhesViajens(@RequestBody DetalhesViajemRequestDto detalheViajem) {
		if (detalheViajem == null)
			return null;

		DetalhesViajemDto detalheViajemDto = new DetalhesViajemDto();
		Status statusAtivo = statusRepository.findStatusByEntidade(PASSAGEIRO, "ATIVO");
		Status statusPagamento = statusRepository.findStatusByEntidade(PAGAMENTO_PASSAGEIROS, "PAGO");
		Viajens viajem = viajemRepository.findViajemById(detalheViajem.getViajemId());

		if (viajem != null && statusPagamento != null) {
			BigDecimal totalCusto = custosRepository.findTotalCustoByViajem(viajem.getId());
			BigDecimal valorPago = pagamentosPassageiroscustosRepository.findTotalPagamentos(viajem.getId(),
					statusPagamento.getId(), statusAtivo.getId());
			ViajensDto viajensDto = new ViajensDto(viajem);
			viajensDto.setTotalCusto(totalCusto != null ? totalCusto : BigDecimal.ZERO);
			viajensDto.setValorPago(valorPago != null ? valorPago : BigDecimal.ZERO);
			detalheViajemDto.setViajem(viajensDto);

			List<Passageiros> passagetiros = filtraPassageirosAtivos(viajem.getPassageiros());
			List<DetalheViajemPassageiroDto> listaDetalheViajemPassageiroDto = new ArrayList<>();
			for (Passageiros passageiro : passagetiros) {
				if (passageiro.getStatus().getId() == statusAtivo.getId()) {
					DetalheViajemPassageiroDto detalheViajemPassageiro = new DetalheViajemPassageiroDto();
					Integer qtdParcelasPagas = pagamentosPassageiroscustosRepository.findQtdParcelasPagasByPassageiro(
							viajem.getId(), statusPagamento.getId(), passageiro.getId());
					Integer qtdParcelas = pagamentosPassageiroscustosRepository
							.findQtdParcelasByPassageiro(viajem.getId(), passageiro.getId());
					BigDecimal valorPagoPorPassageiro = pagamentosPassageiroscustosRepository
							.findTotalPagamentosByPassageiro(viajem.getId(), statusPagamento.getId(),
									passageiro.getId());

					detalheViajemPassageiro.setNomePassageiro(passageiro.getNomePassageiro());
					detalheViajemPassageiro.setPassageiroId(passageiro.getId());
					detalheViajemPassageiro.setParcelasPagas(qtdParcelasPagas == null ? 0 : qtdParcelasPagas);
					detalheViajemPassageiro.setQtdParcelas(qtdParcelas == null ? 0 : qtdParcelas);
					detalheViajemPassageiro
							.setValorPago(valorPagoPorPassageiro == null ? BigDecimal.ZERO : valorPagoPorPassageiro);
					listaDetalheViajemPassageiroDto.add(detalheViajemPassageiro);
				}
			}
			detalheViajemDto.setPassageiros(listaDetalheViajemPassageiroDto);

			List<Custos> listaCustos = new ArrayList<>();
			listaCustos = custosRepository.findCustosByViajem(detalheViajem.getViajemId());
			if (listaCustos.isEmpty()) {
				detalheViajemDto.setCustos(new ArrayList<>());
			} else {
				List<CustosDto> listaCustosDto = new ArrayList<>();
				listaCustos.forEach(c -> {
					CustosDto custo = new CustosDto(c);
					listaCustosDto.add(custo);
				});
				detalheViajemDto.setCustos(listaCustosDto);
			}
		}

		return detalheViajemDto;

	}

	private List<Passageiros> filtraPassageirosAtivos(List<Passageiros> passageiros) {
		List<Passageiros> listaPassageiros = new ArrayList<>();
		passageiros.stream().filter(p -> p.getStatus().getDescricao().equals("ATIVO"))
				.forEach(p -> listaPassageiros.add(p));
		return listaPassageiros;
	}

	@PostMapping("/custoViajem")
	@ResponseBody
	public CustosDto buscaDetalhesViajens(@RequestBody CustoViajemRequestDto custoViajem) {
		if (custoViajem == null)
			return null;
		Viajens viajem = viajemRepository.findViajemById(custoViajem.getViajemId());
		if (viajem != null) {
			Custos custo = new Custos(custoViajem);
			custo.setViajem(viajem);
			custosRepository.save(custo);
			return new CustosDto(custo);
		} else {
			return null;
		}
	}

	@PostMapping("/editCustoViajem")
	@ResponseBody
	public CustosDto editDetalhesViajens(@RequestBody CustoViajemRequestDto custoViajem,
			@RequestParam Integer custoId) {
		if (custoViajem == null && custoId == null)
			return null;

		Custos custo = custosRepository.findCustoBycustoId(custoId);
		custo.setDescricao(custoViajem.getDescricao());
		custo.setValor(custoViajem.getValor());
		custosRepository.save(custo);

		/*
		 * Viajens viajem = viajemRepository.findViajemById(custoViajem.getViajemId());
		 * if (viajem != null) { Custos custo = new Custos(custoViajem);
		 * custo.setViajem(viajem); custosRepository.save(custo);
		 */
		return new CustosDto(custo);

	}
	
	@PostMapping("/deleteCustoViajem")
	public void deleteDetalhesViajens(@RequestParam Integer custoId) {
		
		custosRepository.deleteById(custoId);
	}

}
