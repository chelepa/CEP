package br.com.cep.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CEP")
public class CepEntity implements Serializable {

    @Id
    @Column(name = "CEP")
    private String cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LOCALIDADE")
    private String localidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "DDD")
    private String ddd;

}
