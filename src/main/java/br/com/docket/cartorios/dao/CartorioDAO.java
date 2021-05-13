package br.com.docket.cartorios.dao;

import br.com.docket.cartorios.dto.Cartorio;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CartorioDAO {

	private String name;
	private String address;
	private String certificates;
	
	public Cartorio toCartorio() {
		Cartorio cartorio = new Cartorio();
		cartorio.setName(this.name);
		cartorio.setAddress(this.address);
		cartorio.setCertificates(this.certificates);
		return cartorio;
	}
}
