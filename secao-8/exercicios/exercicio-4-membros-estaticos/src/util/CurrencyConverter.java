package util;

public class CurrencyConverter {

    public static final double IOF = 0.06;

    public static double amount(double dollarPrice, double dollarAmount) {
        return dollarAmount * dollarPrice * (1.0 + IOF);
    }
}
