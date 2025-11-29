package com.example.ecommerce.service;

import com.example.ecommerce.dto.SuperAdminDto;

import java.util.List;

public interface SuperAdminService {

    SuperAdminDto save(SuperAdminDto superAdminDto);

    SuperAdminDto get(Long id);

    List<SuperAdminDto> getAll();

    void delete(Long id);
}
