package br.com.ifms.autenticador.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifms.autenticador.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	public Endereco findById(long id);
 

//	@Query(value = "SELECT * FROM Aluno a where a.cidade in (:cidade)", nativeQuery = true)
//	public List<Aluno> listaUsuarioPorCidade(@Param("cidade") String cidade);

}
