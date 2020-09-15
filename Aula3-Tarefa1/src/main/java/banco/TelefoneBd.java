package banco;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Telefone;

public class TelefoneBd implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("configDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void adicionar(Telefone telefone) {
		
		EntityManager em = getEntityManager();
		
		
		try {	
					
			em.getTransaction().begin();
			
			em.persist(telefone);
		
			em.getTransaction().commit();
			
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.toString());
			System.exit(0);
		}
		em.close();
		emf.close();
	}
	
}
