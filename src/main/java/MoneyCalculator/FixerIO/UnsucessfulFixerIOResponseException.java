package MoneyCalculator.FixerIO;

import com.google.gson.JsonObject;

public class UnsucessfulFixerIOResponseException extends Exception {
    public UnsucessfulFixerIOResponseException(JsonObject jsonObject) {
        super(jsonObject.getAsJsonObject("error").getAsJsonPrimitive("type").getAsString());
    }
}
