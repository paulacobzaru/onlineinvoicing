package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Currency;
import com.sda.onlineinvoicing.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public void saveCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    @Override
    public void deleteCurrency(int currencyId) {
        currencyRepository.deleteById(currencyId);
    }

    @Override
    public Currency getCurrencyById(int currencyId) {
        return currencyRepository.findById(currencyId).orElse(new Currency());
    }


}
