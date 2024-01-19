package MoneyCalculator;

import MoneyCalculator.FixerIO.UnsucessfulFixerIOResponseException;

public class ExchangeMoneyCommand implements Command{
    private final CurrencyDialog currencyDialog;
    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader exchangeRateLoader;
    private final WriteExchangeRateDialog writeExchangeRateDialog;
    private final ExchangeRateWriter exchangeRateWriter;

    public ExchangeMoneyCommand(CurrencyDialog currencyDialog, MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, ExchangeRateLoader exchangeRateLoader, WriteExchangeRateDialog writeExchangeRateDialog, ExchangeRateWriter exchangeRateWriter) {
        this.currencyDialog = currencyDialog;
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.exchangeRateLoader = exchangeRateLoader;
        this.writeExchangeRateDialog = writeExchangeRateDialog;
        this.exchangeRateWriter = exchangeRateWriter;
    }

    @Override
    public void execute() throws UnsucessfulFixerIOResponseException {
        Currency to = currencyDialog.get();
        Money money = moneyDialog.get();
        boolean writeFile = writeExchangeRateDialog.get();

        ExchangeRate exchangeRate = null;
        exchangeRate = exchangeRateLoader.load(money.currency(), to);

        Money result = new Money(calculateDestinationAmount(money.amount(), exchangeRate.rate()), to);

        if(writeFile) exchangeRateWriter.write(exchangeRate);
        moneyDisplay.show(result);
    }

    private double calculateDestinationAmount(double amount, double rate) {
        return amount * rate;
    }
}
