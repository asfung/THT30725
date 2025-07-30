package com.springboot.task.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.task.exception.NotFoundException;
import com.springboot.task.model.pojo.Gudang;
import com.springboot.task.repository.GudangRepository;
import com.springboot.task.service.GudangService;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class GudangServiceImpl implements GudangService {

  private final GudangRepository gudangRepository;

  @Override
  @Transactional
  public DataResponse<Gudang> createGudang(Gudang gudang) {
    try {
      gudang.setWaktuRekam(LocalDateTime.now());
      gudang.setWaktuUpdate(LocalDateTime.now());
      return new DataResponse<>(gudangRepository.save(gudang));
    } catch (Exception e) {
      log.error("Error creating gudang", e);
      throw e;
    }
  }

  @Override
  @Transactional
  public DataResponse<Gudang> updateGudang(Long id, Gudang gudang) {
    try {
      Gudang existing = gudangRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Gudang not found"));
      // existing.setKodeGudang(gudang.getKodeGudang());
      // existing.setKodeKantor(gudang.getKodeKantor());
      // existing.setAlamat(gudang.getAlamat());
      // existing.setLatitude(gudang.getLatitude());
      // existing.setLongitude(gudang.getLongitude());

      if(gudang.getKodeGudang() != null){
        existing.setKodeGudang(gudang.getKodeGudang());
      }
      if(gudang.getKodeKantor() != null){
        existing.setKodeKantor(gudang.getKodeKantor());
      }
      if(gudang.getAlamat() != null){
        existing.setAlamat(gudang.getAlamat());
      }
      if(gudang.getLatitude() != null){
        existing.setLatitude(gudang.getLatitude());
      }
      if(gudang.getLongitude() != null){
        existing.setLongitude(gudang.getLongitude());
      }

      existing.setWaktuUpdate(LocalDateTime.now());
      return new DataResponse<>(gudangRepository.save(existing));
    } catch (Exception e) {
      log.error("Error updating gudang", e);
      throw e;
    }
  }

  @Override
  @Transactional
  public DefaultResponse deleteGudang(Long id) {
    try {
      Gudang existing = gudangRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Gudang not found"));
      gudangRepository.delete(existing);
      return new DefaultResponse("Gudang deleted successfully");
    } catch (Exception e) {
      log.error("Error deleting gudang", e);
      throw e;
    }
  }

  @Override
  public DataResponse<Gudang> getGudang(Long id) {
    return new DataResponse<>(gudangRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Gudang not found")));
  }

  @Override
  public ListResponse<Gudang> getAllGudang() {
    List<Gudang> list = gudangRepository.findAll();
    if(list.isEmpty()){
      throw new NotFoundException("Gudang not found");
    }
    return new ListResponse<>(list);
  }

  @Override
  public ListResponse<Gudang> findByKodeKantor(String kodeKantor) {
    var result = gudangRepository.findByKodeKantor(kodeKantor);
    if (result.isEmpty()) {
      throw new NotFoundException("Gudang not found");
    }
    return new ListResponse<>(result);
  }

  @Override
  public DatatableResponse<Gudang> paginateGudang(int page, int limit) {
    PageRequest pageRequest = PageRequest.of(page - 1, limit);
    var result = gudangRepository.findAll(pageRequest);
    return new DatatableResponse<>(
      result.getContent(), 
      result.getNumberOfElements(), 
      result.getTotalElements(), 
      result.getTotalPages()
    );
  }
}
