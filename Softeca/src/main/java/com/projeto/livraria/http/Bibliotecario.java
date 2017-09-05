package com.projeto.livraria.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bibliotecario extends Usuario{

	private int matricula;
	private String senha;
	
	public Bibliotecario() {
		
	}
	
	public Bibliotecario (int id, String nome, String sobrenome, String cpf, String data_nascimento, int matricula, String senha) {
		super(id, nome, sobrenome, cpf, data_nascimento);
		this.matricula = matricula;
		this.senha = senha;		
	}

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
