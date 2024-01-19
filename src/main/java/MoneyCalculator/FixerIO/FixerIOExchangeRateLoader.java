package MoneyCalculator.FixerIO;

import MoneyCalculator.Currency;
import MoneyCalculator.ExchangeRate;
import MoneyCalculator.ExchangeRateLoader;
import MoneyCalculator.URLBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

public class FixerIOExchangeRateLoader implements ExchangeRateLoader {

    private final URLBuilder urlBuilder;

    public FixerIOExchangeRateLoader(URLBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) throws UnsucessfulFixerIOResponseException {
        String contents = loadJSONContentsfromURL(from.code(), to.code());
        JsonObject jsonObject = getJsonObjectFrom(contents);
        if (!checkResponse(jsonObject)) throw new UnsucessfulFixerIOResponseException(jsonObject);
        double rate = getRateFrom(jsonObject, to.code());
        LocalDate date = getDateFrom(jsonObject);
        return new ExchangeRate(from, to, rate, date);
    }

    private boolean checkResponse(JsonObject jsonObject) {
        return jsonObject.getAsJsonPrimitive("success").getAsBoolean();
    }

    private LocalDate getDateFrom(JsonObject jsonObject) {
        return LocalDate.parse(jsonObject.getAsJsonPrimitive("date").getAsString());
    }

    private double getRateFrom(JsonObject jsonObject, String to) {
        return jsonObject.getAsJsonObject("rates").getAsJsonPrimitive(to).getAsDouble();
    }

    private JsonObject getJsonObjectFrom(String contents) {
        Gson gson = new Gson();
        return gson.fromJson(contents, JsonObject.class);
    }

    private String loadJSONContentsfromURL(String from, String to) {
        try {
            URL url = new URL(urlBuilder.exchangeRate(from, to));
            try (InputStream is = url.openStream()) {
                return new String(is.readAllBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
