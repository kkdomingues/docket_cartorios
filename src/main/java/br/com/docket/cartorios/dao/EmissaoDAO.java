package br.com.docket.cartorios.dao;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmissaoDAO {

	private String nomeCartorio;
	private String nomePessoa;
	private String email;
	private String certificates;
	
}
