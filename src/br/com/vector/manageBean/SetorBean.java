package br.com.vector.manageBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.vector.setor.Setor;
import br.com.vector.setor.SetorRN;

@ManagedBean(name="setorBean")
@ViewScoped
public class SetorBean implements Serializable {


	private static final long serialVersionUID = 7124938999007741117L;
	
	private Setor setor;
	private List<Setor>	lista;
	private FacesMessage msg;
	
	public SetorBean(){
		this.novo();
	}
	
	public String novo() {
		
		this.setor = new Setor();
		return "";
	}


	public String salvar() {

		SetorRN setorRN = new SetorRN();
		boolean salvar = setorRN.salvar(this.setor);
		
		if(salvar)
			msg = new FacesMessage("Setor Salvo", this.setor.getNome());
		else
			msg = new FacesMessage("Setor Atualizado", this.setor.getNome());
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		this.setLista(null);
		this.setor = new Setor();
		getLista();
		return "";
	}

	public String excluir() {
		
		SetorRN setorRN = new SetorRN();
		setorRN.excluir(this.setor);
		msg = new FacesMessage("Poder Excluído", this.setor.getNome());
	    FacesContext.getCurrentInstance().addMessage(null, msg);
		this.setLista(null);
		this.setor = new Setor();
		getLista();
		return "";
	}


	public List<Setor> getLista() {
		
		if (this.lista == null) {
			SetorRN setorRN = new SetorRN();
			this.lista = setorRN.listar();
		}
		return this.lista;
	}

	public void onRowEdit(RowEditEvent event) {
		
		setor = ((Setor) event.getObject());
		salvar();

    }

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public void setLista(List<Setor> lista) {
		this.lista = lista;
	}
	

}
