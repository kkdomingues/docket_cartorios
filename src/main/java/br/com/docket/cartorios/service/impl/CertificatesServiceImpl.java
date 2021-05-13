package br.com.docket.cartorios.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.docket.cartorios.dao.Certidoes;
import br.com.docket.cartorios.service.CertificatesService;

@Service
public class CertificatesServiceImpl implements CertificatesService {

	@Override
	public List<Certidoes> getCertificatesName() throws IOException {
		URL url = new URL("https://docketdesafiobackend.herokuapp.com/api/v1/certidoes");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Certidoes> certidoes = objectMapper.readValue(responseStream, new TypeReference<List<Certidoes>>(){});
		return certidoes;
	}

	@Override
	public Certidoes getCertificatesName(int id) throws IOException {
		URL url = new URL("https://docketdesafiobackend.herokuapp.com/api/v1/certidoes/" + id);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		Certidoes certidoes = objectMapper.readValue(responseStream, Certidoes.class);
		return certidoes;
	}

	
	
}
