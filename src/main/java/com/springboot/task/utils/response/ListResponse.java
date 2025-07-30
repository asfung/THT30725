package com.springboot.task.utils.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResponse<T> extends StandardResponseWrapper {

  private List<T> data;

  public ListResponse(List<T> data) {
    super(true, "OK");
    this.data = data;
  }

}
