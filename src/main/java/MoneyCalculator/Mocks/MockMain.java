package MoneyCalculator.Mocks;

import MoneyCalculator.*;

import java.util.List;

public class MockMain {
    public static void main(String[] args) {
        List<Currency> currencies = new MockCurrencyLoader().load();
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        WriteExchangeRateDialog writeExchangeRateDialog = new MockWriteExchangeRateDialog();
        ExchangeRateWriter exchangeRateWriter = new MockExchangeRateWriter();
        Command exchangeMoneyCommand = new ExchangeMoneyCommand(currencyDialog, moneyDialog, moneyDisplay, exchangeRateLoader, writeExchangeRateDialog, exchangeRateWriter);
        exchangeMoneyCommand.execute();
    }
}
