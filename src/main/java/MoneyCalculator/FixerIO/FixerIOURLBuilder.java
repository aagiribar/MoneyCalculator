package MoneyCalculator.FixerIO;

import MoneyCalculator.URLBuilder;

public class FixerIOURLBuilder implements URLBuilder {
    private final String key = "769c0f38e203578c3d415a9053d66c07";

    @Override
    public String exchangeRate(String from, String to) {
        return "http://data.fixer.io/api/latest" +
                "?access_key=" + key +
                "&base=" + from +
                "&symbols=" + to;
    }

    @Override
    public String currencyCodes() {
        return "http://data.fixer.io/api/symbols?access_key=" + key;
    }
}
