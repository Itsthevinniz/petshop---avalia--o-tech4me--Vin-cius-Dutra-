package br.com.tech4me.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.petshop.model.Pet;
import br.com.tech4me.petshop.repository.PetRepository;
import br.com.tech4me.petshop.shared.PetDto;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository repositorio;
    @Override
    public List<PetDto> obterPets() {
        return repositorio.findAll()
                        .stream()
                        .map(p -> new PetDto(p.getId(), p.getNome(), p.getRaca(), p.getAnoNascimento(), p.isVacinado(), p.getProcedimentos()))
                        .toList();
    }
    @Override
    public PetDto cadastrarPets(PetDto dto) {
        Pet pet = new Pet(dto);
        repositorio.save(pet);
        return new PetDto(pet.getId(), pet.getNome(), pet.getRaca(), pet.getAnoNascimento(), pet.isVacinado(), pet.getProcedimentos());
    }
    @Override
    public PetDto atualizarPorId(String id, PetDto dto) {
        Pet pet = repositorio.findById(id).orElse(null);

        if(pet != null) {
            Pet atualizarPet = new Pet(dto);
            atualizarPet.setId(id);
            repositorio.save(atualizarPet);
            return new PetDto(pet.getId(),
                pet.getNome(), pet.getRaca(), 
                pet.getAnoNascimento(), pet.isVacinado(),
                pet.getProcedimentos());
        } else {
            return dto;
        }
    }
    @Override
    public void deletarPets(String id) {
        repositorio.deleteById(id);
    }
    @Override
    public Optional<PetDto> obterporId(String id) {
        Optional<Pet> pet = repositorio.findById(id);

        if(pet.isPresent()){
            return Optional.of(new PetDto(pet.get().getId(),
                pet.get().getNome(), pet.get().getRaca(), 
                pet.get().getAnoNascimento(), pet.get().isVacinado(),
                 pet.get().getProcedimentos()));
        } else {
            return Optional.empty();
        }
    }
    
}
