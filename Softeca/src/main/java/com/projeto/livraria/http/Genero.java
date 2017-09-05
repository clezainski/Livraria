package com.projeto.livraria.http;

public class Genero {

	private Integer id;
	private String genero;
	private int idade_recomendada;
	
	public Genero() {
		
	}
	
	public Genero (Integer id, String genero, int idade) {
		this.id = id;
		this.genero = genero;
		this.idade_recomendada = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdade_recomendada() {
		return idade_recomendada;
	}

	public void setIdade_recomendada(int idade_recomendada) {
		this.idade_recomendada = idade_recomendada;
	}
}
