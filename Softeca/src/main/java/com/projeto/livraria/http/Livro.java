package com.projeto.livraria.http;

public class Livro {

	private Integer id;
	private String titulo;
	private String subtitulo;
	private String autor;
	private String isbn;
	private String genero;
	
	public Livro() {
		
	}
	
	public Livro (Integer id, String titulo, String subtitulo, String autor, String isbn, String genero) {
		this.id = id;
		this.genero = genero;
		this.autor = autor;
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

	public String getAutor() {
		return autor;
	}

	public void setAutores(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}	
}
