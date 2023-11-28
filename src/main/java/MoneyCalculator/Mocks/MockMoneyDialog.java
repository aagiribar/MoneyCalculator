package MoneyCalculator.Mocks;

import MoneyCalculator.Currency;
import MoneyCalculator.Money;
import MoneyCalculator.MoneyDialog;

import java.util.List;

public class MockMoneyDialog implements MoneyDialog {
    private List<Currency> currencies;

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Money get() {
        return new Money(230.00, currencies.get(0));
    }
}
