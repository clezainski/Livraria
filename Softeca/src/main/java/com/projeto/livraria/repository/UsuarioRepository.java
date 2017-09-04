package com.projeto.livraria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.livraria.repository.entity.UsuarioEntity;

public class UsuarioRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
	
	public UsuarioRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_softeca");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(UsuarioEntity usuarioEntity){
		 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(usuarioEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(UsuarioEntity usuarioEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuarioEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * RETORNA TODAS AS UsuarioS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> TodosUsuarios(){
 
		return this.entityManager.createQuery("SELECT u FROM UsuarioEntity u ORDER BY u.nome").getResultList();
	}
 
	/**
	 * CONSULTA UMA Usuario CADASTRA PELO CÓDIGO
	 * */
	public UsuarioEntity GetUsuario(Integer id){
 
		return this.entityManager.find(UsuarioEntity.class, id);
	}
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer id){
 
		UsuarioEntity usuario = this.GetUsuario(id);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(usuario);
		this.entityManager.getTransaction().commit();
 
	}
 

}
