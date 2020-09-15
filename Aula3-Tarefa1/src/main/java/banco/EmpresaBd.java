package banco;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Empresa;

public class EmpresaBd implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		private static EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("configDB");
		
		public static EntityManager getEntityManager() {
			return emf.createEntityManager();
		}
		
		public void adicionar(Empresa empresa) {
			
			EntityManager em = getEntityManager();
			
			
			try {	
				//System.out.println(empresa.getRazao());
			
				em.getTransaction().begin();
				
				em.persist(empresa);
			
				em.getTransaction().commit();
				
			} catch(Exception ex) {
				em.getTransaction().rollback();
				System.out.println(ex.toString());
				System.exit(0);
			}
		}

}
