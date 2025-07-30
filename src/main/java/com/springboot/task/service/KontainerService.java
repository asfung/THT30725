package com.springboot.task.service;

import com.springboot.task.model.pojo.Kontainer;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

public interface KontainerService {
  DataResponse<Kontainer> createKontainer(Kontainer kontainer);
  DataResponse<Kontainer> updateKontainer(Long id, Kontainer kontainer);
  DefaultResponse deleteKontainer(Long id);
  DataResponse<Kontainer> getKontainer(Long id);
  ListResponse<Kontainer> getAllKontainer();
  ListResponse<Kontainer> findByGudangKantorDokumen(String kodeGudang, String kodeKantor, String nomorDokumen);
  DatatableResponse<Kontainer> paginateKontainer(int page, int limit);
}

