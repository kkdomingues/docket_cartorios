package br.com.docket.cartorios.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import br.com.docket.cartorios.dao.Certidoes;

public interface CertificatesService {
	
	public List<Certidoes> getCertificatesName() throws IOException;
	public Certidoes getCertificatesName(int id) throws IOException;
}
