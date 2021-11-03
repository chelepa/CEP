package br.com.cep.client;

import br.com.cep.dto.ViaCepResponseDTO;
import br.com.cep.exceptions.BadRequestException;
import br.com.cep.exceptions.NotFoundException;
import br.com.cep.exceptions.ViaCepClientException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ViaCepProxy {

    @Autowired
    private ViaCepClient viaCepClient;

    public ViaCepResponseDTO getViaCepId(String cepId) {

        long timeBefore = System.currentTimeMillis();

        try {

            log.info("ViaCepProxy.getViaCepId - start - cepId [{}]", cepId);

            ViaCepResponseDTO response = viaCepClient.getViaCep(cepId);

            log.info("ViaCepProxy.getViaCepId - end  - cepId: [{}], response: [{}], took: [{}]", cepId, response,  System.currentTimeMillis()-timeBefore);

            return response;

        } catch (FeignException fe) {
            if(HttpStatus.BAD_REQUEST.value() == fe.status()) {
                log.error("CustomerClient bad request. - Error {}", fe.getMessage(), fe);
                throw new BadRequestException(HttpStatus.BAD_REQUEST.value() + " - bad request");
            } else if(fe.status() == HttpStatus.NOT_FOUND.value()) {
                log.error("CustomerClient not found. - Error {}", fe.getMessage(), fe);
                throw new NotFoundException(HttpStatus.NOT_FOUND.value() + " - not found");
            } else {
                log.error("CustomerClient error  - Error {}", fe.getMessage(), fe);
                throw new ViaCepClientException("ViaCepClientException error  - " + fe.getMessage());
            }
        }
    }
}
