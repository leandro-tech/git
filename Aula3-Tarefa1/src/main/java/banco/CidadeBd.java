package banco;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Cidade;

public class CidadeBd implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("configDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void adicionar(Cidade cidade) {
		
		EntityManager em = getEntityManager();
		
		
		try {	
					
			em.getTransaction().begin();
			
			em.persist(cidade);
		
			em.getTransaction().commit();
			
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.toString());
			System.exit(0);
		}
		em.close();
		emf.close();
	}

	public Cidade buscaPelaCidade(String nomeCidade) {
		String jpql = "select u from Cidade u where u.nome = :nome";
		EntityManager em = getEntityManager();
		TypedQuery<Cidade> query = em.createQuery(jpql, Cidade.class);
		query.setParameter("nome", nomeCidade);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
}
