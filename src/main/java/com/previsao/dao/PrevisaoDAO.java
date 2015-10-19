package com.previsao.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.previsao.entity.Previsao;

@Stateless
public class PrevisaoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvarPrevisao(Previsao previsao) {
		em.persist(previsao);
		
	}
	
	public Previsao find(Integer id) {
		return em.find(Previsao.class, id);		
	}
	
	public List<Previsao> findAll() {
		return em.createQuery("SELECT p FROM Previsao p", Previsao.class)
					.getResultList();		
	}

}
