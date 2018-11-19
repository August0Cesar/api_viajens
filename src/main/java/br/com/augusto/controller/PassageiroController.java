package br.com.augusto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.augusto.models.Empresas;
import br.com.augusto.models.Enderecos;
import br.com.augusto.models.FormaPagamento;
import br.com.augusto.models.PagamentosPassageiros;
import br.com.augusto.models.Passageiros;
import br.com.augusto.models.Status;
import br.com.augusto.models.Viajens;
import br.com.augusto.repository.CustosRepository;
import br.com.augusto.repository.EmpresaRepository;
import br.com.augusto.repository.EnderecosRepository;
import br.com.augusto.repository.FormaPagamentoRepository;
import br.com.augusto.repository.PagamentosPassageirosRepository;
import br.com.augusto.repository.PassageirosRepository;
import br.com.augusto.repository.StatusRepository;
import br.com.augusto.repository.TipoViajemRepository;
import br.com.augusto.repository.UsuarioRepository;
import br.com.augusto.repository.ViajemRepository;
import br.com.augusto.request.dto.PagamentoPassageiroRequestDto;
import br.com.augusto.request.dto.PagamentoRequestDto;
import br.com.augusto.request.dto.PassageiroRequestDto;
import br.com.augusto.response.dto.DetalheViajemPassageiroDto;
import br.com.augusto.response.dto.PagamentoPassageiroDto;
import br.com.augusto.response.dto.PagamentoDto;
import br.com.augusto.response.dto.PassageiroDto;
import br.com.augusto.response.dto.ViajensDto;

@RestController
public class PassageiroController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ViajemRepository viajemRepository;

	@Autowired
	CustosRepository custosRepository;

	@Autowired
	PagamentosPassageirosRepository pagamentosPassageirosRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	TipoViajemRepository tipoViajemRepository;

	@Autowired
	PassageirosRepository passageirosRepository;

	@Autowired
	EnderecosRepository enderecoRepository;

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;

	final String PAGAMENTO_PASSAGEIROS = "PAGAMENTO_PASSAGEIROS";
	final String PASSAGEIRO = "PASSAGEIRO";

	@GetMapping("/passageiros")
	@ResponseBody
	public List<PassageiroDto> buscaPassageiros(@RequestParam Integer empresaId) {
		List<Passageiros> listaPassageiros = passageirosRepository.findAllByEmpresa(empresaId);
		List<PassageiroDto> listaPassageiroDto = new ArrayList<>();
		Status statusAtivo = statusRepository.findStatusByEntidade(PASSAGEIRO, "ATIVO");
		if (listaPassageiros.isEmpty()) {
			return null;
		}
		listaPassageiros.sort((p1,p2)->p1.getNomePassageiro().compareTo(p2.getNomePassageiro()));
		for (Passageiros passageiros : listaPassageiros) {
			if (passageiros.getStatus().getId() == statusAtivo.getId()) {
				PassageiroDto passageiroDto = new PassageiroDto(passageiros);
				Integer qtdViajens = passageiros.getViajens().size();
				passageiroDto.setQtdViajens(qtdViajens == null ? 0 : qtdViajens);
				passageiroDto.setStatusPagamento(verificaStatusPagamento(
						pagamentosPassageirosRepository.findPagamentosByPassageiro(passageiros.getId())));
				passageiroDto.setViajem(verificaViajemProxima(passageiros.getViajens()));
				listaPassageiroDto.add(passageiroDto);
			}
		}
		return listaPassageiroDto;
	}

	private ViajensDto verificaViajemProxima(List<Viajens> viajens) {
		if (viajens.isEmpty())
			return null;
		viajens.sort((obj1, obj2) -> obj1.getDataInicio().compareTo(obj2.getDataInicio()));

		return new ViajensDto(viajens.get(0));
	}

	private String verificaStatusPagamento(List<PagamentosPassageiros> listaPagamentos) {
		if (listaPagamentos == null || listaPagamentos.isEmpty())
			return "AINDA NAO TEM PAGAMENTO";
		for (PagamentosPassageiros pagamentosPassageiros : listaPagamentos) {
			if (pagamentosPassageiros.getDataPagamento() == null) {
				if (pagamentosPassageiros.getDataVencimento() == null)
					return "Problemas com pagamentos.Por favor verifique";

				if (pagamentosPassageiros.getDataVencimento() != null
						&& pagamentosPassageiros.getDataVencimento().before(new Date()))
					return "PARCELA VENCIDA";

				if (pagamentosPassageiros.getDataVencimento() != null
						&& pagamentosPassageiros.getDataVencimento().after(new Date()))
					return "PARCELAS EM ABERTO";

			}
		}
		return "PAGO";
	}

	@PostMapping("/passageiros")
	@ResponseBody
	public PassageiroDto cadastroPassageiro(@RequestBody PassageiroRequestDto passageiro) {
		List<Viajens> viajens = new ArrayList<>();
		Status status = statusRepository.findStatusByEntidade(PASSAGEIRO, "ATIVO");
		Empresas empresa = empresaRepository.findEmpresaById(passageiro.getEmpresaId());
		Viajens viajem = viajemRepository.findViajemById(passageiro.getViajemId());
		viajens.add(viajem);
		Enderecos endereco = new Enderecos(passageiro);
		Passageiros passageiros = new Passageiros(passageiro);
		passageiros.setEmpresas(empresa);
		passageiros.setStatus(status);
		passageiros.setViajens(viajens);
		passageiros.setEndereco(enderecoRepository.save(endereco));
		passageirosRepository.save(passageiros);

		viajem.getPassageiros().add(passageiros);
		viajemRepository.save(viajem);

		return new PassageiroDto(passageiros);
	}
	@PostMapping("/editPassageiro")
	@ResponseBody
	public PassageiroDto editaPassageiro(@RequestBody PassageiroRequestDto passageiro,@RequestParam Integer passageiroId) {
		Passageiros passageiroAtual = passageirosRepository.findPassageiroById(passageiroId);
		Enderecos endereco = enderecoRepository.fndEnderecoById(passageiroAtual.getEndereco().getId());
		endereco.setBairro(passageiro.getBairro());
		endereco.setCidade(passageiro.getCidade());
		endereco.setEstado(passageiro.getEstado());
		endereco.setRua(passageiro.getRua());
		enderecoRepository.save(endereco);
		
		passageiroAtual.setCpf(passageiro.getCpf());
		passageiroAtual.setRg(passageiro.getRg());
		passageiroAtual.setEmail(passageiro.getEmail());
		passageiroAtual.setDataNascimento(passageiro.getDataNascimento());
		passageiroAtual.setTelefone(passageiro.getTelefone());
		passageiroAtual.setWhatsapp(passageiro.getWhatsApp());
		passageiroAtual.setNomePassageiro(passageiro.getNomePassageiro());
		passageirosRepository.save(passageiroAtual);

		return new PassageiroDto(passageiroAtual);
	}

	@PostMapping("/deletePassageiros")
	@ResponseBody
	public List<DetalheViajemPassageiroDto> deletePassageiro(@RequestParam Integer passageiroId,
			@RequestParam Integer viajemId) {
		Status statusCancelado = statusRepository.findStatusByEntidade(PASSAGEIRO, "CANCELADO");
		Passageiros passageiroCancelado = passageirosRepository.findPassageiroById(passageiroId);
		passageiroCancelado.setStatus(statusCancelado);
		passageirosRepository.save(passageiroCancelado);

		Viajens viajem = viajemRepository.findViajemById(viajemId);
		List<DetalheViajemPassageiroDto> listaDetalheViajemPassageiroDto = new ArrayList<>();
		if (viajem != null) {
			Status statusAtivo = statusRepository.findStatusByEntidade(PASSAGEIRO, "ATIVO");
			Status statusPagamento = statusRepository.findStatusByEntidade(PAGAMENTO_PASSAGEIROS, "PAGO");
			viajem.getPassageiros().stream().filter(passageiro -> passageiro.getStatus().getId() == statusAtivo.getId())
					.forEach(passageiro -> {
						DetalheViajemPassageiroDto detalheViajemPassageiro = new DetalheViajemPassageiroDto();
						Integer qtdParcelasPagas = pagamentosPassageirosRepository
								.findQtdParcelasPagasByPassageiro(viajem.getId(), statusPagamento.getId(),
										passageiro.getId());
						Integer qtdParcelas = pagamentosPassageirosRepository
								.findQtdParcelasByPassageiro(viajem.getId(), passageiro.getId());
						BigDecimal valorPagoPorPassageiro = pagamentosPassageirosRepository
								.findTotalPagamentosByPassageiro(viajem.getId(), statusPagamento.getId(),
										passageiro.getId());

						detalheViajemPassageiro.setNomePassageiro(passageiro.getNomePassageiro());
						detalheViajemPassageiro.setPassageiroId(passageiro.getId());
						detalheViajemPassageiro.setParcelasPagas(qtdParcelasPagas == null ? 0 : qtdParcelasPagas);
						detalheViajemPassageiro.setQtdParcelas(qtdParcelas == null ? 0 : qtdParcelas);
						detalheViajemPassageiro.setValorPago(
								valorPagoPorPassageiro == null ? BigDecimal.ZERO : valorPagoPorPassageiro);
						listaDetalheViajemPassageiroDto.add(detalheViajemPassageiro);
					});
		}
		return listaDetalheViajemPassageiroDto;
	}
	
	@PostMapping("/pagamentoPassageiros")
	@ResponseBody
	public PagamentoPassageiroDto cadastroPassageiro(@RequestBody PagamentoPassageiroRequestDto pagamentoPassageiroRequestDto) {
		List<PagamentosPassageiros> pagamentos = pagamentosPassageirosRepository.findPagamentosByPassageiroAndViajem(pagamentoPassageiroRequestDto.getPassageiroId(),
				pagamentoPassageiroRequestDto.getViajemId());
		Viajens viajem = viajemRepository.findViajemById(pagamentoPassageiroRequestDto.getViajemId());
		Passageiros passageiro = passageirosRepository.findPassageiroById(pagamentoPassageiroRequestDto.getPassageiroId());
		
		PagamentoPassageiroDto retorno = new PagamentoPassageiroDto();
		retorno.setPassageiroId(passageiro.getId());
		retorno.setNomePassageiro(passageiro.getNomePassageiro());
		retorno.setNomeViajem(viajem.getNomeViajem());
		retorno.setViajemId(viajem.getId());
		retorno.setValorViajem(viajem.getValorViajem());
		
		List<PagamentoDto> listaPagamentos = new ArrayList<>();
		if(!pagamentos.isEmpty()) {
			pagamentos.forEach(p ->{
				PagamentoDto pagamentoDto = new PagamentoDto(p);
				listaPagamentos.add(pagamentoDto);
			});
		}
		retorno.setListaPagamentos(listaPagamentos);
		retorno.setStatus(verificaStatusPagamento(pagamentos));
		return retorno;
	}
	
	@PostMapping("/deletePagamentoPassageiro")
	public void deletePagamentoPassageiro(@RequestParam Integer pagamentoId) {
		
		pagamentosPassageirosRepository.deleteById(pagamentoId);
	}
	
	@PostMapping("/savePagamentoPassageiro")
	public void deletePagamentoPassageiro(@RequestBody PagamentoRequestDto pagamentoRequest) {
		Status statusPago = statusRepository.findStatusByEntidade(PAGAMENTO_PASSAGEIROS, "PAGO");
		Status statusEmAberto = statusRepository.findStatusByEntidade(PAGAMENTO_PASSAGEIROS, "PARCELAS EM ABERTO");
		Viajens viajem = viajemRepository.findViajemById(pagamentoRequest.getViajemId());
		Passageiros passageiro = passageirosRepository.findPassageiroById(pagamentoRequest.getPassageiroId());
		FormaPagamento formaPagamento = formaPagamentoRepository.findFormaPagamentoById(pagamentoRequest.getFormaPagamentoId());
		PagamentosPassageiros pagamento = new PagamentosPassageiros(pagamentoRequest);
		pagamento.setPassageiro(passageiro);
		pagamento.setViajem(viajem);
		pagamento.setFormaPagamento(formaPagamento);
		if(pagamentoRequest.getDataPagamento() == null) {
			pagamento.setStatus(statusEmAberto);
		}else {
			pagamento.setStatus(statusPago);
		}
		pagamentosPassageirosRepository.save(pagamento);
	}
	
}
