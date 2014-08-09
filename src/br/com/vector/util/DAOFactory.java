
package br.com.vector.util;

import org.hibernate.Session;

import br.com.vector.cargo.CargoDAO;
import br.com.vector.cargo.CargoDAOHibernate;
import br.com.vector.funcionario.FuncionarioDAO;
import br.com.vector.funcionario.FuncionarioDAOHibernate;
import br.com.vector.orgao.OrgaoDAO;
import br.com.vector.orgao.OrgaoDAOHibernate;
import br.com.vector.poder.PoderDAO;
import br.com.vector.poder.PoderDAOHibernate;
import br.com.vector.setor.SetorDAO;
import br.com.vector.setor.SetorDAOHibernate;

public class DAOFactory {
	
	public static PoderDAO criarPoderDAO() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()){
			session = HibernateUtil.getSessionFactory().openSession();
		}
		
		PoderDAOHibernate poderDAO = new PoderDAOHibernate();
		poderDAO.setSession(session);
		return poderDAO;
	}

	public static SetorDAO criarSetorDAO() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()){
			session = HibernateUtil.getSessionFactory().openSession();
		}
		
		SetorDAOHibernate setorDAO = new SetorDAOHibernate();
		setorDAO.setSession(session);
		return setorDAO;
	}
	
	public static OrgaoDAO criarOrgaoDAO() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()){
			session = HibernateUtil.getSessionFactory().openSession();
		}
		OrgaoDAOHibernate orgaoDAO = new OrgaoDAOHibernate();
		orgaoDAO.setSession(session);
		return orgaoDAO;
	}
	
	public static CargoDAO criarCargoDAO() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()){
			session = HibernateUtil.getSessionFactory().openSession();
		}
		
		CargoDAOHibernate cargoDAO = new CargoDAOHibernate();
		cargoDAO.setSession(session);
		return cargoDAO;
	}
	
	public static FuncionarioDAO criarFuncionarioDAO() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()){
			session = HibernateUtil.getSessionFactory().openSession();
		}
		
		FuncionarioDAOHibernate funcionarioDAO = new FuncionarioDAOHibernate();
		funcionarioDAO.setSession(session);
		return funcionarioDAO;
	}
}