package com.syrine.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.syrine.entities.Instrument;
import com.syrine.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class InstrumentDao {
	private EntityManager entityManager = JPAutil.getEntityManager("InstrumentJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Instrument i) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(i);
		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Instrument i) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(i);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Instrument i) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		i = entityManager.merge(i); // important
		entityManager.remove(i);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Instrument consulter(Instrument i, Object id) {
		return entityManager.find(i.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Instrument> listerTous() {
		List<Instrument> instruments = entityManager.createQuery("select i from Instrument i").getResultList();

		return instruments;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Instrument> listerParNom(String nom) {
		List<Instrument> instruments = entityManager.createQuery("select i from Instrument i where i.nom like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();

		return instruments;
	}
}