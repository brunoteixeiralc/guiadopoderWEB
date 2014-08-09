package br.com.vector.funcionario;

import java.util.List;

import org.hibernate.Session;

public class FuncionarioDAOHibernate implements FuncionarioDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		return this.session.createCriteria(Funcionario.class).list();
	}

	@Override
	public Funcionario carregar(Integer orgao) {
		return (Funcionario) this.session.get(Funcionario.class, orgao);
	}

	@Override
	public void salvar(Funcionario funcionario) {
		this.session.save(funcionario);
		
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		this.session.update(funcionario);
		
	}

	@Override
	public void excluir(Funcionario funcionario) {
		this.session.delete(funcionario);
		
	}
}
