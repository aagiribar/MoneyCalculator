package MoneyCalculator.Swing;

import MoneyCalculator.Money;
import MoneyCalculator.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    private final JTextField resultField;

    public SwingMoneyDisplay() {
        JTextField resultField = new JTextField(10);
        resultField.setEnabled(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);
        add(resultField);
        this.resultField = resultField;
    }

    @Override
    public void show(Money money) {
        resultField.setText(money.amount() + " " + money.currency().code());
    }
}
