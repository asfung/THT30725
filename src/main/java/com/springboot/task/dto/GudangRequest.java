package com.springboot.task.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GudangRequest {

  @NotBlank
  private String kodeGudang;

  @NotBlank
  private String kodeKantor;

  @NotBlank
  private String alamat;

  @NotNull
  private BigDecimal latitude;

  @NotNull
  private BigDecimal longitude;



}



