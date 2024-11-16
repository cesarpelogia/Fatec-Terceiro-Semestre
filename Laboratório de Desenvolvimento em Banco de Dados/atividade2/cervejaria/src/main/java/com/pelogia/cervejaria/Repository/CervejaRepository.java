package com.pelogia.cervejaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelogia.cervejaria.Entity.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

}
