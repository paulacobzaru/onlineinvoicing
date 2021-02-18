package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.VatRate;

import java.util.List;

public interface VatRateService {

    List<VatRate> getAllVatRates();

    void saveVatRate(VatRate vatRate);

    void deleteVatRate(int vatRateId);

    VatRate getVatRateById(int vatRateId);
}
