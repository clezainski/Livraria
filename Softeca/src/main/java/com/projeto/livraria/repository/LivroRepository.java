package com.projeto.livraria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.livraria.repository.entity.LivroEntity;


public class LivroRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
	
	public LivroRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_softeca");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(LivroEntity livroEntity){
		 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(livroEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(LivroEntity livroEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(livroEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * RETORNA TODAS AS UsuarioS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<LivroEntity> TodosLivros(){
 
		return this.entityManager.createQuery("SELECT l FROM LivroEntity l ORDER BY l.titulo").getResultList();
	}
 
	/**
	 * CONSULTA UM LIVRO PELO CÓDIGO
	 * */
	public LivroEntity GetLivro(Integer id){
 
		return this.entityManager.find(LivroEntity.class, id);
	}
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer id){
 
		LivroEntity livro = this.GetLivro(id);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(livro);
		this.entityManager.getTransaction().commit();
 
	}

}
