package br.com.vector.orgao;

import java.util.List;

import br.com.vector.util.DAOFactory;

public class OrgaoRN {

	private OrgaoDAO orgaoDAO;
	private boolean salvar;

	public OrgaoRN() {
		this.orgaoDAO = DAOFactory.criarOrgaoDAO();
	}


	public boolean salvar(Orgao orgao) {

		Integer codigo = orgao.getId();
		if (codigo == null || codigo == 0) {
			
			this.salvar = true;
			this.orgaoDAO.salvar(orgao);


		} else {
			
			this.salvar = false;
			this.orgaoDAO.atualizar(orgao);
		}
		
		return this.salvar;
	}

	public void excluir(Orgao orgao){
		this.orgaoDAO.excluir(orgao);

	}

	public List<Orgao> listar() {
		return this.orgaoDAO.listar();
	}
	
	public Orgao carregar(Integer orgao) {
		return this.orgaoDAO.carregar(orgao);
	}


}