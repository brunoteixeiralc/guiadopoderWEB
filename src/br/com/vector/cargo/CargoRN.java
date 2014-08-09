package br.com.vector.cargo;

import java.util.List;

import br.com.vector.util.DAOFactory;

public class CargoRN {

	private CargoDAO cargoDAO;
	private boolean salvar;
	
	public CargoRN() {
		this.cargoDAO = DAOFactory.criarCargoDAO();
	}


	public boolean salvar(Cargo cargo) {

		Integer codigo = cargo.getId();
		if (codigo == null || codigo == 0) {
			
			this.salvar = true;
			this.cargoDAO.salvar(cargo);


		} else {
			
			this.salvar = false;
			this.cargoDAO.atualizar(cargo);
		}
		
		return this.salvar;
	}

	public void excluir(Cargo cargo) {
		
		this.cargoDAO.excluir(cargo);
	}

	public List<Cargo> listar() {
		return this.cargoDAO.listar();
	}
	
	public Cargo carregar(Integer cargo) {
		return this.cargoDAO.carregar(cargo);
	}


}