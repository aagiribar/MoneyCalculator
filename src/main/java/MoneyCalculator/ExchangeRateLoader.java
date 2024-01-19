package MoneyCalculator;

import MoneyCalculator.FixerIO.UnsucessfulFixerIOResponseException;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to) throws UnsucessfulFixerIOResponseException;
}
