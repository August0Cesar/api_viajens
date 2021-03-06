package br.com.augusto.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.augusto.request.dto.ViajemRequestDto;

@Entity
@Table(name = "viajens")
public class Viajens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_viajem")
	private String nomeViajem;

	@Column(name = "valor_viajem")
	private BigDecimal valorViajem;

	private String descricao;

	@Column(name = "data_inicio")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "data_final")
	@Temporal(TemporalType.DATE)
	private Date dataFinal;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(name = "qtd_passageiros")
	private Integer qtdPassageiros;

	@OneToOne
	@JoinColumn(name = "tipo_viajem_id")
	private TipoViajem tipoViajem;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresas empresas;

	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@ManyToMany
	@JoinTable(name = "viajens_passageiros", joinColumns = { @JoinColumn(name = "viajem_id") }, inverseJoinColumns = {
			@JoinColumn(name = "passageiro_id") })
	private List<Passageiros> passageiros;

	private Integer cafeManha;
	private Integer almoco;
	private Integer jantar;
	private Integer dias;
	private Boolean hospedagem;
	private String localHospedagem;
	private String urlHospedagem;

	public Viajens(ViajemRequestDto viajemRequestDto) {
		this.nomeViajem = viajemRequestDto.getNomeViajem();
		this.descricao = viajemRequestDto.getDescricao();
		this.qtdPassageiros = viajemRequestDto.getQtdPassageiros();
		this.dataInicio = viajemRequestDto.getDataInicio();
		this.dataCadastro = new Date();
		this.dataFinal = viajemRequestDto.getDataFinal();
		this.valorViajem = viajemRequestDto.getValorViajem();
		this.cafeManha = viajemRequestDto.getAlmoco();
		this.almoco = viajemRequestDto.getAlmoco();
		this.jantar = viajemRequestDto.getJantar();
		this.dias = viajemRequestDto.getDias();
		this.hospedagem = viajemRequestDto.getHospedagem();
		this.localHospedagem = viajemRequestDto.getLocalHospedagem();
		this.urlHospedagem = viajemRequestDto.getUrlHospedagem();
	}

	public Viajens() {
	}

	public Integer getCafeManha() {
		return cafeManha;
	}

	public void setCafeManha(Integer cafeManha) {
		this.cafeManha = cafeManha;
	}

	public Integer getAlmoco() {
		return almoco;
	}

	public void setAlmoco(Integer almoco) {
		this.almoco = almoco;
	}

	public Integer getJantar() {
		return jantar;
	}

	public void setJantar(Integer jantar) {
		this.jantar = jantar;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Boolean getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Boolean hospedagem) {
		this.hospedagem = hospedagem;
	}

	public String getLocalHospedagem() {
		return localHospedagem;
	}

	public void setLocalHospedagem(String localHospedagem) {
		this.localHospedagem = localHospedagem;
	}

	public String getUrlHospedagem() {
		return urlHospedagem;
	}

	public void setUrlHospedagem(String urlHospedagem) {
		this.urlHospedagem = urlHospedagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeViajem() {
		return nomeViajem;
	}

	public void setNomeViajem(String nomeViajem) {
		this.nomeViajem = nomeViajem;
	}

	public BigDecimal getValorViajem() {
		return valorViajem;
	}

	public void setValorViajem(BigDecimal valorViajem) {
		this.valorViajem = valorViajem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(Integer qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	public TipoViajem getTipoViajem() {
		return tipoViajem;
	}

	public void setTipoViajem(TipoViajem tipoViajem) {
		this.tipoViajem = tipoViajem;
	}

	public Empresas getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Passageiros> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Passageiros> passageiros) {
		this.passageiros = passageiros;
	}

	@Override
	public String toString() {
		return "Viajens [id=" + id + ", nomeViajem=" + nomeViajem + ", valorViajem=" + valorViajem + ", descricao="
				+ descricao + ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", dataCadastro="
				+ dataCadastro + ", qtdPassageiros=" + qtdPassageiros + ", tipoViajem=" + tipoViajem + ", empresas="
				+ empresas + ", status=" + status + ", passageiros=" + passageiros + "]";
	}

}
