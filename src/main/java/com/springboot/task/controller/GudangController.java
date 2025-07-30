package com.springboot.task.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.task.dto.GudangRequest;
import com.springboot.task.dto.GudangResponse;
import com.springboot.task.mapper.DtoMapper;
import com.springboot.task.model.pojo.Gudang;
import com.springboot.task.service.GudangService;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gudang")
@RequiredArgsConstructor
@Tag(name = "Gudang")
public class GudangController {

  private final GudangService gudangService;

  @PostMapping
  @Operation(summary = "Create Gudang")
  public ResponseEntity<DataResponse<GudangResponse>> create(@Valid @RequestBody GudangRequest request) {
    Gudang gudangSaved = gudangService.createGudang(DtoMapper.toEntity(request)).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(gudangSaved)));

  }

  @PutMapping("/{id}")
  @Operation(summary = "Update Gudang")
  public ResponseEntity<DataResponse<GudangResponse>> update(@PathVariable Long id, @Valid @RequestBody GudangRequest request) {
    Gudang gudangUpdated = gudangService.updateGudang(id, DtoMapper.toEntity(request)).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(gudangUpdated)));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete Gudang")
  public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
    return ResponseEntity.ok(gudangService.deleteGudang(id));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get Gudang by ID")
  public ResponseEntity<DataResponse<GudangResponse>> get(@PathVariable Long id) {
    Gudang gudang = gudangService.getGudang(id).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(gudang)));
  }

  @GetMapping("/findAll")
  @Operation(summary = "Get all Gudang")
  public ResponseEntity<ListResponse<GudangResponse>> getAll() {
    var list = gudangService.getAllGudang().getData().stream()
      .map(DtoMapper::toDto)
      .toList();
    return ResponseEntity.ok(new ListResponse<>(list));
  }

  @GetMapping("/find")
  @Operation(summary = "Get Gudang by kode_kantor")
  public ResponseEntity<ListResponse<GudangResponse>> search(@RequestParam String kode_kantor) {
    var list = gudangService.findByKodeKantor(kode_kantor).getData().stream()
      .map(DtoMapper::toDto)
      .toList();
    return ResponseEntity.ok(new ListResponse<>(list));
  }

  @GetMapping
  @Operation(summary = "Paginate all Gudang")
  public ResponseEntity<DatatableResponse<GudangResponse>> paginate(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int limit) {
    var paginate = gudangService.paginateGudang(page, limit);
    var list = paginate.getData().stream()
      .map(DtoMapper::toDto)
      .toList();
    return ResponseEntity.ok(new DatatableResponse<>(
      list, 
      paginate.getMeta().getItemPerPage(), 
      paginate.getMeta().getTotal(), 
      paginate.getMeta().getTotalPage())
    );
  }

}
