package MoneyCalculator.Mocks;

import MoneyCalculator.Currency;
import MoneyCalculator.ExchangeRate;
import MoneyCalculator.ExchangeRateLoader;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(new Currency("Euro", "EUR"),
                new Currency("United States Dollar", "USD"),
                1.09808,
                LocalDate.now());
    }
}
