package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "razaosocial", nullable = false)
	private String razao;
	private String logradouro;
	private String contato;
	private Integer numFuncionarios;
	private String site;
	private String email;
	private String cep;
	private String telefone;
	private String fax;
	@ManyToOne
	@JoinColumn(name = "id_uf")
	private Uf uf;
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	@JoinColumn(name = "id_bairro")
	@ManyToOne
	private Bairro bairro;
	@ManyToOne
	@JoinColumn(name = "id_ramo")
	private Ramo ramo;
	@ManyToMany
	@JoinTable(name = "tb_empresa_produto",
	        joinColumns=
	            @JoinColumn(name="id_empresa", referencedColumnName="ID"),
	        inverseJoinColumns=
	            @JoinColumn(name="id_produto", referencedColumnName="ID"))
	private List<Produto> produtos =  new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addProduto(Produto produto) { 
		if (this.produtos.contains(produto)) { 
			return;
		}
		this.produtos.add(produto);
		produto.addEmpresa(this);
	}

	public void setProdutos(List<Produto> produtos) {
		for (Produto produto : produtos) {
			this.addProduto(produto);
		}
	}

	public Ramo getRamo() {
		return ramo;
	}

	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getLogadouro() {
		return logradouro;
	}

	public void setLogadouro(String logadouro) {
		this.logradouro = logadouro;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getSite() {
		return site;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
