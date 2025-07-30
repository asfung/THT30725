package com.springboot.task.model.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "KANTOR")
public class Kantor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(name = "nama_kantor", nullable = false)
  private String namaKantor;

  @NotBlank
  @Column(name = "kode_kantor", nullable = false, unique = true)
  private String kodeKantor;

  @NotNull
  @Column(name = "alamat_kantor", nullable = false)
  private String alamatKantor;

  @Column(name = "waktu_rekam", updatable = false)
  private LocalDateTime waktuRekam = LocalDateTime.now();

  @Column(name = "waktu_update")
  private LocalDateTime waktuUpdate = LocalDateTime.now();


}
