package com.springboot.task.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KontainerResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  private String kodeGudang;
  private String kodeKantor;
  private String nomorKontainer;
  private String ukuranKontainer;
  private LocalDate tanggalTiba;
  private BigDecimal bruto;
  private String nomorDokumen;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDateTime waktuRekam;


}
