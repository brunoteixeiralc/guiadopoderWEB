package br.com.vector.manageBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.vector.orgao.Orgao;
import br.com.vector.orgao.OrgaoRN;

@ManagedBean(name="orgaoBean")
@ViewScoped
public class OrgaoBean implements Serializable {


	private static final long serialVersionUID = 7124938999007741117L;
	
	private Orgao orgao;
	private List<Orgao>	lista;
	private FacesMessage msg;
	
	public OrgaoBean(){
		this.novo();
		//this.getLista();
	}
	
	public String novo() {
		
		this.orgao = new Orgao();
		return "";
	}


	public String salvar() {

		OrgaoRN orgaoRN = new OrgaoRN();
		boolean salvar = orgaoRN.salvar(this.orgao);
		
		if(salvar)
			msg = new FacesMessage("Orgão Salvo", this.orgao.getNome());
		else
			msg = new FacesMessage("Orgão Atualizado", this.orgao.getNome());
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		this.lista = null;
		this.orgao = new Orgao();
		getLista();
		return "";
	}

	public String excluir() {

		OrgaoRN orgaoRN = new OrgaoRN();
		orgaoRN.excluir(this.orgao);
		msg = new FacesMessage("Orgão Excluído", this.orgao.getNome());
	    FacesContext.getCurrentInstance().addMessage(null, msg);
		this.lista = null;
		this.orgao = new Orgao();
		getLista();
		return "";
	}


	public List<Orgao> getLista() {
		
		if (this.lista == null) {
			OrgaoRN orgaoRN = new OrgaoRN();
			this.lista = orgaoRN.listar();
		}
		return this.lista;
	}

	public void onRowEdit(RowEditEvent event) {
		
		orgao = ((Orgao) event.getObject());
		salvar();

    }

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public void setLista(List<Orgao> lista) {
		this.lista = lista;
	}
	

}
