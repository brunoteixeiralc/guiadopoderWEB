package br.com.vector.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vector.poder.Poder;
import br.com.vector.poder.PoderDAO;
import br.com.vector.util.DAOFactory;
import br.com.vector.util.HibernateUtil;

@Path("/poder")
public class PoderesProvider {
	
	private List<Poder> poderes;
	private PoderDAO poderDAO;
	private Transaction x;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Poder> poderes(){
		
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		x = s.getTransaction();
		if(!x.isActive())
			x = s.beginTransaction();

		this.poderDAO = DAOFactory.criarPoderDAO();
		
		poderes = new ArrayList<Poder>();
		poderes = poderDAO.listar();
		
		//x.commit();
		//s.close();
		
		return poderes;
		
	}
}
