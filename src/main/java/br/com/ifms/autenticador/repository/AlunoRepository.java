package br.com.ifms.autenticador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifms.autenticador.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public Aluno findById(long id);

	@Query(value = "") /// TERMINAR
	public List<Aluno> findByIdade(long id);

	@Query(value = "SELECT min(idade) FROM Aluno")
	public int min();

	@Query(value = "SELECT max(idade) FROM Aluno")
	public int max();

	@Query(value = "SELECT count(idade) FROM Aluno")
	public long count();

	@Query(value = "SELECT sum(idade) FROM Aluno")
	public long sum();

	@Query(value = "SELECT avg(idade) FROM Aluno")
	public double avg();
//%?1%"
	
	
	@Query(value = "select * from Aluno a where a.nome like :nome%", nativeQuery = true)
	public List<Aluno> buscaNomeInicio(String nome);

	@Query(value = "select * from Aluno a where a.nome like %:nome", nativeQuery = true)
	public List<Aluno> buscaNomeFinal(String nome);
	
	@Query(value = "select * from Aluno a where a.nome like %:nome%", nativeQuery = true)
	public List<Aluno> buscaNome(String nome);
	
	
	
	@Query(value = "SELECT * FROM Aluno a limit 10", nativeQuery = true)
	public List<Aluno> top3();

	@Query(value = "SELECT * FROM aluno WHERE aluno.idade = (SELECT max(idade) from aluno)", nativeQuery = true)
	public Aluno clienteMax();

	@Query(value = "SELECT * FROM Aluno a where a.cidade in (:cidade)", nativeQuery = true)
	public List<Aluno> listaUsuarioPorCidade(@Param("cidade") String cidade);

}
