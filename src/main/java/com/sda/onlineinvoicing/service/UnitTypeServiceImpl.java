package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.UnitType;
import com.sda.onlineinvoicing.repository.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitTypeServiceImpl implements UnitTypeService {

    @Autowired
    UnitTypeRepository unitTypeRepository;

    @Override
    public List<UnitType> getAllUnitTypes() {
        return unitTypeRepository.findAll();
    }

    @Override
    public void saveUnitType(UnitType unitType) {
        unitTypeRepository.save(unitType);
    }

    @Override
    public void deleteUnitType(int unitTypeId) {
unitTypeRepository.deleteById(unitTypeId);
    }

    @Override
    public UnitType getUnitTypeById(int unitTypeId) {
        return unitTypeRepository.findById(unitTypeId).orElse(new UnitType());
    }
}
