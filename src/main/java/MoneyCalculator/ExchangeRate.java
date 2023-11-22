package MoneyCalculator;

public class ExchangeRate {
    private final Money money;
    private final Currency from;
    private final Currency to;

    public ExchangeRate(Money money, Currency to) {
        this.money = money;
        this.from = money.currency();
        this.to = to;
    }
}
