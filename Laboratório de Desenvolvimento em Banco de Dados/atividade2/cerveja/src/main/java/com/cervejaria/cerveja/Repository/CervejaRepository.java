package com.cervejaria.cerveja.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervejaria.cerveja.entity.Cerveja;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {
}
