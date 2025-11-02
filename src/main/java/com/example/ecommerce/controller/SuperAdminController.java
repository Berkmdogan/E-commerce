package com.example.ecommerce.controller;


import com.example.ecommerce.dto.SuperAdminDto;
import com.example.ecommerce.mapper.SuperAdminMapper;
import com.example.ecommerce.request.SuperAdminRequest;
import com.example.ecommerce.response.SuperAdminResponse;
import com.example.ecommerce.service.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/super-admin")
public class SuperAdminController {
    private final SuperAdminService superAdminService;

    @PostMapping("/create")
    public ResponseEntity<SuperAdminResponse> createSuperAdmin(@RequestBody SuperAdminRequest superAdminRequest) {
        SuperAdminDto superAdminDto = SuperAdminMapper.toDto(superAdminRequest);
        SuperAdminDto savedSuperAdmin = superAdminService.save(superAdminDto);
        return ResponseEntity.ok(SuperAdminMapper.toResponse(savedSuperAdmin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperAdminResponse> getSuperAdmin(@PathVariable Long id) {
        SuperAdminDto superAdminDto = superAdminService.get(id);
        return ResponseEntity.ok(SuperAdminMapper.toResponse(superAdminDto));
    }

    @GetMapping
    public ResponseEntity<List<SuperAdminResponse>> getAllSuperAdmins() {
        List<SuperAdminDto> superAdminDtos = superAdminService.getAll();
        List<SuperAdminResponse> responses = superAdminDtos.stream()
                .map(SuperAdminMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuperAdmin(@PathVariable Long id) {
        superAdminService.delete(id);
        return ResponseEntity.ok("SuperAdmin deleted successfully");
    }
}
