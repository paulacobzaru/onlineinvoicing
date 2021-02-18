package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> getAllCurrencies();

    void saveCurrency(Currency currency);

    void deleteCurrency(int currencyId);

    Currency getCurrencyById(int currencyId);
}
