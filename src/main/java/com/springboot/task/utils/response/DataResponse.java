package com.springboot.task.utils.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<T> extends StandardResponseWrapper {
  private T data;

  public DataResponse(T data) {
    super(true, "OK");
    this.data = data;
  }
}
