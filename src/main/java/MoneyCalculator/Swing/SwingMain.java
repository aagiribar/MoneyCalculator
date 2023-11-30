package MoneyCalculator.Swing;

import MoneyCalculator.*;
import MoneyCalculator.FixerIO.FixerIOCurrencyLoader;
import MoneyCalculator.FixerIO.FixerIOExchangeRateLoader;
import MoneyCalculator.FixerIO.FixerIOURLBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {

    private final Map<String, Command> commands = new HashMap<>();
    private CurrencyDialog currencyDialog;
    private SwingMoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader exchangeRateLoader;
    private WriteExchangeRateDialog writeExchangeRateDialog;
    private final ExchangeRateWriter exchangeRateWriter;

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        CurrencyLoader loader = new FixerIOCurrencyLoader(new FixerIOURLBuilder());
        List<Currency> currencies = loader.load();
        main.moneyDialog.define(currencies);
        main.currencyDialog.define(currencies);
        Command command = new ExchangeMoneyCommand(
                main.currencyDialog,
                main.moneyDialog,
                main.moneyDisplay,
                main.exchangeRateLoader,
                main.writeExchangeRateDialog,
                main.exchangeRateWriter
        );
        main.add("Exchange Money", command);
        main.setVisible(true);
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }

    public SwingMain() throws HeadlessException {
        setTitle("Money Calculator");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        add(createMoneyDialog());
        add(createCurrencyDialog());
        add(createCalculateButton());
        add(createWriteFileDialog());
        add(createMoneyDisplay());
        exchangeRateLoader = new FixerIOExchangeRateLoader(new FixerIOURLBuilder());
        exchangeRateWriter = new FileExchangeRateWriter("rates.csv");
    }

    private Component createCalculateButton() {
        Button button = new Button("Calculate");
        button.addActionListener(e -> commands.get("Exchange Money").execute());
        return button;
    }

    private Component createWriteFileDialog() {
        SwingWriteExchangeRateDialog dialog = new SwingWriteExchangeRateDialog();
        this.writeExchangeRateDialog = dialog;
        return dialog;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }
}
