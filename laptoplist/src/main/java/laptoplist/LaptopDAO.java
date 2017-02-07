package laptoplist;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LaptopDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Laptop> getAllLaptops(){
		Query query=em.createQuery("SELECT l FROM Laptop l");
		return query.getResultList();
	}
	
	public Laptop getLaptop(int id){
		return em.find(Laptop.class, id);
	}
	
	public void add(Laptop l){
		em.persist(l);
	}
	
	public void update(Laptop l){
		em.merge(l);
	}
	
	public void delete(int id){
		em.remove(getLaptop(id));
	}
	
	public List<Laptop> getLaptopByManufacturer(String manufacturer){
		String qStr="select l from Laptop l where l.manufacturer like :m";
		Query query=em.createQuery(qStr).setParameter("m", manufacturer);
		return query.getResultList();
	}
	public List<Laptop> getLaptopByMinMem(short mem){
		String qStr="select l from Laptop l where l.mainMem > :m";
		Query query=em.createQuery(qStr).setParameter("m", mem);
		return query.getResultList();
	}
}
