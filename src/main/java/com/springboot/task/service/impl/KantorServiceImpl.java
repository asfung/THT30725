package com.springboot.task.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.task.exception.NotFoundException;
import com.springboot.task.model.pojo.Kantor;
import com.springboot.task.repository.KantorRepository;
import com.springboot.task.service.KantorService;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class KantorServiceImpl implements KantorService {

  private final KantorRepository kantorRepository;
  // private final ObjectMapper objectMapper;

  @Override
  @Transactional
  public DataResponse<Kantor> createKantor(Kantor kantor) {
    try {
      kantor.setWaktuRekam(LocalDateTime.now());
      kantor.setWaktuUpdate(LocalDateTime.now());
      return new DataResponse<>(kantorRepository.save(kantor));
    } catch (Exception e) {
      log.error("Error creating kantor", e);
      throw e;
    }
  }

  @Override
  @Transactional
  public DataResponse<Kantor> updateKantor(Long id, Kantor kantor) {
    try {
      Kantor existing = kantorRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Kantor not found"));
      // existing.setNamaKantor(kantor.getNamaKantor());
      // existing.setKodeKantor(kantor.getKodeKantor());
      // existing.setAlamatKantor(kantor.getAlamatKantor());

      if (kantor.getNamaKantor() != null) {
        existing.setNamaKantor(kantor.getNamaKantor());
      }
      if (kantor.getKodeKantor() != null) {
        existing.setKodeKantor(kantor.getKodeKantor());
      }
      if (kantor.getAlamatKantor() != null) {
        existing.setAlamatKantor(kantor.getAlamatKantor());
      }
      existing.setWaktuUpdate(LocalDateTime.now());
      // objectMapper.updateValue(existing, kantor);
      // existing.setWaktuUpdate(LocalDateTime.now());
      return new DataResponse<>(kantorRepository.save(existing));
    } catch (Exception e) {
      log.error("Error updating kantor", e);
      throw e;
    }
  }

  @Override
  @Transactional
  public DefaultResponse deleteKantor(Long id) {
    try {
      Kantor existing = kantorRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Kantor not found"));
      kantorRepository.delete(existing);
      return new DefaultResponse("Kantor deleted successfully");
    } catch (Exception e) {
      log.error("Error deleting kantor", e);
      throw e;
    }
  }

  @Override
  public DataResponse<Kantor> getKantor(Long id) {
    return new DataResponse<>(kantorRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Kantor not found")));
  }

  @Override
  public ListResponse<Kantor> getAllKantor() {
    List<Kantor> list = kantorRepository.findAll();
    // if (list.isEmpty()) {
    //   throw new NotFoundException("Kantor not found");
    // }
    return new ListResponse<>(list);
  }

  @Override
  public DatatableResponse<Kantor> paginateKantor(int page, int limit) {
    PageRequest pageRequest = PageRequest.of(page - 1, limit);
    var result = kantorRepository.findAll(pageRequest);
    // if(result.isEmpty()){
    //   throw new NotFoundException("Kantor not found");
    // }
    return new DatatableResponse<>(
      result.getContent(), 
      result.getNumberOfElements(), 
      result.getTotalElements(), 
      result.getTotalPages()
    );
  }

}
