package dz.currencyconverter.repository;

import java.io.IOException; // Signals that an I/O exception of some sort has occurred, often used for error handling in I/O operations
import java.net.MalformedURLException; // Indicates that a malformed URL has occurred, "typically used for handling URL formatting issues
import java.util.List; // Represents a collection of elements that can be accessed by index and allows duplicates, part of Java's Collections Framework
import dz.currencyconverter.models.Currency;
import dz.currencyconverter.models.HistoricalCurrency;


public interface Converter {
    Double convert(String from,String to,Double value) 
            throws MalformedURLException, IOException;
    List<Currency> getAllCurrencies() throws MalformedURLException,IOException;
    List<String> getAllSymbols(List<Currency> list);
 // Retrieves historical currency values for a given base and target currency over a specified number of days"
    List<HistoricalCurrency> getHistoricalVlues(String base,Integer durationDays,String symbol)
            throws MalformedURLException,IOException;
}
