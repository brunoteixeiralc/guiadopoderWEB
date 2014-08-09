package br.com.vector.poder;

import java.util.List;

public interface PoderDAO {

	public void salvar(Poder poder);

	public void atualizar(Poder poder);

	public void excluir(Poder poder);

	public List<Poder> listar();
	
	public Poder carregar(Integer poder);
}
