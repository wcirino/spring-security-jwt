package com.projetoSpringSec.Spring.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projetoSpringSec.Spring.dto.Cidade;
import com.projetoSpringSec.Spring.dto.Estado;
import com.projetoSpringSec.Spring.dto.Login;
import com.projetoSpringSec.Spring.dto.cep;
import com.projetoSpringSec.Spring.exception.CepException;
import com.projetoSpringSec.Spring.repository.CidadeRepository;
import com.projetoSpringSec.Spring.repository.EstadoRepository;
import com.projetoSpringSec.Spring.repository.LoginRepository;

@Service
public class UtilService {

	@Autowired
	private CidadeRepository proxyCidade;
	
	@Autowired
	private EstadoRepository proxyEstado;
	
	@Autowired
	private LoginRepository proxylogin;
	
	@Autowired
	private Random proxRandom;
	
	public List<Cidade> findAllCidade(int id){
		return proxyCidade.findByIdestado(id);
	}
	
	public List<Estado> findAllestado(){
		return proxyEstado.findAll();
	}
	
    public String findByLoginservice(String login) {
    	Login lg = proxylogin.findByLogin(login);
    	if(lg == null) {
    		//ok
    		return "1";
    	}
    	else {
    		//existe
    		return "2";
    	}
    }
    
    public String GerandoCarteirinha() {
		 String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
	                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
	                "x", "y", "z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
		 
		 String carteirinha = "";
		 int index;
		 
		 for(int i=0; i<=10; i++){
			 index = proxRandom.nextInt(caracteres.length); 
			 carteirinha += caracteres[index];
		 }
		 
		 return carteirinha;
	}
    
    public cep findCep(String cp) {
    	
    	try {
    			String uri = "https://viacep.com.br/ws/"+cp+"/json/";     	
    			RestTemplate api = new RestTemplate();
    			cep cepDto = api.getForObject(uri,cep.class);
    			if(cepDto != null) {
    				return cepDto;
    			}
    			else
    				throw new CepException("Erro cep null");
    		}
    	catch (Exception e) {
		   throw new CepException("Erro no cep");
		}
    }
}
