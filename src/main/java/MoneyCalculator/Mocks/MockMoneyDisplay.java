package MoneyCalculator.Mocks;

import MoneyCalculator.Money;
import MoneyCalculator.MoneyDisplay;

public class MockMoneyDisplay implements MoneyDisplay {
    @Override
    public void show(Money money) {
        System.out.println(money.amount() + " " + money.currency().code());
    }
}
