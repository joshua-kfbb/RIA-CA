package laptoplist;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/laptops")
@Stateless
@LocalBean
public class LaptopWS {
	@EJB
	private LaptopDAO ldao;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response findAll(){
		System.out.println("get all laptops");
		List<Laptop> laptops=ldao.getAllLaptops();
		return Response.status(200).entity(laptops).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response findLaptopById(@PathParam("id") int id){
		Laptop l=ldao.getLaptop(id);
		return Response.ok(l).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response addLaptop(Laptop l){
		ldao.add(l);
		return Response.status(201).entity(l).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public Response updateLaptop(Laptop l){
		ldao.update(l);
		return Response.ok(l).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response joiewjr398(@PathParam("id") int id){
		ldao.delete(id);
		return Response.status(204).build();
	}
	
	/**
	 * Search Laptops by manufacturer
	 * 
	 */
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/search/bymanufacturer/{m}")
	public Response getLaptopByManufacture(@PathParam("m") String m)
	{
		List<Laptop> laptops=ldao.getLaptopByManufacturer(m);
		return Response.ok(laptops).build();
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/search/byscreensize/min/{min}/max/{max}")
	public Response getLaptopByScreenSizeRange(@PathParam("min") String strMin,@PathParam("max") String strMax){
		BigDecimal min=new BigDecimal(strMin);
		BigDecimal max=new BigDecimal(strMax);
		List<Laptop> laptops=ldao.getLaptopByScreenSizeRange(min, max);
		return Response.ok(laptops).build();
	}
	
}
