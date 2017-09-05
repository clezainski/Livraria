package com.projeto.livraria.http;

import java.util.List;

public class Livro {

	private Integer id;
	private String titulo;
	private String subtitulo;
	private List<String> autores;
	private String isbn;
	private Genero genero;
	
	public Livro() {
		
	}
	
	public Livro (Integer id, String titulo, String subtitulo, List<String> autores, String isbn, Genero genero) {
		this.id = id;
		this.genero = genero;
		this.autores = autores;
		this.isbn = isbn;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}	
}
