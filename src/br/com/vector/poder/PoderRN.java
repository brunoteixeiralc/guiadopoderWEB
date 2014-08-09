package br.com.vector.poder;

import java.util.List;

import br.com.vector.util.DAOFactory;

public class PoderRN {

	private PoderDAO poderDAO;
	private boolean salvar;

	public PoderRN() {
		this.poderDAO = DAOFactory.criarPoderDAO();
	}


	public boolean salvar(Poder poder) {

		Integer codigo = poder.getId();
		if (codigo == null || codigo == 0) {
			this.salvar = true;
			this.poderDAO.salvar(poder);


		} else {
			this.salvar = false;
			this.poderDAO.atualizar(poder);
		}
		
		return this.salvar;
	}

	public void excluir(Poder poder) {
		
		this.poderDAO.excluir(poder);
	}

	public List<Poder> listar() {
		return this.poderDAO.listar();
	}
	
	public Poder carregar(Integer poder) {
		return this.poderDAO.carregar(poder);
	}


}