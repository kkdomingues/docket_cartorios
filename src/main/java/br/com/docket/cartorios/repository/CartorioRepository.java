package br.com.docket.cartorios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.docket.cartorios.dto.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{
}
