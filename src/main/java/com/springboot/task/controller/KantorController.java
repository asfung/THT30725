package com.springboot.task.controller;


import javax.servlet.http.HttpServletRequest;
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

import com.springboot.task.dto.KantorRequest;
import com.springboot.task.dto.KantorResponse;
import com.springboot.task.mapper.DtoMapper;
import com.springboot.task.model.pojo.Kantor;
import com.springboot.task.service.KantorService;
import com.springboot.task.utils.response.DataResponse;
import com.springboot.task.utils.response.DatatableResponse;
import com.springboot.task.utils.response.DefaultResponse;
import com.springboot.task.utils.response.ListResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kantor")
@RequiredArgsConstructor
@Tag(name = "Kantor")
public class KantorController {
  private final KantorService kantorService;

  @PostMapping
  @Operation(summary = "Create Kantor")
  public ResponseEntity<DataResponse<KantorResponse>> create(@Valid @RequestBody KantorRequest kantorRequest) {
    Kantor kandtoSaved = kantorService.createKantor(DtoMapper.toEntity(kantorRequest)).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(kandtoSaved)));

  }

  @PutMapping("/{id}")
  @Operation(summary = "Update Kantor")
  public ResponseEntity<DataResponse<KantorResponse>> update(@PathVariable Long id, @Valid @RequestBody KantorRequest kantorRequest) {
    Kantor kantorUpdated = kantorService.updateKantor(id, DtoMapper.toEntity(kantorRequest)).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(kantorUpdated)));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete Kantor")
  public ResponseEntity<DefaultResponse> delete(@PathVariable Long id) {
    return ResponseEntity.ok(kantorService.deleteKantor(id));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get Kantor by ID")
  public ResponseEntity<DataResponse<KantorResponse>> get(@PathVariable Long id) {
    Kantor kantor = kantorService.getKantor(id).getData();
    return ResponseEntity.ok(new DataResponse<>(DtoMapper.toDto(kantor)));
  }

  @GetMapping("/findAll")
  @Operation(summary = "Get all Kantor")
  public ResponseEntity<ListResponse<KantorResponse>> getAll() {
    var list = kantorService.getAllKantor().getData().stream()
      .map(DtoMapper::toDto)
      .toList();
    return ResponseEntity.ok(new ListResponse<>(list));
  }

  @GetMapping
  @Operation(summary = "Paginate all Kantor")
  public ResponseEntity<DatatableResponse<KantorResponse>> paginate(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int limit,
      HttpServletRequest request) {

    var paginate = kantorService.paginateKantor(page, limit);
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
