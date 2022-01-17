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

import br.com.ifms.autenticador.model.Desenvolvedor;
import br.com.ifms.autenticador.repository.DesenvolvedorRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping(value = "/api/desenvolvedor")
	public class DesenvolvedorResource {

		@Autowired
		DesenvolvedorRepository repository;

		@ApiResponses(value = {

				@ApiResponse(code = 200, message = "Operação realizada com sucesso!!!!"),
				@ApiResponse(code = 404, message = "Não encontrado!!!!"),
				@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
				@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
		
		//Certo
		@GetMapping("/listar")
		public List<Desenvolvedor> listarDesenvolvedor() {

			return repository.findAll();
		}
          
		/// Certo
		@GetMapping("/buscaPorId/{id}")
		public Desenvolvedor buscaDesenvolvedorID(@PathVariable(value = "id") long id) {

			return repository.findById(id);

		}

		@ApiResponses(value = {

				@ApiResponse(code = 200, message = "Desenvolvedor salvo com sucesso!!!!"),
				@ApiResponse(code = 404, message = "Não encontrado!!!!"),
				@ApiResponse(code = 403, message = "Não tem permissão para acessar!!!"),
				@ApiResponse(code = 500, message = "Gerou uma excessão!!!") })
		
		
		//
		@PostMapping( value ="/salvar")
		public Desenvolvedor salvarDesenvolvedor(@RequestBody Desenvolvedor desenvolvedor) {

			return repository.save(desenvolvedor);
		}

		
		@DeleteMapping(value = "/removerdesenvolvedor/{id}")
	    public Desenvolvedor removerDesenvolvedor(@PathVariable(value = "id") long id) {
	        Desenvolvedor desenvolvedornew = buscaDesenvolvedorID(id);
	        if (desenvolvedornew == buscaDesenvolvedorID(id)) {
	            repository.delete(desenvolvedornew);
	        }
	        return null;
	    }
		
		
		@PutMapping(value = "/atualizardev/{id}")
		 public Desenvolvedor atualizarDesenvolvedor(@PathVariable(value = "id") long id) {
	        Desenvolvedor desenvolvedornew = buscaDesenvolvedorID(id);
	        if (desenvolvedornew == buscaDesenvolvedorID(id)) {
	            repository.save(desenvolvedornew);
	        }
	        
	        return null;
	    }
		
		
/*
		@PutMapping(value = "/atualizardev/{id}")
		public Desenvolvedor atualizarDesenvolvedor( @RequestBody Desenvolvedor desenvolvedor, @PathVariable(value = "id") long id) {

			Desenvolvedor desenvolvedorNew = buscaDesenvolvedorID(id);

			if (desenvolvedorNew.getIdDesenvolvedor() == desenvolvedor.getIdDesenvolvedor()) {

				return repository.save(desenvolvedor);

			}

			return null;
		}
		
		*/
		

	}
	
	
	
	
	
	
	

