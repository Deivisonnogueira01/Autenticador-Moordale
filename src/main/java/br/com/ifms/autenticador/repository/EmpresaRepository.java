package br.com.ifms.autenticador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifms.autenticador.model.Empresas;

public interface EmpresaRepository extends JpaRepository<Empresas, Long>{


		public Empresas findById(long id);
	 

//		@Query(value = "SELECT * FROM Aluno a where a.cidade in (:cidade)", nativeQuery = true)
//		public List<Aluno> listaUsuarioPorCidade(@Param("cidade") String cidade);

		@Query(value = "SELECT * FROM Empresas e, Desenvolvedor a where a.id_dev = t.desenvolvedor_id_dev", nativeQuery = true)
		public List<Empresas> listar();
	
	
	
	
	
	
	
}
