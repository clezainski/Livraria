package com.projeto.livraria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.livraria.repository.entity.BibliotecarioEntity;
import com.projeto.livraria.repository.entity.UsuarioEntity;

public class BibliotecarioRepository {
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;

	public BibliotecarioRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_softeca");		 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Save(BibliotecarioEntity bibliotecarioEntity){
		 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(bibliotecarioEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void Change(UsuarioEntity usuarioEntity){
		 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuarioEntity);
		this.entityManager.getTransaction().commit();
	}
 
	@SuppressWarnings("unchecked")
	public List<BibliotecarioEntity> allBiblios(){
 
		return this.entityManager.createQuery("SELECT b FROM BibliotecarioEntity b ORDER BY b.nome").getResultList();
	}
 
	public BibliotecarioEntity GetBiblio(Integer id){
 
		return this.entityManager.find(BibliotecarioEntity.class, id);
	}
 
	public void Excluir(Integer id){
 
		BibliotecarioEntity biblio = this.GetBiblio(id);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(biblio);
		this.entityManager.getTransaction().commit();
 
	}
}
