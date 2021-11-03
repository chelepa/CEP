package br.com.cep.client;

import br.com.cep.dto.ViaCepResponseDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url = "${api.ViaCep.url}", configuration = ViaCepConfig.class)
public interface ViaCepClient {

    @GetMapping(value = "${api.ViaCep.path.cepId}")
    ViaCepResponseDTO getViaCep(@PathVariable("cepId") String cepId);

}