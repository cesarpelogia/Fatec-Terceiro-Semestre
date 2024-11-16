package com.pelogia.cervejaria.Controller;

import java.util.List;

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

import com.pelogia.cervejaria.Entity.Cerveja;
import com.pelogia.cervejaria.Service.CervejaService;

@RestController
@RequestMapping("/cerveja")
public class CervejaController {

     @Autowired
    private CervejaService cervejaService;

    @GetMapping
    public List<Cerveja> getCervejas(){
        return cervejaService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Cerveja> getCervejaByID(@PathVariable Long id){
        return cervejaService.findById(id)
                             .map(cerveja -> ResponseEntity.ok(cerveja))
                             .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }

    @PostMapping
    ResponseEntity<Cerveja> postCerveja(@RequestBody Cerveja cerveja){
        Cerveja savedCerveja = cervejaService.save(cerveja);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCerveja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cerveja> putCerveja(@PathVariable Long id, @RequestBody Cerveja cerveja) {
        return cervejaService.update(id, cerveja)
                .map(updatedCerveja -> ResponseEntity.ok(updatedCerveja))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCerveja(@PathVariable Long id) {
        if (cervejaService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
