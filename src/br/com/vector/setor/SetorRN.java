package br.com.vector.setor;

import java.util.List;

import br.com.vector.util.DAOFactory;

public class SetorRN {

	private SetorDAO setorDAO;
	private boolean salvar;
	
	public SetorRN() {
		this.setorDAO = DAOFactory.criarSetorDAO();
	}


	public boolean salvar(Setor setor) {

		Integer codigo = setor.getId();
		if (codigo == null || codigo == 0) {
			
			this.salvar = true;
			this.setorDAO.salvar(setor);


		} else {
			
			this.salvar = false;
			this.setorDAO.atualizar(setor);
		}
		
		return this.salvar;
	}

	public void excluir(Setor poder) {
		
		this.setorDAO.excluir(poder);
	}

	public List<Setor> listar() {
		return this.setorDAO.listar();
	}
	
	public Setor carregar(Integer setor) {
		return this.setorDAO.carregar(setor);
	}


}