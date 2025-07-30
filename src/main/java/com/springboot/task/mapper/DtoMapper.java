package com.springboot.task.mapper;

import com.springboot.task.dto.GudangRequest;
import com.springboot.task.dto.GudangResponse;
import com.springboot.task.dto.KantorRequest;
import com.springboot.task.dto.KantorResponse;
import com.springboot.task.dto.KontainerRequest;
import com.springboot.task.dto.KontainerResponse;
import com.springboot.task.model.pojo.Gudang;
import com.springboot.task.model.pojo.Kantor;
import com.springboot.task.model.pojo.Kontainer;

public class DtoMapper {

  public static Kantor toEntity(KantorRequest dto) {
    Kantor e = new Kantor();
    e.setNamaKantor(dto.getNamaKantor());
    e.setKodeKantor(dto.getKodeKantor());
    e.setAlamatKantor(dto.getAlamatKantor());
    return e;
  }

  public static KantorResponse toDto(Kantor e) {
    KantorResponse dto = new KantorResponse();
    dto.setId(e.getId());
    dto.setNamaKantor(e.getNamaKantor());
    dto.setKodeKantor(e.getKodeKantor());
    dto.setAlamatKantor(e.getAlamatKantor());
    dto.setWaktuRekam(e.getWaktuRekam());
    dto.setWaktuUpdate(e.getWaktuUpdate());
    return dto;
  }

  public static Gudang toEntity(GudangRequest dto) {
    Gudang e = new Gudang();
    e.setKodeGudang(dto.getKodeGudang());
    e.setKodeKantor(dto.getKodeKantor());
    e.setAlamat(dto.getAlamat());
    e.setLatitude(dto.getLatitude());
    e.setLongitude(dto.getLongitude());
    return e;
  }

  public static GudangResponse toDto(Gudang e) {
    GudangResponse dto = new GudangResponse();
    dto.setId(e.getId());
    dto.setKodeGudang(e.getKodeGudang());
    dto.setKodeKantor(e.getKodeKantor());
    dto.setAlamat(e.getAlamat());
    dto.setLatitude(e.getLatitude());
    dto.setLongitude(e.getLongitude());
    dto.setWaktuRekam(e.getWaktuRekam());
    dto.setWaktuUpdate(e.getWaktuUpdate());
    return dto;
  }

  public static Kontainer toEntity(KontainerRequest dto) {
    Kontainer e = new Kontainer();
    e.setKodeGudang(dto.getKodeGudang());
    e.setKodeKantor(dto.getKodeKantor());
    e.setNomorKontainer(dto.getNomorKontainer());
    e.setUkuranKontainer(dto.getUkuranKontainer());
    e.setTanggalTiba(dto.getTanggalTiba());
    e.setBruto(dto.getBruto());
    e.setNomorDokumen(dto.getNomorDokumen());
    return e;
  }

  public static KontainerResponse toDto(Kontainer e) {
    KontainerResponse dto = new KontainerResponse();
    dto.setId(e.getId());
    dto.setKodeGudang(e.getKodeGudang());
    dto.setKodeKantor(e.getKodeKantor());
    dto.setNomorKontainer(e.getNomorKontainer());
    dto.setUkuranKontainer(e.getUkuranKontainer());
    dto.setTanggalTiba(e.getTanggalTiba());
    dto.setBruto(e.getBruto());
    dto.setNomorDokumen(e.getNomorDokumen());
    dto.setWaktuRekam(e.getWaktuRekam());
    return dto;

  }




}


