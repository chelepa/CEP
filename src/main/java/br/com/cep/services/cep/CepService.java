package br.com.cep.services.cep;

import br.com.cep.dto.CepResponseDTO;

public interface CepService {

    CepResponseDTO getCepId(String cep);

}
