package br.com.cep.repositories;

import br.com.cep.entities.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<CepEntity, String> {

}
