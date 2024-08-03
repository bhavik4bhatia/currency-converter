package dz.currencyconverter.repository;

import java.io.IOException; // Provides the IOException class for handling input and output errors.
import java.net.MalformedURLException; // Provides the MalformedURLException class for handling errors related to invalid URL formats.
import java.time.LocalDate; // Provides the LocalDate class for representing dates without time information.
import java.util.ArrayList; // Provides the ArrayList class, a resizable array implementation of the List interface.
import java.util.Collections; // Provides utility methods for working with collections, such as sorting and unmodifiable views.
import java.util.List; // Provides the List interface for ordered collections that can contain duplicate elements and "allow random access.
import java.util.stream.Collectors;
import dz.currencyconverter.connectionApi.ApiConnection;
import dz.currencyconverter.connectionApi.JsonConversion;
import dz.currencyconverter.models.Currency;
import dz.currencyconverter.models.HistoricalCurrency;


public class ConverterImp implements Converter{
   private ApiConnection apiConnection;
   private JsonConversion jsonConversion;

    public ConverterImp(ApiConnection ApiConnection, JsonConversion JsonConversion) {
        this.apiConnection = ApiConnection;
        this.jsonConversion = JsonConversion;
    }
   
    @Override
    public Double convert(String from, String to, Double value)
            throws MalformedURLException, IOException {
      StringBuilder sb=apiConnection.getRate(from, to, value);
      Double result=jsonConversion.getDataConversion(sb);
    return result;}

    @Override
    public List<Currency> getAllCurrencies()
            throws MalformedURLException,IOException{
     List<Currency> listCurrencies=new ArrayList();
      StringBuilder sb=apiConnection.getSymbolsWithSignification();
      String SymbolsSignification[]=jsonConversion.getDataSymbols(sb);
        for (String line : SymbolsSignification) {
            String tmp[]=line.split(":");
            String symbol=tmp[0].replace("{", "").replace("\"", "");
            String signification=tmp[1].replace("}", "").replace("\"", "");
            Currency currency=new Currency(symbol, signification);
            listCurrencies.add(currency);
        }
    return listCurrencies;}

    @Override
    public List<String> getAllSymbols(List<Currency> list) {
      List<String> listSymbols=list.stream().map(currency->currency.getSymbol())
              .collect(Collectors.toList());
      Collections.sort(listSymbols);
    return listSymbols;}

    @Override
    public List<HistoricalCurrency> getHistoricalVlues(String base, Integer durationDays, String symbol) throws IOException {
     LocalDate today=LocalDate.now();
     LocalDate dayAgo=today.minusDays(durationDays);
     
     StringBuilder sb=apiConnection.getHistoricalCurrency(base, dayAgo, today, symbol);
     String historicalValue[]=jsonConversion.getDataHistoricalCurrency(sb);
     List<HistoricalCurrency> listhistCurr=new ArrayList();
        for (String line : historicalValue) {
         String dayHis=line.subSequence(1, 12).toString().replace("\"", "");
        Double value= Double.parseDouble(line.subSequence(20, 27).toString().replace(":", ""));
        HistoricalCurrency historicalCurrency=new 
        HistoricalCurrency(base, symbol, dayHis, value);
        listhistCurr.add(historicalCurrency);
        }
     // Sorts the list of HistoricalCurrency objects based on the 'day' field in ascending order"
        Collections.sort(listhistCurr,(o1,o2)->{
        return o1.getDay().compareTo(o2.getDay());
        });
    return listhistCurr;}
    
}
