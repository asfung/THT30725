package com.springboot.task.service;

import com.springboot.task.model.pojo.Gudang;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

public interface GudangService {
  DataResponse<Gudang> createGudang(Gudang gudang);
  DataResponse<Gudang> updateGudang(Long id, Gudang gudang);
  DefaultResponse deleteGudang(Long id);
  DataResponse<Gudang> getGudang(Long id);
  ListResponse<Gudang> getAllGudang();
  ListResponse<Gudang> findByKodeKantor(String kodeKantor);
  DatatableResponse<Gudang> paginateGudang(int page, int limit);
}
