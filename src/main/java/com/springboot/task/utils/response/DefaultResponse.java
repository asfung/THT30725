package com.springboot.task.utils.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultResponse extends StandardResponseWrapper {
  public DefaultResponse(String message) {
    super(true, message);
  }
}