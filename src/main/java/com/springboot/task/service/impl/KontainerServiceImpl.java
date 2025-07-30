package com.springboot.task.service.impl;

import java.time.LocalDateTime;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.task.exception.NotFoundException;
import com.springboot.task.model.pojo.Kontainer;
import com.springboot.task.repository.KontainerRepository;
import com.springboot.task.service.KontainerService;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class KontainerServiceImpl implements KontainerService {

  private final KontainerRepository kontainerRepository;

  @Override
  @Transactional
  public DataResponse<Kontainer> createKontainer(Kontainer kontainer) {
    try {
      kontainer.setWaktuRekam(LocalDateTime.now());
      return new DataResponse<>(kontainerRepository.save(kontainer));
    } catch (Exception e) {
      log.error("Error creating kontainer", e);
      throw e;
    }
  }

  @Override
  @Transactional
  public DataResponse<Kontainer> updateKontainer(Long id, Kontainer kontainer) {
    try {
      Kontainer existing = kontainerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Kontainer not found"));
      // existing.setKodeGudang(kontainer.getKodeGudang());
      // existing.setKodeKantor(kontainer.getKodeKantor());
      // existing.setNomorKontainer(kontainer.getNomorKontainer());
      // existing.setUkuranKontainer(kontainer.getUkuranKontainer());
      // existing.setTanggalTiba(kontainer.getTanggalTiba());
      // existing.setBruto(kontainer.getBruto());
      // existing.setNomorDokumen(kontainer.getNomorDokumen());

      if(kontainer.getKodeGudang() != null){
        existing.setKodeGudang(kontainer.getKodeGudang());
      }
      if(kontainer.getKodeKantor() != null){
        existing.setKodeKantor(kontainer.getKodeKantor());
      }
      if(kontainer.getNomorKontainer() != null){
        existing.setNomorKontainer(kontainer.getNomorKontainer());
      }
      if(kontainer.getUkuranKontainer() != null){
        existing.setUkuranKontainer(kontainer.getUkuranKontainer());
      }
      if(kontainer.getTanggalTiba() != null){
        existing.setTanggalTiba(kontainer.getTanggalTiba());
      }
      if(kontainer.getBruto() != null){
        existing.setBruto(kontainer.getBruto());
      }
      if(kontainer.getNomorDokumen() != null){
        existing.setNomorDokumen(kontainer.getNomorDokumen());
      }

      return new DataResponse<>(kontainerRepository.save(existing));
    } catch (Exception e) {
      log.error("Error updating kontainer", e);
      throw e;
    }
  }

  @Override
  @Transactional
  public DefaultResponse deleteKontainer(Long id) {
    try {
      Kontainer existing = kontainerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Kontainer not found"));
      kontainerRepository.delete(existing);
      return new DefaultResponse("Kontainer deleted successfully");
    } catch (Exception e) {
      log.error("Error deleting kontainer", e);
      throw e;
    }
  }

  @Override
  public DataResponse<Kontainer> getKontainer(Long id) {
    return new DataResponse<>(kontainerRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Kontainer not found")));
  }

  @Override
  public ListResponse<Kontainer> getAllKontainer() {
    return new ListResponse<>(kontainerRepository.findAll());
  }

  @Override
  public ListResponse<Kontainer> findByGudangKantorDokumen(String kodeGudang, String kodeKantor, String nomorDokumen) {
    var result = kontainerRepository.findByKodeGudangAndKodeKantorAndNomorDokumen(kodeGudang, kodeKantor, nomorDokumen);
    if (result.isEmpty()) {
      throw new NotFoundException("Kontainer not found");
    }
    return new ListResponse<>(result);

  }

  @Override
  public DatatableResponse<Kontainer> paginateKontainer(int page, int limit) {
    PageRequest pageRequest = PageRequest.of(page - 1, limit);
    var result = kontainerRepository.findAll(pageRequest);
    return new DatatableResponse<>(
      result.getContent(), 
      result.getNumberOfElements(), 
      result.getTotalElements(), 
      result.getTotalPages()
    );
  }
}
