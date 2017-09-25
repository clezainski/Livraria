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

import com.projeto.livraria.http.Bibliotecario;
import com.projeto.livraria.repository.BibliotecarioRepository;
import com.projeto.livraria.repository.entity.BibliotecarioEntity;

@Path("/servicos/biblio")
public class BibliotecarioController {
	
	private final BibliotecarioRepository biblio_repository = new BibliotecarioRepository();

	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/add")
	public String Cadastrar(Bibliotecario biblio){
		 
		BibliotecarioEntity entity = new BibliotecarioEntity();
 
		try { 
			entity.setNome(biblio.getNome());
			entity.setSobrenome(biblio.getSobrenome());
			entity.setCpf(biblio.getCpf());
			entity.setData_nascimento(biblio.getData_nascimento());
			entity.setMatricula(biblio.getMatricula());
			entity.setSenha(biblio.getSenha());
 
			biblio_repository.Salvar(entity);
 
			return "Bibliotecario cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar bibliotecario." + e.getMessage();
		} 
	}
	
	
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Bibliotecario biblio){
 
		BibliotecarioEntity entity = new BibliotecarioEntity();
 
		try {
 
			entity.setId(biblio.getId());
			entity.setNome(biblio.getNome());
			entity.setSobrenome(biblio.getSobrenome());
			entity.setCpf(biblio.getCpf());
			entity.setData_nascimento(biblio.getData_nascimento());
			entity.setMatricula(biblio.getMatricula());
			entity.setSenha(biblio.getSenha());
 
			biblio_repository.Alterar(entity);
 
			return "Bibliotecario alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o bibliotecario." + e.getMessage();
 
		}
 
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todos")
	public List<Bibliotecario> TodosBiblios(){
 
		List<Bibliotecario> biblios =  new ArrayList<Bibliotecario>();
 
		List<BibliotecarioEntity> listaEntityBiblios = biblio_repository.allBiblios();
 
		for (BibliotecarioEntity entity : listaEntityBiblios) {
 
			biblios.add(new Bibliotecario(entity.getId(),entity.getNome(),entity.getSobrenome(),
					entity.getCpf(),entity.getData_nascimento(), entity.getMatricula(), entity.getSenha()));
		}
 
		return biblios;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getBiblio/{id}")
	public Bibliotecario GetBiblio(@PathParam("id") Integer id){
 
		BibliotecarioEntity entity = biblio_repository.GetBibliotecario(id);
 
		if(entity != null)
			return new Bibliotecario(entity.getId(),entity.getNome(),entity.getSobrenome(),
					entity.getCpf(),entity.getData_nascimento(), entity.getMatricula(), entity.getSenha());
 
		return null;
	}
 

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/delete/{id}")	
	public String Excluir(@PathParam("id") Integer id){
 
		try {
 
			biblio_repository.Excluir(id);
 
			return "Bibliotecário excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o bibliotecário. " + e.getMessage();
		} 
	}
}
