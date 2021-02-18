package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.UnitType;
import com.sda.onlineinvoicing.service.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UnitTypeController {

    @Autowired
    UnitTypeService unitTypeService;

    @GetMapping("/app/unit_type")
    public String unitTypes(Model model) {
        model.addAttribute("unitType", new UnitType());
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        return "/app/unit_type";
    }

    @PostMapping("/app/unit_type/saveUnitType")
    public String saveUnitType(Model model, UnitType unitType) {
        unitTypeService.saveUnitType(unitType);
        model.addAttribute("unitType", new UnitType());
        model.addAttribute("message", "Your unit type is saved!");
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        return "/app/unit_type";
    }

    @GetMapping("/app/unit_type/edit/{unitTypeId}")
    public String editUitType(@PathVariable("unitTypeId") int unitTypeId, Model model){
        model.addAttribute("unitType", unitTypeService.getUnitTypeById(unitTypeId));
        model.addAttribute("unitTypeList",unitTypeService.getAllUnitTypes());
        return "/app/unit_types";
    }

    @GetMapping("/app/unit_type/delete/{uniTypeId}")
    public String deleteUnitType(@PathVariable("unitTypeId") int unitTypeId, Model model){
        unitTypeService.getUnitTypeById(unitTypeId);
        model.addAttribute("message", "Your unit type is saved!");
        return "redirect:/app/unit_type";
    }
}
