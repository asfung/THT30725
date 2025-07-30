package com.springboot.task.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KantorRequest {
  @NotBlank
  @Size(max = 255)
  private String namaKantor;

  @NotBlank
  @Size(max = 10)
  private String kodeKantor;

  @NotBlank
  private String alamatKantor;
}
