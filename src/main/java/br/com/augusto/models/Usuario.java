package br.com.augusto.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;

	@Column(name = "nome_usuario")
	private String nomeUsuario;

	@NotEmpty
	private String senha;
	private String email;
	private String telefone;

	@NotEmpty
	private String senhaNoCripted;

	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresas empresas;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Enderecos endereco;

	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;

	public Empresas getEmpresas() {
		return empresas;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Usuario() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenhaNoCripted() {
		return senhaNoCripted;
	}

	public void setSenhaNoCripted(String senhaNoCripted) {
		this.senhaNoCripted = senhaNoCripted;
	}

	public Usuario(String login, String nomeCompleto, Boolean active, String senha, List<Role> roles,
			String senhaNoCripted) {
		this.login = login;
		this.nomeUsuario = nomeCompleto;
		this.senha = senha;
		this.roles = roles;
		this.senhaNoCripted = senhaNoCripted;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}