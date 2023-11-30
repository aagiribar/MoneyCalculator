package MoneyCalculator.Swing;

import MoneyCalculator.Currency;
import MoneyCalculator.Money;
import MoneyCalculator.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private JTextField amountField;
    private JComboBox<Currency> comboBox;

    public SwingMoneyDialog() {
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        add(creteAmountField());
        add(createComboBox(currencies));
        return this;
    }

    private Component createComboBox(List<Currency> currencies) {
        JComboBox<Currency> comboBox = new JComboBox<>();
        for (Currency currency : currencies) {
            comboBox.addItem(currency);
        }
        this.comboBox = comboBox;
        return comboBox;
    }

    private Component creteAmountField() {
        this.amountField = new JTextField(5);
        return amountField;
    }

    @Override
    public Money get() {
        double amount = Double.parseDouble(amountField.getText());
        Currency currency = comboBox.getItemAt(comboBox.getSelectedIndex());
        return new Money(amount, currency);
    }
}
