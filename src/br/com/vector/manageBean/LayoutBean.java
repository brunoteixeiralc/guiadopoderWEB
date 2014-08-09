package br.com.vector.manageBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LayoutBean implements Serializable{
	
	static final long serialVersionUID = -8780407253943723401L;
	private String page = "poder";
	
	@PostConstruct
	public void init(){

	}
	
	public void doViewPoder() {
	    this.page = "poder";
	}
	
	public void doViewOrgao() {
	    this.page = "orgao";
	}
	
	public void doViewCargo() {
	    this.page = "cargo";
	}
	
	public void doViewSetor() {
	    this.page = "setor";
	}
	
	public void doViewFuncionario() {
	    this.page = "funcionario";
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
