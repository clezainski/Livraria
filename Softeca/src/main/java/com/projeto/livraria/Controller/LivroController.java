package com.projeto.livraria.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.projeto.livraria.http.Livro;
import com.projeto.livraria.repository.LivroRepository;
import com.projeto.livraria.repository.entity.LivroEntity;


@Path("/servicos/livro")
public class LivroController {

	private final LivroRepository livro_repository = new LivroRepository();

	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/add")
	public String Cadastrar(Livro livro){
		 
		LivroEntity entity = new LivroEntity();
 
		try { 
			entity.setTitulo(livro.getTitulo());
			entity.setSubtitulo(livro.getSubtitulo());
			entity.setAutor(livro.getAutor());
			entity.setIsbn(livro.getIsbn());
			entity.setGenero(livro.getGenero());
			 
			livro_repository.Salvar(entity);
 
			return "Livro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar livro." + e.getMessage();
		} 
	}
	
	
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Livro livro){
 
		LivroEntity entity = new LivroEntity();
 
		try {
 
			entity.setTitulo(livro.getTitulo());
			entity.setSubtitulo(livro.getSubtitulo());
			entity.setAutor(livro.getAutor());
			entity.setIsbn(livro.getIsbn());
			entity.setGenero(livro.getGenero());
 
			livro_repository.Alterar(entity);
 
			return "Livro alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o livro." + e.getMessage();
 
		}
 
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todos")
	public List<Livro> TodosLivros(){
 
		List<Livro> livros =  new ArrayList<Livro>();
 
		List<LivroEntity> listaEntityLivros = livro_repository.TodosLivros();
 
		for (LivroEntity entity : listaEntityLivros) {
 
			livros.add(new Livro(entity.getId(),entity.getTitulo(),entity.getSubtitulo(),
					entity.getAutor(),entity.getIsbn(), entity.getGenero()));
		}
 
		return livros;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getLivro/{id}")
	public Livro GetLivro(@PathParam("id") Integer id){
 
		LivroEntity entity = livro_repository.GetLivro(id);
 
		if(entity != null)
			return new Livro(entity.getId(),entity.getTitulo(),entity.getSubtitulo(),
					entity.getAutor(),entity.getIsbn(), entity.getGenero());
 
		return null;
	}
 

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/delete/{id}")	
	public String Excluir(@PathParam("id") Integer id){
 
		try {
 
			livro_repository.Excluir(id);
 
			return "Livro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o livro. " + e.getMessage();
		} 
	}
}
