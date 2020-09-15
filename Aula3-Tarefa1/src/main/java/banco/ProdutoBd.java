package banco;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Produto;

public class ProdutoBd implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("configDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void adicionar(Produto produto) {
		
		EntityManager em = getEntityManager();
		
		
		try {	
			//System.out.println(produto.getNome());
		
			em.getTransaction().begin();
			
			em.persist(produto);
		
			em.getTransaction().commit();
			
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.toString());
			System.exit(0);
		}
		em.close();
		emf.close();
	}

	public Produto buscaPeloProduto(String nomeProduto) {
		String jpql = "select u from Produto u where u.nome = :nome";
		EntityManager em = getEntityManager();
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		query.setParameter("nome", nomeProduto);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
