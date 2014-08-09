package br.com.vector.setor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.vector.orgao.Orgao;
import br.com.vector.poder.Poder;

@Entity
@Table(name="setor")
public class Setor implements Serializable {


	private static final long serialVersionUID = -2436822495819695988L;

	@Id @GeneratedValue
	private int id;
	
	private String nome;
	
	@JsonIgnore
	@ManyToOne
	private Poder poder;
	
	@OneToMany(mappedBy="setor", cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<Orgao> orgaos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Poder getPoder() {
		return poder;
	}

	public void setPoder(Poder poder) {
		this.poder = poder;
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((poder == null) ? 0 : poder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (poder == null) {
			if (other.poder != null)
				return false;
		} else if (!poder.equals(other.poder))
			return false;
		return true;
	}

	

}
