package br.com.vector.cargo;

import java.util.List;

public interface CargoDAO {

	public void salvar(Cargo cargo);

	public void atualizar(Cargo cargo);

	public void excluir(Cargo cargo);

	public List<Cargo> listar();
	
	public Cargo carregar(Integer cargo);
}
