package com.springboot.task.utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardResponseWrapper {
  private boolean success;
  private String message;
}
