package br.com.vector.manageBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.vector.funcionario.Funcionario;
import br.com.vector.funcionario.FuncionarioRN;

@ManagedBean(name="funcionarioBean")
@ViewScoped
public class FuncionarioBean implements Serializable {


	private static final long serialVersionUID = 7124938999007741117L;
	
	private Funcionario funcionario;
	private List<Funcionario> lista;
	private FacesMessage msg;
	
	public FuncionarioBean(){
		this.novo();
	}
	
	public String novo() {
		
		this.funcionario = new Funcionario();
		return "";
	}


	public String salvar() {

		FuncionarioRN funcionarioRN = new FuncionarioRN();
		boolean salvar = funcionarioRN.salvar(this.funcionario);
		
		if(salvar)
			msg = new FacesMessage("Cargo Salvo", this.funcionario.getNome());
		else
			msg = new FacesMessage("Cargo Atualizado", this.funcionario.getNome());
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		this.lista = null;
		this.funcionario = new Funcionario();
		getLista();
		return "";
	}

	public String excluir() {
		
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		funcionarioRN.excluir(this.funcionario);
		msg = new FacesMessage("Funcionário Excluído", this.funcionario.getNome());
	    FacesContext.getCurrentInstance().addMessage(null, msg);
		this.lista = null;
		this.funcionario = new Funcionario();
		getLista();
		return "";
	}


	public List<Funcionario> getLista() {
		
		if (this.lista == null) {
			FuncionarioRN funcionarioRN = new FuncionarioRN();
			this.lista = funcionarioRN.listar();
		}
		return this.lista;
	}

	public void onRowEdit(RowEditEvent event) {
		
		funcionario = ((Funcionario) event.getObject());
		salvar();
    }

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setLista(List<Funcionario> lista) {
		this.lista = lista;
	}
	

}
