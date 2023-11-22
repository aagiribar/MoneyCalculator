package MoneyCalculator.FixerIO;

import MoneyCalculator.Currency;
import MoneyCalculator.CurrencyLoader;
import MoneyCalculator.URLBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FixerIOCurrencyLoader implements CurrencyLoader {

    private final URLBuilder urlBuilder;

    public FixerIOCurrencyLoader(URLBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @Override
    public List<Currency> load() {
        String contents = loadJSONContentsFromURL();
        Map<String, JsonElement> symbolsMap = getSymbolsMap(contents);
        List<Currency> currencies = new ArrayList<>();
        for (String symbol : symbolsMap.keySet()) {
            currencies.add(new Currency(symbolsMap.get(symbol).getAsString(), symbol));
        }
        return currencies;
    }

    private Map<String, JsonElement> getSymbolsMap(String contents) {
        Gson gson = new Gson();
        return gson.fromJson(contents, JsonObject.class).getAsJsonObject("symbols").asMap();
    }

    private String loadJSONContentsFromURL() {
        try {
            URL url = new URL(urlBuilder.currencyCodes());
            try (InputStream is = url.openStream()) {
                return new String(is.readAllBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
