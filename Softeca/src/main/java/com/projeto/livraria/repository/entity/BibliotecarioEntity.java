package com.projeto.livraria.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_bibliotecario")
public class BibliotecarioEntity extends UsuarioEntity {

	@Column(name="matricula")	
	private int  matricula;
	
	@Column(name="senha")	
	private String  senha;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
