package com.springboot.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.task.dto.KontainerRequest;
import com.springboot.task.dto.KontainerResponse;
import com.springboot.task.mapper.DtoMapper;
import com.springboot.task.model.pojo.Kontainer;
import com.springboot.task.service.KontainerService;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kontainer")
@RequiredArgsConstructor
@Tag(name = "Kontainer")
public class KontainerController {

  private final KontainerService kontainerService;

  @PostMapping
  @Operation(summary = "Create Kontainer")
  public ResponseEntity<DataResponse<KontainerResponse>> create(@Validated @RequestBody KontainerRequest request) {
    Kontainer kontainerSaved = kontainerService.createKontainer(DtoMapper.toEntity(request)).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(kontainerSaved)));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update Kontainer")
  public ResponseEntity<DataResponse<KontainerResponse>> update(@PathVariable Long id,
      @Validated @RequestBody KontainerRequest kontainer) {

      Kontainer kontainerUpdated = kontainerService.updateKontainer(id, DtoMapper.toEntity(kontainer)).getData();
      return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(kontainerUpdated)));

  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete Kontainer")
  public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
    return ResponseEntity.ok(kontainerService.deleteKontainer(id));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get Kontainer by ID")
  public ResponseEntity<DataResponse<KontainerResponse>> get(@PathVariable Long id) {
    Kontainer kontainer = kontainerService.getKontainer(id).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(kontainer)));
  }

  @GetMapping("/findAll")
  @Operation(summary = "Get all Kontainer")
  public ResponseEntity<ListResponse<KontainerResponse>> getAll() {
    var list = kontainerService.getAllKontainer().getData().stream()
      .map(DtoMapper::toDto)
      .toList();
    return ResponseEntity.ok(new ListResponse<>(list));
  }

  @GetMapping("/find")
  @Operation(summary = "Get Kontainer by kode_gudang, kode_kantor, nomor_dokumen")
  public ResponseEntity<ListResponse<KontainerResponse>> search(
      @RequestParam String kode_gudang,
      @RequestParam String kode_kantor,
      @RequestParam String nomor_dokumen) {
    var list = kontainerService.findByGudangKantorDokumen(kode_gudang, kode_kantor, nomor_dokumen).getData()
      .stream()
      .map(DtoMapper::toDto)
      .toList();

    return ResponseEntity.ok(new ListResponse<>(list));

  }

  @GetMapping
  @Operation(summary = "Paginate all Kontainer")
  public ResponseEntity<DatatableResponse<KontainerResponse>> paginate(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int limit) {
    var paginate = kontainerService.paginateKontainer(page, limit);
    var list = paginate.getData().stream().map(DtoMapper::toDto).toList();
    return ResponseEntity.ok(new DatatableResponse<>(
      list, 
      paginate.getMeta().getItemPerPage(), 
      paginate.getMeta().getTotal(), 
      paginate.getMeta().getTotalPage())
    );
  }

}
