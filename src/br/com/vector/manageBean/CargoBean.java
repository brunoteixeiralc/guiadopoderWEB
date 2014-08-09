package br.com.vector.manageBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.vector.cargo.Cargo;
import br.com.vector.cargo.CargoRN;

@ManagedBean(name="cargoBean")
@ViewScoped
public class CargoBean implements Serializable {


	private static final long serialVersionUID = 7124938999007741117L;
	
	private Cargo cargo;
	private List<Cargo>	lista;
	private FacesMessage msg;
	
	public CargoBean(){
		this.novo();
	}
	
	public String novo() {
		
		this.cargo = new Cargo();
		return "";
	}


	public String salvar() {

		CargoRN cargoRN = new CargoRN();
		boolean salvar = cargoRN.salvar(this.cargo);
		
		if(salvar)
			msg = new FacesMessage("Cargo Salvo", this.cargo.getNome());
		else
			msg = new FacesMessage("Cargo Atualizado", this.cargo.getNome());
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		this.lista = null;
		this.cargo = new Cargo();
		getLista();
		return "";
	}

	public String excluir() {
		
		CargoRN cargoRN = new CargoRN();
		cargoRN.excluir(this.cargo);
		msg = new FacesMessage("Cargo Excluído", this.cargo.getNome());
	    FacesContext.getCurrentInstance().addMessage(null, msg);
		this.lista = null;
		this.cargo = new Cargo();
		getLista();
		return "";
	}


	public List<Cargo> getLista() {
		
		if (this.lista == null) {
			CargoRN cargoRN = new CargoRN();
			this.lista = cargoRN.listar();
		}
		return this.lista;
	}

	public void onRowEdit(RowEditEvent event) {
		
		cargo = ((Cargo) event.getObject());
		salvar();
    }

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setLista(List<Cargo> lista) {
		this.lista = lista;
	}
	

}
