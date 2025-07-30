package com.springboot.task.model.pojo;

import java.math.BigDecimal;
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
@Table(name = "GUDANG")
public class Gudang {

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
  @Column(name = "alamat", nullable = false)
  private String alamat;

  @NotNull
  @Column(name = "latitude", nullable = false)
  private BigDecimal latitude;

  @NotNull
  @Column(name = "longitude", nullable = false)
  private BigDecimal longitude;

  @Column(name = "waktu_rekam", updatable = false)
  private LocalDateTime waktuRekam = LocalDateTime.now();

  @Column(name = "waktu_update")
  private LocalDateTime waktuUpdate = LocalDateTime.now();
}
