package br.com.cep.converter;

import br.com.cep.dto.CepResponseDTO;
import br.com.cep.dto.ViaCepResponseDTO;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Objects;

public class CepResponseDTOToViaCepResponseDTOConverter implements Converter<ViaCepResponseDTO, CepResponseDTO>{

    @Override
    public CepResponseDTO convert(MappingContext<ViaCepResponseDTO, CepResponseDTO> context) {
        CepResponseDTO destination =  Objects.isNull(context.getDestination()) ? new CepResponseDTO() : context.getDestination();

        destination.setCep(context.getSource().getCep().replace("-",""));
        destination.setLogradouro(context.getSource().getLogradouro());
        destination.setComplemento(context.getSource().getComplemento());
        destination.setBairro(context.getSource().getBairro());
        destination.setLocalidade(context.getSource().getLocalidade());
        destination.setUf(context.getSource().getUf());
        destination.setDdd(context.getSource().getDdd());

        return destination;
    }
}
