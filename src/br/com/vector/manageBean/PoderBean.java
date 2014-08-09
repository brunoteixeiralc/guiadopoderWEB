package br.com.vector.manageBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.vector.poder.Poder;
import br.com.vector.poder.PoderRN;

@ManagedBean(name="poderBean")
@ViewScoped
public class PoderBean implements Serializable {


	private static final long serialVersionUID = -1741420538631285843L;
	
	private Poder poder;
	private List<Poder>	lista;
	private FacesMessage msg;
	
	public PoderBean(){
		this.novo();
		
	}
	
	public String novo() {
		
		this.poder = new Poder();
		return "poder";
	}


	public String salvar() {

		PoderRN poderRN = new PoderRN();
		boolean salvar = poderRN.salvar(this.poder);
		
		if(salvar)
			msg = new FacesMessage("Poder Salvo", this.poder.getNome());
		else
			msg = new FacesMessage("Poder Atualizado", this.poder.getNome());
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.lista = null;
		this.poder = new Poder();
		getLista();
		return "";
	}

	public String excluir() {
		
		PoderRN poderRN = new PoderRN();
		poderRN.excluir(this.poder);
		msg = new FacesMessage("Poder Excluído", this.poder.getNome());
	    FacesContext.getCurrentInstance().addMessage(null, msg);
		this.lista = null;
		this.poder = new Poder();
		getLista();
		return "";
	}


	public List<Poder> getLista() {
		
		if (this.lista == null) {
			PoderRN poderRN = new PoderRN();
			this.lista = poderRN.listar();
		}
		return this.lista;
	}

	public void onRowEdit(RowEditEvent event) {
		
		poder = (Poder) event.getObject();
		salvar();

    }
	
	public Poder getPoder() {
		return this.poder;
	}

	public void setPoder(Poder poder) {
		this.poder = poder;
	}

}
