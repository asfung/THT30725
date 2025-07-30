package com.springboot.task.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GudangResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  private String kodeGudang;
  private String kodeKantor;
  private String alamat;
  private BigDecimal latitude;
  private BigDecimal longitude;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDateTime waktuRekam;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDateTime waktuUpdate;
}


