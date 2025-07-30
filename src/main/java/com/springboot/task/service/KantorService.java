package com.springboot.task.service;


import com.springboot.task.model.pojo.Kantor;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

public interface KantorService {
  DataResponse<Kantor> createKantor(Kantor kantor);
  DataResponse<Kantor> updateKantor(Long id, Kantor kantor);
  DefaultResponse deleteKantor(Long id);
  DataResponse<Kantor> getKantor(Long id);
  ListResponse<Kantor> getAllKantor();
  DatatableResponse<Kantor> paginateKantor(int page, int limit);
}
