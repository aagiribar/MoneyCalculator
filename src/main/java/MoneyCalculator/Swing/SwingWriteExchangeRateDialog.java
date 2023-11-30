package MoneyCalculator.Swing;

import MoneyCalculator.WriteExchangeRateDialog;

import javax.swing.*;

public class SwingWriteExchangeRateDialog extends JPanel implements WriteExchangeRateDialog {

    private final JCheckBox button;

    public SwingWriteExchangeRateDialog() {
        JCheckBox button = new JCheckBox("Save exchange rate");
        button.setSelected(false);
        add(button);
        this.button = button;
    }

    @Override
    public boolean get() {
        return button.isSelected();
    }
}
