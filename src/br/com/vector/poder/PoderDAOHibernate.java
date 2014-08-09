package br.com.vector.poder;

import java.util.List;

import org.hibernate.Session;



public class PoderDAOHibernate implements PoderDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Poder> listar() {
		return this.session.createCriteria(Poder.class).list();
	}

	@Override
	public void salvar(Poder poder) {
		this.session.save(poder);
		
	}

	@Override
	public void atualizar(Poder poder) {
		this.session.update(poder);
		
	}

	@Override
	public void excluir(Poder poder) {
		this.session.delete(poder);
		
	}

	@Override
	public Poder carregar(Integer poder) {
		return (Poder) this.session.get(Poder.class, poder);
	}
}
