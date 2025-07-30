package com.springboot.task.model.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "KONTAINER")
public class Kontainer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(name = "kode_gudang", nullable = false)
  private String kodeGudang;

  @NotBlank
  @Column(name = "kode_kantor", nullable = false)
  private String kodeKantor;

  @NotBlank
  @Column(name = "nomor_kontainer", nullable = false)
  private String nomorKontainer;

  @Column(name = "ukuran_kontainer")
  private String ukuranKontainer;

  @NotNull
  @Column(name = "tanggal_tiba", nullable = false)
  private LocalDate tanggalTiba;

  @NotNull
  @Column(name = "bruto", nullable = false)
  private BigDecimal bruto;

  @Column(name = "nomor_dokumen")
  private String nomorDokumen;

  @Column(name = "waktu_rekam", updatable = false)
  private LocalDateTime waktuRekam = LocalDateTime.now();

}
