package br.com.ifms.autenticador.resource;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.autenticador.model.Aluno;
import br.com.ifms.autenticador.repository.AlunoRepository;
import br.com.ifms.autenticador.service.AlunoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
public class AlunoResource {

	@Autowired
	AlunoRepository repository;
	
	 

	@Autowired
	AlunoService service;

	
	@ApiResponses(value = {	
	@ApiResponse(code = 200, message="Operação realizada com sucesso!!!!" ),		
	@ApiResponse(code = 404, message="Não encontrado!!!!" ),
	@ApiResponse(code = 403, message="Não tem permissão para acessar!!!"),
	@ApiResponse(code = 500, message="Gerou uma excessão!!!")
	})
	
	
	@GetMapping("/listarAlunos")
	public List<Aluno> listarAlunos() {
		return repository.findAll();
	}
	

	@GetMapping("/buscaAlunoId/{id}")
	public Aluno buscaAlunoID(@PathVariable(value = "id") long id) {

		return repository.findById(id);

	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Aluno salvo com sucesso!!!!" ),		
			@ApiResponse(code = 404, message="Não encontrado!!!!" ),
			@ApiResponse(code = 403, message="Não tem permissão para acessar!!!"),
			@ApiResponse(code = 500, message="Gerou uma excessão!!!")
			})
	

	
	@PostMapping("/aluno")
	public Aluno salvarAluno(@RequestBody Aluno aluno) {	
		return repository.save(aluno);
	}
	
	@PostMapping("/teste")
	public String teste(@RequestBody String message) {
	 	 
		System.out.println(message);
		return message;
	}
	
	@PostMapping("/teste1")
	public String teste1(@RequestParam String message) {
	 
		System.out.println(message);
		return message;
	}
	
	@PostMapping("/teste2/{message}")
	public String teste2(@PathVariable String message) {
	 
		System.out.println(message);
		return message;
	}
	
	
	
	@PostMapping("/salva")
	@ResponseBody
	public Aluno save(@RequestParam(name = "cpf") String cpf) { 
		Aluno a = new Aluno();
		a.setCpf(cpf);
		return repository.save(a);
		
	}
	

	// ok
	@DeleteMapping("/remover/{id}")
	public void deleteAluno(@PathVariable(value = "id") long id) {

		Aluno aluno = buscaAlunoID(id);

		if (aluno.getIdAluno() > 0) {
			repository.delete(aluno);

		}
	}

	@GetMapping(value = "/gets/{id}")
	public String test(@PathVariable(value = "id") String id) {
		
		Aluno aluno = new Aluno();
		aluno.setNome(id);
		repository.save(aluno);
		
		return id + ">>>>OK";
	}
	
	@GetMapping(value = "/aluno/min")
	public int min() {
		return repository.min();
	}

	@GetMapping(value = "/aluno/max")
	public int max() {
		return repository.max();
	}

	@GetMapping(value = "/aluno/sum")
	public long sum() {
		return repository.sum();
	}

	@GetMapping(value = "/aluno/count")
	public long count() {
		return repository.count();
	}

	// OK
	@GetMapping(value = "/aluno/avg")
	public double avg() {

		DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
		return Double.parseDouble(df.format(repository.avg()));

	}

	@GetMapping(value = "/aluno/maximo")
	public Aluno maximo() {
		return repository.clienteMax();
	}

	@GetMapping(value = "/aluno/top3")
	public List<Aluno> top3() {
		return repository.top3();
	}

	@GetMapping(value = "/aluno/buscanomeinicio/{nome}")
	public List<Aluno> buscaInicio(@PathVariable(value = "nome") String nome) {
		return repository.buscaNomeInicio(nome);
	}
	
	@GetMapping(value = "/aluno/buscanome/{nome}")
	public List<Aluno> buscaNome(@PathVariable(value = "nome") String nome) {
		return repository.buscaNome(nome);
	}
	
	
	@GetMapping(value = "/aluno/buscanomefinal/{nome}")
	public List<Aluno> buscaFinal(@PathVariable(value = "nome") String nome) {
		return repository.buscaNomeFinal(nome);
	}
	

	@PutMapping("/atualizar/{id}")
	public Aluno atualizarAluno(@PathVariable(value = "id") long id, @RequestBody Aluno aluno) {

		Aluno alunoNew = buscaAlunoID(id);

		aluno.setIdade(service.calcularIdade(aluno.getNascimento()));
		System.out.println(aluno.getIdade());

		if (alunoNew.getIdAluno() == aluno.getIdAluno()) {

			return repository.save(aluno);

		}

		return null;
	}

}
