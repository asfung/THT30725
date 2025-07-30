package com.springboot.task.utils.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatatableResponse<T> extends StandardResponseWrapper {
  private List<T> data;
  Meta meta;

  public DatatableResponse(List<T> data, int itemPerPage, long total, long totalPage) {
    super(true, "OK");
    this.data = data;
    this.meta = new Meta(itemPerPage, total, totalPage);
  }

  @Getter
  @Setter
  public static class Meta {
    private int itemPerPage;
    private long total;
    private long totalPage;

    public Meta(int itemPerPage, long total, long totalPage) {
      this.itemPerPage = itemPerPage;
      this.total = total;
      this.totalPage = totalPage;
    }
  }

}
