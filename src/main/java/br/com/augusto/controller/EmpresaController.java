package br.com.augusto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.augusto.models.Status;
import br.com.augusto.models.TipoViajem;
import br.com.augusto.models.Usuario;
import br.com.augusto.models.Viajens;
import br.com.augusto.repository.CustosRepository;
import br.com.augusto.repository.PagamentosPassageirosRepository;
import br.com.augusto.repository.StatusRepository;
import br.com.augusto.repository.TipoViajemRepository;
import br.com.augusto.repository.UsuarioRepository;
import br.com.augusto.repository.ViajemRepository;
import br.com.augusto.response.dto.EmpresaDto;
import br.com.augusto.response.dto.ViajensDto;
import br.com.augusto.security.TokenAuthenticationService;

@RestController
public class EmpresaController {

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
	
	final String PAGAMENTO_PASSAGEIROS = "PAGAMENTO_PASSAGEIROS";
	final String PASSAGEIRO = "PASSAGEIRO";
	
	@GetMapping("/viajens")
	@ResponseBody
	public EmpresaDto buscaViajens(HttpServletRequest request, @RequestParam String tipoViajem) {
		List<ViajensDto> lista = new ArrayList<>();
		String user = TokenAuthenticationService.getAuthenticatioTeste(request);
		Usuario usuario = usuarioRepository.findByLogin(user);
		if (usuario == null) {
			return null;
		}
		List<Viajens> listaViajens = new ArrayList<>();
		listaViajens = viajemRepository.findByEMpresaAndTipoViajem(usuario.getEmpresas().getId(), tipoViajem);
		Status statusPagamento = statusRepository.findStatusByEntidade(PAGAMENTO_PASSAGEIROS, "PAGO");
		Status statusAtivo = statusRepository.findStatusByEntidade(PASSAGEIRO, "ATIVO");
		if (!listaViajens.isEmpty()) {
			for (Viajens viajens : listaViajens) {
				BigDecimal totalCusto  = custosRepository.findTotalCustoByViajem(viajens.getId());
				BigDecimal valorPago  = pagamentosPassageiroscustosRepository.findTotalPagamentos(viajens.getId(), statusPagamento.getId(),statusAtivo.getId());
				ViajensDto viajensDto = new ViajensDto(viajens);
				viajensDto.setTotalCusto(totalCusto != null ? totalCusto : BigDecimal.ZERO);
				viajensDto.setValorPago(valorPago != null ? valorPago : BigDecimal.ZERO);
				lista.add(viajensDto);
			}
		}
		List<TipoViajem> tipoViajens = (List<TipoViajem>) tipoViajemRepository.findAll();
		if(tipoViajens.isEmpty())
			tipoViajens = new ArrayList<>();
		
		return new EmpresaDto(usuario.getEmpresas().getNome_empresa(), usuario.getEmpresas().getId(), lista,tipoViajens);
	}

}
