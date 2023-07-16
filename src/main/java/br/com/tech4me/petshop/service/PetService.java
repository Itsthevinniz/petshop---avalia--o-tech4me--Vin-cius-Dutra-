package br.com.tech4me.petshop.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.petshop.shared.PetDto;

public interface PetService {
    List<PetDto> obterPets();
    PetDto cadastrarPets(PetDto dto);
    PetDto atualizarPorId(String id, PetDto dto);
    void deletarPets(String id);
    Optional <PetDto> obterporId(String id);
}
