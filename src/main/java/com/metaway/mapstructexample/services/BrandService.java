package com.metaway.mapstructexample.services;

import com.metaway.mapstructexample.dto.BrandDTO;
import com.metaway.mapstructexample.entities.Brand;
import com.metaway.mapstructexample.mappers.BrandMapper;
import com.metaway.mapstructexample.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    @Autowired
    private BrandMapper brandMapper;

    @Transactional(readOnly = true)
    public List<BrandDTO> findAll(){
        List<Brand> list = repository.findAll();
        return brandMapper.entityListToDTOList(list);
    }

    @Transactional(readOnly = true)
    public BrandDTO findById(Long id){
        Brand entity = repository.findById(id).get();
        return brandMapper.entityToDTO(entity);
    }

    @Transactional
    public BrandDTO insert(BrandDTO dto){
        Brand entity = brandMapper.dtoToEntity(dto);
        entity = repository.save(entity);
        return brandMapper.entityToDTO(entity);
    }
}
