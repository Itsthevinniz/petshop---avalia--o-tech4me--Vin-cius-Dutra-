package br.com.tech4me.petshop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.petshop.shared.PetDto;

@Document
public class Pet {

    public Pet() {}

    public Pet(PetDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.raca = dto.raca();
        this.anoNascimento = dto.anoNascimento();
        this.vacinado = dto.vacinado();
        this.procedimentos = dto.procedimentos();
    }

    @Id
    String id;
    String nome;
    String raca;
    int anoNascimento;
    boolean vacinado;
    List<String> procedimentos = new ArrayList<>();

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    public boolean isVacinado() {
        return vacinado;
    }
    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
    public List<String> getProcedimentos() {
        return procedimentos;
    }
    public void setProcedimentos(List<String> procedimentos) {
        this.procedimentos = procedimentos;
    }
}
