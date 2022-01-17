package br.com.ifms.autenticador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifms.autenticador.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	public Telefone findById(long id);
 

//	@Query(value = "SELECT * FROM Aluno a where a.cidade in (:cidade)", nativeQuery = true)
//	public List<Aluno> listaUsuarioPorCidade(@Param("cidade") String cidade);

	@Query(value = "SELECT * FROM Telefone t, Aluno a where a.id_aluno = t.aluno_id_aluno", nativeQuery = true)
	public List<Telefone> listar();
	
}
