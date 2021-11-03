package br.com.cep;

import br.com.cep.converter.CepResponseDTOToViaCepResponseDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class CepApplication {

	public static void main(String[] args) {
		SpringApplication.run(CepApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(new CepResponseDTOToViaCepResponseDTOConverter());
		return modelMapper;
	}

}
