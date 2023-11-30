package MoneyCalculator.Swing;

import MoneyCalculator.Currency;
import MoneyCalculator.CurrencyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private JComboBox<Currency> comboBox;

    public SwingCurrencyDialog() {

    }

    private Component createComboBox(List<Currency> currencies) {
        JComboBox<Currency> currencyJComboBox = new JComboBox<>();
        for (Currency currency : currencies) {
            currencyJComboBox.addItem(currency);
        }
        this.comboBox = currencyJComboBox;
        return comboBox;
    }

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        add(createComboBox(currencies));
        return this;
    }

    @Override
    public Currency get() {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }
}
