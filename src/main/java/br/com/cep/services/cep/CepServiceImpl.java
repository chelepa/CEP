package br.com.cep.services.cep;

import br.com.cep.client.ViaCepProxy;
import br.com.cep.dto.CepResponseDTO;
import br.com.cep.dto.ViaCepResponseDTO;
import br.com.cep.entities.CepEntity;
import br.com.cep.repositories.CepRepository;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CepServiceImpl implements CepService {

    @Autowired
    private ViaCepProxy viaCepProxy;

    @Autowired
    private CepRepository cepRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CepResponseDTO getCepId(String cep) {
    log.info("CepServiceImpl getCepId - start - CepId: [{}] ", cep);
        CepResponseDTO response = new CepResponseDTO();
    try {
        Optional<CepEntity> cepEntity = cepRepository.findById(cep);
        if (cepEntity.isPresent()) {

            response = modelMapper.map(cepEntity.get(), CepResponseDTO.class);

        } else {

            ViaCepResponseDTO viaCepId = viaCepProxy.getViaCepId(cep);
            response = modelMapper.map(viaCepId, CepResponseDTO.class);

            saveCep(response);
        }

    } catch (Exception ex){
        log.error("CepServiceImpl.getCepId - ERROR -  [{}] ", ex);
    }
        return response;
    }

    private void saveCep(CepResponseDTO response) {

        CepEntity entity = modelMapper.map(response, CepEntity.class);

        cepRepository.saveAndFlush(entity);
    }
}
