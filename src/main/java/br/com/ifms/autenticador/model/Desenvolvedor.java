package br.com.ifms.autenticador.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class Desenvolvedor {
	
	//SWAGGER
	@ApiModelProperty(value="Código do Desenvolvedor")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDev;
	
	@ApiModelProperty(value="Nome do Desenvolvedor")
	private String nomeDev;

	
	
	public long getIdDev() {
		return idDev;
	}

	public void setIdDev(long idDev) {
		this.idDev = idDev;
	}

	public String getNomeDev() {
		return nomeDev;
	}

	public void setNomeDev(String nomeDev) {
		this.nomeDev = nomeDev;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Empresas getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
	}

	public Senioridade getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(Senioridade senioridade) {
		this.senioridade = senioridade;
	}

	@OneToOne
	private Endereco endereco;

   
	@ManyToOne
	private Empresas empresas;
	
	//ENUM
	@Enumerated(EnumType.STRING)
	private Senioridade senioridade;

	public int getIdDesenvolvedor() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
