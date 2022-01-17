package br.com.ifms.autenticador.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.autenticador.model.Endereco;

import br.com.ifms.autenticador.repository.EnderecoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoResource {

	@Autowired
	EnderecoRepository repository;

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Operação realizada com sucesso!!!!"),
			@ApiResponse(code = 404, message = "Não encontrado!!!!"),
			@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
			@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
	
	@GetMapping("/listar")
	public List<Endereco> listarEndereco() {

		return repository.findAll();
	}

	@GetMapping("/buscaPorId/{id}")
	public Endereco buscaEnderecoID(@PathVariable(value = "id") long id) {

		return repository.findById(id);

	}

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Aluno salvo com sucesso!!!!"),
			@ApiResponse(code = 404, message = "Não encontrado!!!!"),
			@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
			@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
	
	// Certo
	@PostMapping( value ="/salvar")
	public Endereco salvarEndereco(@RequestBody Endereco endereco) {

		return repository.save(endereco);
	}

	
	@DeleteMapping("/remover/{id}")
	public void deleteEndereco(@PathVariable(value = "id") long id) {

		Endereco endereco = buscaEnderecoID(id);

		if (endereco.getIdEndereco() > 0) {
			repository.delete(endereco);

		}
	}

	@PutMapping("/atualizar/{id}")
	public Endereco atualizarEndereco(@PathVariable(value = "id") long id, @RequestBody Endereco endereco) {

		Endereco enderecoNew = buscaEnderecoID(id);

		if (enderecoNew.getIdEndereco() == endereco.getIdEndereco()) {

			return repository.save(endereco);

		}

		return null;
	}

}
