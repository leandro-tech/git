package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_uf")
public class Uf implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sigla;
	private String nome;
	@OneToMany	
	@JoinColumn(name = "id_empresa")
	private List<Empresa> empresa;
	@OneToMany
	@JoinColumn(name = "id_cidade")
	private List<Cidade> cidade;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Empresa> getEmpresa() {
		return empresa;
	}
	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}
	public List<Cidade> getCidade() {
		return cidade;
	}
	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}

	
	

}
