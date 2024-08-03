package dz.currencyconverter.services;

import java.io.IOException; // Provides the IOException class for handling input and output errors.
import java.util.List; // Provides the List interface for ordered collections that can contain duplicate elements and allow random access.
import java.util.stream.Collectors; // Provides utility methods for collecting the results of stream operations into collections such as lists or sets.
import dz.currencyconverter.models.Currency;
import dz.currencyconverter.repository.Converter;


public class CurrencyService {
    private final Converter converter;

    public CurrencyService(Converter converter) {
        this.converter = converter;
    }
    public Double convert(String from,String to,Double amount) throws IOException{
       return  converter.convert(from, to, amount);
    }
    public List<Currency>getAllCurrencies() throws IOException{
        return converter.getAllCurrencies();
    }
    public List<Currency>findCurrency(List<Currency> list,String symbol){
        String symbol2=toUpperCase(symbol);
        return list.stream().filter(currency->currency.getSymbol()
                .contains(symbol2))
                .collect(Collectors.toList());
    }
    public List<String>getAllSymbols(List<Currency> list){
        return converter.getAllSymbols(list);
    }
    private String toUpperCase(String str){
    String st="";
        for (int i = 0; i < str.length(); i++) {
        	// Convert the current character to uppercase and append it to the result string.
            st+=Character.toUpperCase(str.charAt(i))+"";
        }
     // Return the resulting string with all characters in uppercase"
   return st; }
}
