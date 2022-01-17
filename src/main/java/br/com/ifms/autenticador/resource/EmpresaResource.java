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

import br.com.ifms.autenticador.model.Empresas;
import br.com.ifms.autenticador.repository.EmpresaRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping(value = "/api/empresas")
	public class EmpresaResource {

		@Autowired
		EmpresaRepository repository;

		@ApiResponses(value = {

				@ApiResponse(code = 200, message = "Operação realizada com sucesso!!!!"),
				@ApiResponse(code = 404, message = "Não encontrado!!!!"),
				@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
				@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
		
		@GetMapping("/listar")
		public List<Empresas> listarEmpresas() {

			return repository.findAll();
		}

		@GetMapping("/buscaPorId/{id}")
		public Empresas buscaEmpresasID(@PathVariable(value = "id") long id) {

			return repository.findById(id);

		}

		@ApiResponses(value = {

				@ApiResponse(code = 200, message = "Empresa salva com sucesso!!!!"),
				@ApiResponse(code = 404, message = "Não encontrado!!!!"),
				@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
				@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
		
		
		@PostMapping("/salvar")
		public Empresas salvarEmpresas(@RequestBody Empresas empresas) {

			return repository.save(empresas);
		}

		// ok
		@DeleteMapping("/remover/{id}")
		public void deleteEmpresas(@PathVariable(value = "id") long id) {

			Empresas empresas = buscaEmpresasID(id);

			if (empresas.getIdEmpresa() > 0) {
				repository.delete(empresas);

			}
		}

		@PutMapping("/atualizar/{id}")
		public Empresas atualizarDesenvolvedor(@PathVariable(value = "id") long id, @RequestBody Empresas empresas) {

			Empresas empresasNew = buscaEmpresasID(id);

			if (empresasNew.getIdEmpresa() == empresas.getIdEmpresa()) {

				return repository.save(empresas);

			}

			return null;
		}

	}

	
	
	
	
	
	

