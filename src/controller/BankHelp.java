package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Bank;

/**
 * @author ajlj - Austin Mays ajmays@dmacc.edu
 * CIS175 - Spring 2023
 * Jan 31, 2023
 */
public class BankHelp {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BankAccount");
		public void input(Bank bk) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(bk);
			em.getTransaction().commit();
			em.close();
		}
		@SuppressWarnings("unchecked")
		public List<Bank> showAllItems(){
			EntityManager em = emfactory.createEntityManager();
			List<Bank> all = em.createQuery("SELECT b FROM Bank b").getResultList();
			return all;
			}
		public Bank searchForAccountByNum(int edit) {
			return null;
			
		}
		public void updateAccount(Bank edit) {
			
		}
		public void deleteAccount(Bank delete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Bank> typedQuery = em.createQuery("SELECT bk FROM Bank bk where bk.name = :selectedName and bk.acctNum = :selectedAcctNum", Bank.class);
			typedQuery.setParameter("selectedName", delete.getName());
			typedQuery.setParameter("selectedAcctNum", delete.getAcctNum());
			typedQuery.setMaxResults(1);
			Bank account = typedQuery.getSingleResult();
			em.remove(account);
			em.getTransaction().commit();
			em.close();
		}
		public List<Bank> searchForAccountByName(String name) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Bank> typedQuery = em.createQuery("select b from Bank b where b.name = :selectedName", Bank.class);
			typedQuery.setParameter("selectedName", name);List<Bank> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
}
