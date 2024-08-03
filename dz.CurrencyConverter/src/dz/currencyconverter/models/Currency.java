package dz.currencyconverter.models;

/**
 * "Represents a currency with its symbol and signification.
 */
public class Currency {
    private String symbol;
    private String signification;

    public Currency(String symbol, String siginification) {
        this.symbol = symbol;
        this.signification = siginification;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSignification() {
        return signification;
    }
    
    /**
     * Returns a string representation of the Currency object.
     * @return A string representation including symbol and signification."
     */

    @Override
    public String toString() {
        return "Currency{" + "symbol=" + symbol + ", signification=" + signification + '}';
    }
    
}
