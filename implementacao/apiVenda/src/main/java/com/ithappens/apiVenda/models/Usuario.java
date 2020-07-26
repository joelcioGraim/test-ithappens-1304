package com.ithappens.apiVenda.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Joelcio Graim (Analista de Sistemas e Desenvolvedor)
 * @version 1.0 (Data - 25/07/2020)
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idusuario")
	private long idUsuario;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	/* ============= Relacionamentos =============== */

	@OneToMany(mappedBy = "usuario")
	private Set<PedidoEstoque> pedidosEstoque;
	
	/* ============= Get / Set =============== */

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<PedidoEstoque> getPedidosEstoque() {
		return pedidosEstoque;
	}

	public void setPedidosEstoque(Set<PedidoEstoque> pedidosEstoque) {
		this.pedidosEstoque = pedidosEstoque;
	}

}
