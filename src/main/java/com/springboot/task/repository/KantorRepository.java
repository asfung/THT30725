package com.springboot.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.task.model.pojo.Kantor;

@Repository
public interface KantorRepository extends JpaRepository<Kantor, Long> {
  
}
