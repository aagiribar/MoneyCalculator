package MoneyCalculator.Mocks;

import MoneyCalculator.Currency;
import MoneyCalculator.CurrencyLoader;

import java.util.ArrayList;
import java.util.List;

public class MockCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> load() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("Euro", "EUR"));
        currencies.add(new Currency("United States Dollar", "USD"));
        currencies.add(new Currency("Canadian Dollar", "CAD"));
        currencies.add(new Currency("Great British Pound", "GBP"));
        currencies.add(new Currency("Japanese Yen", "JPY"));
        return currencies;
    }
}
