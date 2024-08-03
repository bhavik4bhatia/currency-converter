package dz.currencyconverter.models;

/**
 * "Represents historical currency data including base currency, symbol, day, and value.
 */
public class HistoricalCurrency {
    private String base;
    private String symbol;
    private String day;
    private Double value;

    public HistoricalCurrency(String base, String symbol, String day, Double value) {
        this.base = base;
        this.symbol = symbol;
        this.day = day;
        this.value = value;
    }

    public String getDay() {
        return day;
    }

    public Double getValue() {
        return value;
    }
    
    /**
     * Returns a string representation of the HistoricalCurrency object.
     * @return A string representation including base, symbol, day, and value."
     */

    @Override
    public String toString() {
        return "HistoricalCurrency{" + "base=" + base + ", symbol=" + symbol + ", day=" + day + ", value=" + value + '}';
    }
    
}
