package br.com.vector.orgao;

import java.util.List;

import org.hibernate.Session;

public class OrgaoDAOHibernate implements OrgaoDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Orgao> listar() {
		return this.session.createCriteria(Orgao.class).list();
	}

	@Override
	public void salvar(Orgao orgao) {
		this.session.save(orgao);
		
	}

	@Override
	public void atualizar(Orgao orgao) {
		this.session.update(orgao);
		
	}

	@Override
	public void excluir(Orgao orgao){
		this.session.delete(orgao);
	}

	@Override
	public Orgao carregar(Integer orgao) {
		return (Orgao) this.session.get(Orgao.class, orgao);
	}
}
