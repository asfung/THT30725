package com.springboot.task.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KontainerRequest {
  @NotBlank
  private String kodeGudang;

  @NotBlank
  private String kodeKantor;

  @NotBlank
  private String nomorKontainer;

  private String ukuranKontainer;

  @NotNull
  private LocalDate tanggalTiba;

  @NotNull
  private BigDecimal bruto;

  private String nomorDokumen;
}


