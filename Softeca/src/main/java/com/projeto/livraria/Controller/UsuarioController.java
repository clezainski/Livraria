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

import com.projeto.livraria.http.Usuario;
import com.projeto.livraria.repository.UsuarioRepository;
import com.projeto.livraria.repository.entity.UsuarioEntity;

@Path("servicos/user")
public class UsuarioController {

	private final  UsuarioRepository user_repository = new UsuarioRepository();
	 
	
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/add")
	public String Cadastrar(Usuario usuario){
 
		UsuarioEntity entity = new UsuarioEntity();
 
		try {
 
			entity.setNome(usuario.getNome());
			entity.setSobrenome(usuario.getSobrenome());
			entity.setCpf(usuario.getCpf());
			entity.setData_nascimento(usuario.getData_nascimento());
 
			user_repository.Salvar(entity);
 
			return "Usuário cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar usuário." + e.getMessage();
		} 
	}
 

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Usuario usuario){
 
		UsuarioEntity entity = new UsuarioEntity();
 
		try {
 
			entity.setId(usuario.getId());
			entity.setNome(usuario.getNome());
			entity.setSobrenome(usuario.getSobrenome());
			entity.setCpf(usuario.getCpf());
			entity.setData_nascimento(usuario.getData_nascimento());
 
			user_repository.Alterar(entity);
 
			return "Usuario alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o usuario." + e.getMessage(); 
		} 
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todos")
	public List<Usuario> TodosUsuarios(){
 
		List<Usuario> usuarios =  new ArrayList<Usuario>();
 
		List<UsuarioEntity> listaEntityUsuarios = user_repository.TodosUsuarios();
 
		for (UsuarioEntity entity : listaEntityUsuarios) {
 
			usuarios.add(new Usuario(entity.getId(),entity.getNome(),entity.getSobrenome(),entity.getCpf(),entity.getData_nascimento()));
		}
 
		return usuarios;
	}
 
	/**
	 * Esse método busca uma pessoa cadastrada pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getUsuario/{id}")
	public Usuario GetUsuario(@PathParam("id") Integer id){
 
		UsuarioEntity entity = user_repository.GetUsuario(id);
 
		if(entity != null)
			return new Usuario (entity.getId(),entity.getNome(),entity.getSobrenome(),entity.getCpf(),entity.getData_nascimento());
 
		return null;
	}
 

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/delete/{id}")	
	public String Excluir(@PathParam("id") Integer id){
 
		try {
 
			user_repository.Excluir(id);
 
			return "Usuário excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o usuário. " + e.getMessage();
		} 
	}
}
