package br.com.tech4me.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.petshop.service.PetService;
import br.com.tech4me.petshop.shared.PetDto;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired 
    private PetService servico;
    @GetMapping
    private ResponseEntity<List<PetDto>> obterPets(){
        return new ResponseEntity<>(servico.obterPets(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<PetDto> cadastrarPets(@RequestBody PetDto dto){
        return new ResponseEntity<>(servico.cadastrarPets(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PetDto> atualizarPets(@PathVariable String id, @RequestBody PetDto pet){
        PetDto petAtualizado = servico.atualizarPorId(id, pet);
        
        if(petAtualizado != null){
            return new ResponseEntity<>(petAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarPets(@PathVariable String id){
        servico.deletarPets(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PetDto> obterporId(@PathVariable String id){
        Optional<PetDto> pet = servico.obterporId(id);

        if(pet.isPresent()){
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
