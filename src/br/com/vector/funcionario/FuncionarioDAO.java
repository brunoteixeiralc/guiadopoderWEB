package br.com.vector.funcionario;

import java.util.List;

public interface FuncionarioDAO {

	public void salvar(Funcionario funcionario);

	public void atualizar(Funcionario funcionario);

	public void excluir(Funcionario funcionario);

	public List<Funcionario> listar();
	
	public Funcionario carregar(Integer funcionario);
}
