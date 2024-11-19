package com.pelogia.cervejaria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelogia.cervejaria.Entity.Cerveja;
import com.pelogia.cervejaria.Repository.CervejaRepository;

@Service
public class CervejaService {

        @Autowired
    private CervejaRepository cervejaRepository;

    public List<Cerveja> findAll() {
        return cervejaRepository.findAll();
    }

    public Optional<Cerveja> findById(Long id) {
        return cervejaRepository.findById(id);
    }

    public Cerveja save(Cerveja cerveja) {
        return cervejaRepository.save(cerveja);
    }

    public Optional<Cerveja> update(Long id, Cerveja cerveja) {
        return cervejaRepository.findById(id)
            .map(existingCerveja -> {
                cerveja.setId(existingCerveja.getId());
                return cervejaRepository.save(cerveja);
            });
    }

    public boolean delete (Long id) {
        return cervejaRepository.findById(id)
            .map(cerveja -> {
                cervejaRepository.delete(cerveja);
                return true;
            }).orElse(false);
    }
}
