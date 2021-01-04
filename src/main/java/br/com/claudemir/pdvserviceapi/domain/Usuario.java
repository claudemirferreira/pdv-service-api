package br.com.claudemir.pdvserviceapi.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 60, nullable = false, unique = true)
	private String login;

	@Column(length = 100, nullable = false)
	private String senha;

	@Column(length = 100, nullable = false)
	private String email;

	public Usuario() {
	}

	public Usuario(Integer id, String login, String senha, String email) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public Usuario(Integer id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario categoria = (Usuario) o;
		return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
