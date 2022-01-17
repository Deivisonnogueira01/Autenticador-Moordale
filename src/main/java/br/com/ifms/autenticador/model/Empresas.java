package br.com.ifms.autenticador.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

	@Data
	@Entity
	public class Empresas implements Serializable{
        
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@ApiModelProperty(value="Código da Empresa")
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idEmpresa;
	
		@ApiModelProperty(value="Nome da Empresa")
		private String nomeEmpresa;
		
		
		
		
		public long getIdEmpresa() {
			return idEmpresa;
		}


		public void setIdEmpresa(long idEmpresa) {
			this.idEmpresa = idEmpresa;
		}


		public String getNomeEmpresa() {
			return nomeEmpresa;
		}


		public void setNomeEmpresa(String nomeEmpresa) {
			this.nomeEmpresa = nomeEmpresa;
		}


		public Endereco getEndereco() {
			return endereco;
		}


		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}


		public TipoEmpresa getTipoempresa() {
			return tipoempresa;
		}


		public void setTipoempresa(TipoEmpresa tipoempresa) {
			this.tipoempresa = tipoempresa;
		}


		@OneToOne
		private Endereco endereco;
		
		
		//ENUM
		@Enumerated(EnumType.STRING)
		private TipoEmpresa tipoempresa;
		
		
	//	@ManyToOne
	  //  private Desenvolvedor desenvolvedor;
	
	
	
	
	
	
	
}
