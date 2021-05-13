package br.com.docket.cartorios.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.docket.cartorios.dao.Certidoes;
import br.com.docket.cartorios.dao.EmissaoDAO;
import br.com.docket.cartorios.dto.Cartorio;
import br.com.docket.cartorios.repository.CartorioRepository;
import br.com.docket.cartorios.service.CertificatesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping({"/certidao"})
public class CertidoesController {
	
	@Autowired
	private CartorioRepository cartorioRepo;
	
	@Autowired
	private CertificatesService certidoes;
	
	@GetMapping({"/solicitacao"})
	public String certificateRequest(Model model) {
		List<Cartorio> cartorios = cartorioRepo.findAll();
		model.addAttribute("carts", cartorios);
		List<Certidoes> certs;
		try {
			certs = certidoes.getCertificatesName();
			model.addAttribute("certidoes", certs);
		} catch (IOException e) {
			log.error("Falha ao recuperar tipos de certidoes!", e);
		}
    	return "segundavia_certidoes";
	}
	
	@PostMapping({"/emitir"})
	public String emit(EmissaoDAO emissaoDao) {
		log.info(emissaoDao.toString());
    	return "segundavia_certidoes";
	}

}
