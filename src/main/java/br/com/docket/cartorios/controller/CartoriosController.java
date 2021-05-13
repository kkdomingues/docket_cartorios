package br.com.docket.cartorios.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.docket.cartorios.dao.CartorioDAO;
import br.com.docket.cartorios.dao.Certidoes;
import br.com.docket.cartorios.dto.Cartorio;
import br.com.docket.cartorios.repository.CartorioRepository;
import br.com.docket.cartorios.service.CertificatesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/cartorio")
public class CartoriosController {
	
	@Autowired
	private CartorioRepository cartorioRepo;
	
	@Autowired
	private CertificatesService certidoes;
	
	@GetMapping({"/listar"})
	public String list(Model model) {
		List<Cartorio> cartorios = cartorioRepo.findAll();
		model.addAttribute("cartorios", cartorios);
    	return "lista_cartorio";
	}

	@GetMapping({"/cadastro"})
	public String register(Model model) {
		try {
			List<Certidoes> certs = certidoes.getCertificatesName();
			model.addAttribute("certidoes", certs);
		} catch (IOException e) {
			log.error("Falha ao recuperar tipos de certidoes!", e);
		}
		
    	return "cadastro_cartorio";
	}

	@PostMapping({"/novo"})
	public String insert(CartorioDAO cartorio) {
		cartorioRepo.save(cartorio.toCartorio());
    	return "lista_cartorio";
	}
	
}
