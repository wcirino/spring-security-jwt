package com.projetoSpringSec.Spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "login")
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private  int idlogin;
	
	@Column(name="login")
	private  String login;
	
	@Column(name="senha")
	//@Size(min = 8, max = 25)
	private  String senha; 
	
	//@Column(name="email")
	@Email(message = "Por favor, validar o email")
	private  String email;
	
	@Column(name="senhainicial")
	private  String senhainicial;
	
	@Column(name="ativo")
	private  String ativo;
	
	@Column(name="ultimologin")
	private  String ultimologin;
	
	@Column(name = "account_non_expired")
	private Boolean AccountNonExpired;
	
	@Column(name = "account_non_locked")
	private Boolean AccountNonLocked;
	
	@Column(name = "credentials_non_expired")
	private Boolean CredentialsNonExpired;
	
	@Column(name = "enabled")
	private Boolean Enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_beneficiario", joinColumns = { @JoinColumn(name = "idlogin")},
		inverseJoinColumns = { @JoinColumn(name = "idperfil")})
	private List<Perfils> perfils;
	
	public List<String> getRole(){
		 List<String>  roles = new ArrayList<>();
		 for(Perfils perfil : this.perfils) {
			 roles.add(perfil.getPerfil());
		 }
		 
		 //Stream
		 //List<String> role = perfils.stream().map(c -> c.getPerfil()).collect(Collectors.toList());
		 //List<String> role = perfils.stream().map(Perfils::getPerfil).collect(Collectors.toList());
		 
		 return roles;
	}
	
	
	
	public User(int idlogin, String login, String senha, @Email(message = "Por favor, validar o email") String email,
			String senhainicial, String ativo, String ultimologin, Boolean accountNonExpired, Boolean accountNonLocked,
			Boolean credentialsNonExpired, Boolean enabled, List<Perfils> perfils) {
		super();
		this.idlogin = idlogin;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.senhainicial = senhainicial;
		this.ativo = ativo;
		this.ultimologin = ultimologin;
		AccountNonExpired = accountNonExpired;
		AccountNonLocked = accountNonLocked;
		CredentialsNonExpired = credentialsNonExpired;
		Enabled = enabled;
		this.perfils = perfils;
	}

	public User() {
		super();
	}

	public int getIdlogin() {
		return idlogin;
	}



	public void setIdlogin(int idlogin) {
		this.idlogin = idlogin;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenhainicial() {
		return senhainicial;
	}



	public void setSenhainicial(String senhainicial) {
		this.senhainicial = senhainicial;
	}



	public String getAtivo() {
		return ativo;
	}



	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}



	public String getUltimologin() {
		return ultimologin;
	}



	public void setUltimologin(String ultimologin) {
		this.ultimologin = ultimologin;
	}



	public Boolean getAccountNonExpired() {
		return AccountNonExpired;
	}



	public void setAccountNonExpired(Boolean accountNonExpired) {
		AccountNonExpired = accountNonExpired;
	}



	public Boolean getAccountNonLocked() {
		return AccountNonLocked;
	}



	public void setAccountNonLocked(Boolean accountNonLocked) {
		AccountNonLocked = accountNonLocked;
	}



	public Boolean getCredentialsNonExpired() {
		return CredentialsNonExpired;
	}



	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		CredentialsNonExpired = credentialsNonExpired;
	}



	public Boolean getEnabled() {
		return Enabled;
	}



	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}



	public List<Perfils> getPerfils() {
		return perfils;
	}



	public void setPerfils(List<Perfils> perfils) {
		this.perfils = perfils;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfils;
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
		return this.AccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.AccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.CredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.Enabled;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AccountNonExpired == null) ? 0 : AccountNonExpired.hashCode());
		result = prime * result + ((AccountNonLocked == null) ? 0 : AccountNonLocked.hashCode());
		result = prime * result + ((CredentialsNonExpired == null) ? 0 : CredentialsNonExpired.hashCode());
		result = prime * result + ((Enabled == null) ? 0 : Enabled.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idlogin;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((perfils == null) ? 0 : perfils.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhainicial == null) ? 0 : senhainicial.hashCode());
		result = prime * result + ((ultimologin == null) ? 0 : ultimologin.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (AccountNonExpired == null) {
			if (other.AccountNonExpired != null)
				return false;
		} else if (!AccountNonExpired.equals(other.AccountNonExpired))
			return false;
		if (AccountNonLocked == null) {
			if (other.AccountNonLocked != null)
				return false;
		} else if (!AccountNonLocked.equals(other.AccountNonLocked))
			return false;
		if (CredentialsNonExpired == null) {
			if (other.CredentialsNonExpired != null)
				return false;
		} else if (!CredentialsNonExpired.equals(other.CredentialsNonExpired))
			return false;
		if (Enabled == null) {
			if (other.Enabled != null)
				return false;
		} else if (!Enabled.equals(other.Enabled))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idlogin != other.idlogin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (perfils == null) {
			if (other.perfils != null)
				return false;
		} else if (!perfils.equals(other.perfils))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhainicial == null) {
			if (other.senhainicial != null)
				return false;
		} else if (!senhainicial.equals(other.senhainicial))
			return false;
		if (ultimologin == null) {
			if (other.ultimologin != null)
				return false;
		} else if (!ultimologin.equals(other.ultimologin))
			return false;
		return true;
	}

	
}
