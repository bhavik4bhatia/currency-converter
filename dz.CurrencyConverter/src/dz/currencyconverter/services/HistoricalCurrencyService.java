package dz.currencyconverter.services;

import java.io.IOException;
import java.util.List;
import dz.currencyconverter.models.HistoricalCurrency;
import dz.currencyconverter.repository.Converter;


public class HistoricalCurrencyService {
    private final Converter converter;

    public HistoricalCurrencyService(Converter converter) {
        this.converter = converter;
    }
    public List<HistoricalCurrency> HistoricalDataCurrency(String base
            ,Integer durationDay,String symbol) throws IOException{
        return converter.getHistoricalVlues(base, durationDay, symbol);
    }
}
