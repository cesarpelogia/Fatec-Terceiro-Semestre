package com.cervejaria.cerveja.cervejaController;

import java.util.ArrayList;
import java.util.List;

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

import com.cervejaria.cerveja.domain.CervejaDTO;

@RestController
@RequestMapping("/cerveja")
public class CervejaController {

    public List<CervejaDTO> cervejas = new ArrayList<>();

    public CervejaController(){
    cervejas.addAll(List.of(
        new CervejaDTO(0, "Skol", "Pilsen", 500, 4.5),
        new CervejaDTO(1, "Brahma", "Chopp", 350, 3.8),
        new CervejaDTO(2, "Antarctica", "Original", 600, 5.0),
        new CervejaDTO(3, "Bohemia", "Puro Malte", 355, 4.2)
    ));
    }
    
    @GetMapping
        Iterable<CervejaDTO> getCervejas(){
            return cervejas;
        }

    @GetMapping("/{id}")
    ResponseEntity<CervejaDTO> getCervejaByID(@PathVariable Long id){
        for (CervejaDTO c : cervejas){
            if (id.equals(c.getId())){
                return ResponseEntity.ok(c);
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    @PostMapping
    ResponseEntity<CervejaDTO> postCerveja(@RequestBody CervejaDTO cervejaDTO){
        long idEncontrado = cervejaDTO.getMaiorId(cervejas);
        cervejaDTO.setid(idEncontrado);
        cervejas.add(cervejaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(cervejaDTO);
    }

    @PutMapping("/{id}")
    ResponseEntity<CervejaDTO> putCerveja(@PathVariable Long id, @RequestBody CervejaDTO cerveja) {
            int cervejaIndex = -1;
            for (CervejaDTO c : cervejas) {
                if (Long.valueOf(c.getId()).equals(id)) {
                    cervejaIndex = cervejas.indexOf(c);
                    cervejas.set(cervejaIndex, cerveja);
                }
            } return (cervejaIndex == -1) ?
                ResponseEntity.status(HttpStatus.CREATED).body(cerveja) :
                ResponseEntity.ok(cerveja);
    }

    @DeleteMapping("/{id}")
    void deleteCerveja(@PathVariable Long id) {
        cervejas.removeIf(c -> c.getId() == id);
    }
}

