package br.com.vector.orgao;

import java.util.List;

public interface OrgaoDAO {

	public void salvar(Orgao orgao);

	public void atualizar(Orgao orgao);

	public void excluir(Orgao orgao);

	public List<Orgao> listar();
	
	public Orgao carregar(Integer orgao);
}
