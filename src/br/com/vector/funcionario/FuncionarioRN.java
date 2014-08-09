package br.com.vector.funcionario;

import java.util.List;

import br.com.vector.util.DAOFactory;

public class FuncionarioRN {

	private FuncionarioDAO funcionarioDAO;
	private boolean salvar;
	
	public FuncionarioRN() {
		this.funcionarioDAO = DAOFactory.criarFuncionarioDAO();
	}


	public boolean salvar(Funcionario funcionario) {

		Integer codigo = funcionario.getId();
		if (codigo == null || codigo == 0) {
			
			this.salvar = true;
			this.funcionarioDAO.salvar(funcionario);


		} else {
			
			this.salvar = false;
			this.funcionarioDAO.atualizar(funcionario);
		}
		
		return salvar;
	}

	public void excluir(Funcionario funcionario) {
		
		this.funcionarioDAO.excluir(funcionario);
	}

	public List<Funcionario> listar() {
		return this.funcionarioDAO.listar();
	}
	
	public Funcionario carregar(Integer funcionario) {
		return this.funcionarioDAO.carregar(funcionario);
	}


}