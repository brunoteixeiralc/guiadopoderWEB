package br.com.vector.setor;

import java.util.List;

public interface SetorDAO {

	public void salvar(Setor setor);

	public void atualizar(Setor setor);

	public void excluir(Setor setor);

	public List<Setor> listar();
	
	public Setor carregar(Integer setor);
}
