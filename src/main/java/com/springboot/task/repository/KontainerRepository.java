package com.springboot.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.task.model.pojo.Kontainer;

@Repository
public interface KontainerRepository extends JpaRepository<Kontainer, Long> {
  List<Kontainer> findByKodeGudangAndKodeKantorAndNomorDokumen(String kodeGudang, String kodeKantor, String nomorDokumen);
}