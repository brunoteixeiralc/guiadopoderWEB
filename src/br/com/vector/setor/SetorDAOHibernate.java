package br.com.vector.setor;

import java.util.List;

import org.hibernate.Session;

public class SetorDAOHibernate implements SetorDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Setor> listar() {
		return this.session.createCriteria(Setor.class).list();
	}

	@Override
	public void salvar(Setor setor) {
		this.session.save(setor);
		
	}

	@Override
	public void atualizar(Setor setor) {
		this.session.update(setor);
		
	}

	@Override
	public void excluir(Setor setor) {
		this.session.delete(setor);
		
	}

	@Override
	public Setor carregar(Integer setor) {
		return (Setor) this.session.get(Setor.class, setor);
	}
}
