package br.com.cep.controllers;

import br.com.cep.dto.CepResponseDTO;
import br.com.cep.services.cep.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping(value = "/v1/CEP/{cepId}")
    public ResponseEntity<CepResponseDTO> consultCepId(@PathVariable(value = "cepId", required = true) String cepId) {
        return ResponseEntity.status(HttpStatus.OK).body(cepService.getCepId(cepId));
    }
}
