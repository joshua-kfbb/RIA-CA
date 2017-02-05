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
}
