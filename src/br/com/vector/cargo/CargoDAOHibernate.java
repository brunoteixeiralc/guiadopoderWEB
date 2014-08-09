package br.com.vector.cargo;

import java.util.List;

import org.hibernate.Session;

public class CargoDAOHibernate implements CargoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> listar() {
		return this.session.createCriteria(Cargo.class).list();
	}

	@Override
	public Cargo carregar(Integer cargo) {
		return (Cargo) this.session.get(Cargo.class, cargo);
	}

	@Override
	public void salvar(Cargo cargo) {
		this.session.save(cargo);
		
	}

	@Override
	public void atualizar(Cargo cargo) {
		this.session.update(cargo);
		
	}

	@Override
	public void excluir(Cargo cargo) {
		this.session.delete(cargo);
		
	}
}
