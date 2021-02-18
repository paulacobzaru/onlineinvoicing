package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.VatRate;
import com.sda.onlineinvoicing.repository.VatRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VatRateServiceImpl implements VatRateService {

    @Autowired
    VatRateRepository vatRateRepository;

    @Override
    public List<VatRate> getAllVatRates() {
        return vatRateRepository.findAll();
    }

    @Override
    public void saveVatRate(VatRate vatRate) {
        vatRateRepository.save(vatRate);
    }

    @Override
    public void deleteVatRate(int vatRateId) {
        vatRateRepository.deleteById(vatRateId);
    }

    @Override
    public VatRate getVatRateById(int vatRateId) {
        return vatRateRepository.findById(vatRateId).orElse(new VatRate());
    }
}
