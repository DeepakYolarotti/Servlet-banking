package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class CustomerDao 
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction trancation=manager.getTransaction();
	
	public List<Customer> check(String email)
	{
		return manager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
	}
	public List<Customer> check(long mobile)
	{
		return manager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mobile).getResultList();
	}
	public void save(Customer customer)
	{
		trancation.begin();
		manager.persist(customer);
		trancation.commit();
	}
	public Customer login(int custid)
	{
		return manager.find(Customer.class,custid);
	}

	public void update(Customer customer)
	{
		trancation.begin();
		manager.merge(customer);
		trancation.commit();
	}
}
