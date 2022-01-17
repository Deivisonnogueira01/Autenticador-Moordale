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

import br.com.ifms.autenticador.model.Telefone;
import br.com.ifms.autenticador.repository.TelefoneRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/telefone")
public class TelefoneResource {

	@Autowired
	TelefoneRepository repository;

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Operação realizada com sucesso!!!!"),
			@ApiResponse(code = 404, message = "Não encontrado!!!!"),
			@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
			@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
	
	@GetMapping("/listar")
	public List<Telefone> listarTelefones() {

		return repository.listar();
	}

	@GetMapping("/buscaPorId/{id}")
	public Telefone buscaTelefoneID(@PathVariable(value = "id") long id) {

		return repository.findById(id);

	}

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Aluno salvo com sucesso!!!!"),
			@ApiResponse(code = 404, message = "Não encontrado!!!!"),
			@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
			@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
	// ctrl + shift + o    OK
	@PostMapping("/salvar")
	public Telefone salvarTelefone(@RequestBody Telefone telefone) {

		return repository.save(telefone);
	}

	// ok
	@DeleteMapping("/remover/{id}")
	public void deleteTelefone(@PathVariable(value = "id") long id) {

		Telefone telefone = buscaTelefoneID(id);

		if (telefone.getIdTelefone() > 0) {
			repository.delete(telefone);

		}
	}
	//OK
	@PutMapping("/atualizar/{id}")
	public Telefone atualizarTelefone(@PathVariable(value = "id") long id, @RequestBody Telefone telefone) {

		Telefone telefoneNew = buscaTelefoneID(id);

		if (telefoneNew.getIdTelefone() == telefone.getIdTelefone()) {

			return repository.save(telefone);

		}

		return null;
	}

}
