package com.springboot.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.task.model.pojo.Gudang;

@Repository
public interface GudangRepository extends JpaRepository<Gudang, Long> {
  List<Gudang> findByKodeKantor(String kodeKantor);
}
