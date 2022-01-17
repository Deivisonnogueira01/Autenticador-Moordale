package br.com.ifms.autenticador.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.autenticador.model.Sexo;

@RestController
@RequestMapping(value = "/api")
public class SexoResource {
	
	Sexo sexo;
	
	
	@GetMapping("/Sexo/listar")
	public ArrayList<Sexo> listarTodos(){
		
		ArrayList<Sexo> lista = new ArrayList<>();
		 
		lista.add(sexo.FEMININO);
		lista.add(sexo.MASCULINO);
		
		return lista;
	}
	
	@GetMapping("/usuario/{nome}")
	public String ola(@PathVariable String nome){
		
		return "Olá "+ nome;
	}
	
	
	
	

}
