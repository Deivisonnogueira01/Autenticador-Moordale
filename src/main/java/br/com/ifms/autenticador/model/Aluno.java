package br.com.ifms.autenticador.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="Código do aluno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAluno;
	
	@ApiModelProperty(value="Nome do aluno")
	private String nome;
	
	@ApiModelProperty(value="Data de nascimento do aluno")
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	@ApiModelProperty(notes = "Mail server domain", required = true)
	private String cpf;
	@ApiModelProperty(value="idade do aluno")
	private int idade;	 


	public long getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}


	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}


	@OneToOne 
	private Endereco endereco;
	
	
	
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadocivil;
	
	 
	@Enumerated(EnumType.STRING)
	private Sexo sexo; 
	
	
	 @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
    private List<Telefone> telefones ;
 

}
