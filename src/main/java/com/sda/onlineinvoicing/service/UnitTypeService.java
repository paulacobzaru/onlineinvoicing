package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.UnitType;
import java.util.List;

public interface UnitTypeService {

    List<UnitType> getAllUnitTypes();

    void saveUnitType(UnitType unitType);

    void deleteUnitType(int unitType);

    UnitType getUnitTypeById(int unitType);
}
