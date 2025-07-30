package com.springboot.task.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KantorResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  private String namaKantor;
  private String kodeKantor;
  private String alamatKantor;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDateTime waktuRekam;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDateTime waktuUpdate;

}