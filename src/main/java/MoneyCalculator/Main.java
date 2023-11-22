package MoneyCalculator;

import MoneyCalculator.FixerIO.FixerIOCurrencyLoader;
import MoneyCalculator.FixerIO.FixerIOExchangeRateLoader;
import MoneyCalculator.FixerIO.FixerIOURLBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader loader = new FixerIOCurrencyLoader(new FixerIOURLBuilder());
        List<Currency> currencies = loader.load();
        for (int i = 0; i < currencies.size(); i++) {
            System.out.println(i + ": " + currencies.get(i));
        }
        Currency euro = currencies.get(46);
        Currency dollar = currencies.get(150);
        ExchangeRateLoader exchangeRateLoader = new FixerIOExchangeRateLoader(new FixerIOURLBuilder());
        ExchangeRate exchangeRate = exchangeRateLoader.load(euro, dollar);
        System.out.println(exchangeRate);
    }
}
