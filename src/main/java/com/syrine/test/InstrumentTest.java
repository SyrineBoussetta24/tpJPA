package com.syrine.test;

import com.syrine.dao.InstrumentDao;
import com.syrine.entities.Instrument;

public class InstrumentTest {
	public static void main(String[] args) {
//créer un objet client
		Instrument i = new Instrument();
		i.setNom("violon");
		i.setCouleur("noir");
//ajouter l'objet client à la BD
		InstrumentDao cltDao = new InstrumentDao();
		cltDao.ajouter(i);
		System.out.println("Appel de la méthode listerTous");
		for (Instrument it : cltDao.listerTous())
			System.out.println(it.getCode() + " " + it.getNom());
		System.out.println("Appel de la méthode listerParNom");
		for (Instrument it : cltDao.listerParNom("vio"))

			System.out.println(it.getCode() + " " + it.getNom());

//tester les autres méthodes de la classe InstrumentDao
		// Modifier le nom de l'instrument 
        i.setNom("violon2");

        cltDao.modifier(i);

        System.out.println("Instruments après modification :");
        for (Instrument it : cltDao.listerTous()) {
            System.out.println(it.getCode() + " " + it.getNom());
        }
     // Supprimer l'instrument ajouté 
        cltDao.supprimer(i);

        // Afficher les instruments après suppression
        System.out.println("instruments après suppression :");
        for (Instrument it : cltDao.listerTous()) {
            System.out.println(it.getCode() + " " + it.getNom());
        }
        
	}
}