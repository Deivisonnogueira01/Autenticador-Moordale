package br.com.ifms.autenticador.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

import br.com.ifms.autenticador.model.Desenvolvedor;

@Service
public class AlunoService {

 
	public String message(Desenvolvedor desenvolvedor){
		
		
		return "DESENVOLVEDOR: "+desenvolvedor.getNomeDev() + "    TAG: "+desenvolvedor.getIdDev();
		
	}
	
	
	
	public int calcularIdade(Date data) {

		Calendar date = new GregorianCalendar();
		date.setTime(data);
		Calendar hoje = Calendar.getInstance();
		return hoje.get(Calendar.YEAR) - date.get(Calendar.YEAR);

	}

}
